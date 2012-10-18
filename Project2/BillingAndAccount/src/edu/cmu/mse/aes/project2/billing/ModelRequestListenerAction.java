package edu.cmu.mse.aes.project2.billing;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;

/*
 * @author: Rui li
 * 
 * this is a listen will handle the brand request message from ESB. 
 * and also will use the dataquery service to get the data. 
 * 
 */
public class ModelRequestListenerAction extends AbstractActionLifecycle {
	


	
	 protected ConfigTree	_config;
	  
	  public ModelRequestListenerAction(ConfigTree config) { _config = config; } 

	  
	  public Message displayMessage(Message message) throws Exception{
			
			  System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");		  		  
			  System.out.println("Body: " + message.getBody().get()) ;
			  System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
			  return message; 
	        		
		}
	
	


	

	
	

}
