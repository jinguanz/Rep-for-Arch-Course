package edu.cmu.mse.aes.project2.accout;

import java.util.ArrayList;
import java.util.Random;

import org.jboss.soa.esb.actions.AbstractActionLifecycle;
import org.jboss.soa.esb.helpers.ConfigTree;

import edu.cmu.mse.project2.data.Account;
import edu.cmu.mse.project2.dataaccess.AccountInfoSecAccessor;

import javax.jms.JMSException;
import javax.jms.Message;

/*
 * @author: Rui li
 * 
 * this is a listener which  will handle the account related request. 
 * 
 */
public class AccountListenerAction extends AbstractActionLifecycle {
	AccountInfoSecAccessor accountInfoSecAcessor = new AccountInfoSecAccessor();

	// private ArrayList<String> brands = new ArrayList();

	protected ConfigTree _config;

	public AccountListenerAction(ConfigTree config) {
		_config = config;
	}

	public String accountValidate(Message message) {
		String name = null;
		try {
			name = message.getStringProperty("name");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwd = null;
		try {
			pwd = message.getStringProperty("pwd");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (accountInfoSecAcessor.validateAccount(name, pwd))
			return "valid account";
		else
			return "invalid account";

	}

	public String returnBillingResult(Message message) {
		int i = (int) ((Math.random()) % 2);

		if (i == 0)
			return "can bill";

		else
			return "can not billing now.";

	}

	public String accountOperation(Message message) {
		String name = null;
		try {
			name = message.getStringProperty("name");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwd = null;
		try {
			pwd = message.getStringProperty("pwd");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int operation = 0;
		try {
			operation = message.getIntProperty("operation");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account a = new Account();
		a.setName(name);
		a.setPwd(pwd);

		if (accountInfoSecAcessor.accountOperation(a, operation))
			return "operation sucess";
		else
			return "operation fail";

	}
	
	
	
	public String retrievePaymentHistory(Message message){
		String name = null;
		try {
			name = message.getStringProperty("name");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String pwd = null;
		try {
			pwd = message.getStringProperty("pwd");
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Account a = new Account();
		a.setName(name);
		a.setPwd(pwd);
		ArrayList<String> paymenthistory=accountInfoSecAcessor.retrievePaymentHistory(a);
		String history="";
		for(String each:paymenthistory){
			history=history+each;
		}
		return history;
		
		
	}

public String retrieveAccountInfo(Message message){
	return null;
		
	}
}
