package edu.cmu.mse.rui.J2EE.HW4;

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
	public static boolean checkAmount(String amount, boolean isCheck) {
		try {
			double amountInDouble = Double.parseDouble(amount);
			if (isCheck && amountInDouble <= 0.01) {
				return false;
			} else if (!isCheck && amountInDouble <= 1) {
				return false;
			} else
				return true;
		} catch (Exception e) {
			return false;
		}

	}

	// convert String to java.util.Date
	public static Date dateConvert(String str) {

		Date date = Calendar.getInstance().getTime();
		try {
			date = formatter.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;

	}

	// convert java.util.Date to a certain format String
	public static String DateToString(Date d) {

		return formatter.format(d);
	}

	// sort arrayList
	public static ArrayList<HW4Data> sort(ArrayList<HW4Data> arr) {
		Collections.sort(arr);

		return arr;

	}

	// re calc balance of after sort.
	public static ArrayList<HW4Data> calcBlance(ArrayList<HW4Data> arr) {
		double preBalance = 0.0;
		for (HW4Data data : arr) {
			data.setCurrentBalance(data.calBlance(preBalance, data.getAmount(),
					data.getFee(), data.isCheck()));
			preBalance = data.getCurrentBalance();
		}

		return arr;
	}

	// should follow "MM/dd/yyyy"
	public static boolean checkDateInput(String str) {
		String[] date = str.split("/");
		if (date[0].length() == 2 && date[1].length() == 2
				&& date[2].length() == 4) {
			try {
				formatter.parse(str);
				return true;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				return false;
			}
		} else
			return false;

	}

}
