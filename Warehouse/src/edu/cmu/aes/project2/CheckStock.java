package edu.cmu.aes.project2;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;


	public class CheckStock extends AbstractActionLifecycle
	{
	    
	  protected ConfigTree	_config;
		  
	  public CheckStock(ConfigTree config) { _config = config; } 

	  
	  public Message checkBikeInStock(Message message) throws Exception{
			  
			  int i = (int) Math.random() % 2;
			  Message esbMessage = MessageFactory.getInstance().getMessage();
			  
			  if(i == 0)
				  esbMessage.getBody().add("Yes");
			  else
				  esbMessage.getBody().add("No");
			  return message; 
	        		
		}
	    
		
	}
	
