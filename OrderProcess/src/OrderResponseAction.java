

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.actions.ActionUtils;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Body;
import org.jboss.soa.esb.message.Message;
import java.util.Map;

public class OrderResponseAction extends AbstractActionLifecycle
{
   protected ConfigTree _config;

   public OrderResponseAction(ConfigTree config)
   {
      _config = config;
   }

   public Message noOperation(Message message)
   {
      return message;
   }

   /*
    * Retrieve and output the webservice response.
    */
   public Message process(Message message) throws Exception
   {

      logHeader();
      Map responseMsg = (Map) message.getBody().get();
      System.out.println("Response Map is: " + responseMsg);
      logFooter();
      return message;
   }

   public void exceptionHandler(Message message, Throwable exception)
   {
      logHeader();
      System.out.println("!ERROR!");
      System.out.println(exception.getMessage());
      System.out.println("For Message: ");
      System.out.println(message.getBody().get());
      logFooter();
   }

   // This makes it easier to read on the console
   private void logHeader()
   {
      System.out.println("Start of Order response..\n");
   }

   private void logFooter()
   {
      System.out.println("End of Order response..\n");
   }

}