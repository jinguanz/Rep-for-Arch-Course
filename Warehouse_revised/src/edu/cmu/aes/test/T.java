package edu.cmu.aes.test;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.soa.esb.actions.StoreMessageToFile;

public class T {
	
	static QueueConnection conn;
    static QueueSession session;
    static Queue que;
    static QueueSender sender = null;
	
	public static void main(String args[])
	{
		
		try {
		//Setup jms connection
			
		Properties env = new Properties();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory" );
		env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		 env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
		    
		InitialContext iniCtx = new InitialContext(env);
    	Object tmp = iniCtx.lookup("ConnectionFactory");
    	QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
    	conn = qcf.createQueueConnection();
    	que = (Queue) iniCtx.lookup("queue/quickstart_webservice_producer_gw");
    	session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
    	conn.start();
    	
    	
            ObjectMessage tm = null;

            sender = session.createSender(que);
            tm = session.createObjectMessage("");
            tm.setStringProperty(StoreMessageToFile.PROPERTY_JBESB_FILENAME, "WebServiceProducerTest.log");
            sender.send(tm);
        } catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if(sender != null) {
                try {
					sender.close();
				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
            try {
				cleanupJMSConnection();
			} catch (JMSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	public static void cleanupJMSConnection() throws JMSException
    {
        conn.stop();
        session.close();
        conn.close();
    }

}
