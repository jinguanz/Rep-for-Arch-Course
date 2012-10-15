package edu.cmu.aes.project2;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import org.jboss.soa.esb.message.Message;
import org.jboss.soa.esb.message.format.MessageFactory;

public class OrderBike extends AbstractActionLifecycle {
	
	protected ConfigTree	_config;
	  
	  public OrderBike(ConfigTree config) { _config = config; } 

	  
	  public Message orderBikesForWarehouse(Message message) throws Exception{
			  
			 System.out.println("The order for the bike has been placed.");
			 
			 return message;
	        		
		}

}
