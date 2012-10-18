package edu.cmu.mse.aes.project2.billing;

import java.util.ArrayList;
import java.util.Random;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;
import javax.jms.Message;
/*
 * @author: Rui li
 * 
 * this is a listener which  will handle the billing related request. 
 * 
 */
public class BillingRequestListenerAction extends AbstractActionLifecycle {

//	private ArrayList<String> brands = new ArrayList();

	protected ConfigTree _config;

	public BillingRequestListenerAction(ConfigTree config) {
		_config = config;
	}

	public String returnBillingResult(Message message)  {
		 int i = (int) ((Math.random()) % 2);
	        
	        if(i == 0)
	        	return "can bill";
	        
	        else
	        	return "can not billing now.";



	}

}
