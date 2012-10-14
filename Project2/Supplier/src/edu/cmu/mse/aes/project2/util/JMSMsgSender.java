package edu.cmu.mse.aes.project2.util;

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
//import org.jboss.soa.esb.message.Message;
import javax.jms.Message;


public class JMSMsgSender {

    QueueConnection conn;
    QueueSession session;
    Queue que;
    
    
    private void setupConnection(String queueName) throws JMSException, NamingException
    {
        Properties properties1 = new Properties();
		properties1.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		properties1.put(Context.URL_PKG_PREFIXES,
				"org.jboss.naming:org.jnp.interfaces");
		properties1.put(Context.PROVIDER_URL, "jnp://127.0.0.1:1099");
		InitialContext iniCtx = new InitialContext(properties1);

    	Object tmp = iniCtx.lookup("ConnectionFactory");
    	QueueConnectionFactory qcf = (QueueConnectionFactory) tmp;
    	conn = qcf.createQueueConnection();
    	que = (Queue) iniCtx.lookup(queueName);
    	session = conn.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
    	conn.start();
    	System.out.println("Connection Started");
    }
    
    private void stop() throws JMSException 
    { 
        conn.stop();
        session.close();
        conn.close();
    }
    
    private void sendAMessage(javax.jms.Message msg) throws JMSException {
    	
        QueueSender send = session.createSender(que);        
       // ObjectMessage tm = session..createObjectMessage(msg);
        
        //send.send(tm);     
        send.send(que, msg);
        send.close();
    }
       
    
//    public static void main(String args[]) throws Exception
//    {        	    	
//    	SendJMSMessage sm = new SendJMSMessage();
//    	sm.setupConnection();
//    	if(args.length < 1){
//    		args = new String[]{"Hello World from ruili"};
//    	}
//    	sm.sendAMessage(args[0]); 
//    	sm.stop();
//    	
//    }
    
    public void SendMessageToQueue(String queueName,Message msg){
    	JMSMsgSender sm = new JMSMsgSender();
    	try {
			sm.setupConnection (queueName);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			sm.sendAMessage(msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			sm.stop();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
    
    

	

}
