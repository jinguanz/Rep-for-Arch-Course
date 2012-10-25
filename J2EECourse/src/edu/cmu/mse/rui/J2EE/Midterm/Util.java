package edu.cmu.mse.rui.J2EE.Midterm;

/*
 * 08-600 
 * Homework #4
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 28, 2012 
 */
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;

import edu.cmu.mse.rui.J2EE.HW4.HW4Data;

public class Util {
	private static SimpleDateFormat formatter = new SimpleDateFormat(
			"MM/dd/yyyy");
	private static DecimalFormat df = new DecimalFormat("#.##");

	// To Check whether the Description is empty
	public static boolean checkoutEmptyDescription(String str) {
		if (str.equals("")) {
			return false;
		} else
			return true;

	}

	// to check the input amount in a certain range
	public static boolean checkIntAmount(String amount) {

		try {
			Integer.parseInt(amount);
			return true;

		} catch (Exception e) {
			return false;
		}

	}
	
	public static boolean checkMax(String amount){
		int i=Integer.parseInt(amount);
		if(i>10000000) return false;
		else return true;
	}
	
	public static boolean checkMin(String amount){
		int i=Integer.parseInt(amount);
		if(i<0) return false;
		else return true;
		
	}
	
	
	

	// convert the money format
	
	public static String convert(int i){
		return null;
	}
}
