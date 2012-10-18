package edu.cmu.mse.project2.dataaccess;

import java.util.ArrayList;

import edu.cmu.mse.project2.data.Account;

public interface IAccountInfoSecAccessor {
	
	public boolean validateAccount(String name, String pwd);
	
	//include create account,modify or delete account infomation
	public boolean accountOperation(Account a, int i);
	
	public ArrayList<String> retrievePaymentHistory(Account a);
	
	public Account accountInfoQuery(Account a);
	
	
}
