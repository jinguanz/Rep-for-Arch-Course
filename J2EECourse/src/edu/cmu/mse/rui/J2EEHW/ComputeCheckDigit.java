package edu.cmu.mse.rui.J2EEHW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * 08-600 
 * Homework #2 
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 4, 2012 
 */
public class ComputeCheckDigit {

	/**
	 * the max number of user failed to input 11 digital
	 */
	final static int MAX_FAIL_TIME = 3;
	final static int numbersOfDigit = 11;
	

	/*
	 * such method will used for input 11 digits and detect whether the input is
	 * valid.
	 */
	private static long input11Digtal() throws Exception {
		System.out
				.println("please input 11 digits,without spaces or hyphens or anything else but the eleven digits");
		BufferedReader buf = new BufferedReader(
				new InputStreamReader(System.in));
		String str = buf.readLine();
		if (str.length() == numbersOfDigit) {
			long n = Long.parseLong(str);
			return n;
		} else
			throw new Exception("length is not enough");

	}

	/*
	 * Such method will used for convert long to int array, the array will be
	 * used for calc the 12th number
	 */
	private static int[] convertLongTointArray(long l) {
		String str = l + "";
		int arr[] = new int[numbersOfDigit];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = (int) str.charAt(i) - 48;
		}
		return arr;
	}

	/*
	 * calculate the 12th digit base on the int array which including all the 11
	 * digits inputed. base on the formula: x = (10- (a*3 + b + c*3 + d + e *3 +
	 * f + g *3 + h + i*3 + j + k*3) mod 10) mod 10
	 */
	private static int count12thDigital(int[] js) {

		int middleResult = 0;
		for (int i = 0; i < js.length; i = i + 2) {
			middleResult = middleResult + 3 * js[i];
		}

		for (int i = 1; i < js.length; i = i + 2) {
			middleResult = middleResult + js[i];
		}
		return (10 - middleResult % 10) % 10;

	}

	/*
	 * User has fixed times to try to input 11 digits, and the 12th digit will
	 * be calc base on the input.
	 */
	public static void main(String[] args) {
	
		int failCounter = 0;
		long input = -1l;
		
		//give the user MAX_FAIL_TIME opportunities to input the right 11 digits
		while (failCounter < MAX_FAIL_TIME && input == -1l) {
			try {
				input = input11Digtal();
			} catch (Exception e) {
				failCounter++;
				System.out.println("wrong input,please input again "
						+ (MAX_FAIL_TIME - failCounter)
						+ " times of opportunites left");
			}
		}
		
		//after MAX_FAIL_TIME opportunities, still do not come to the right input
		if (input == -1l) {
			System.out
					.println("please contact system admin ruili@andrew.cmu.edu, and system will exit");
			System.exit(0);
		} else {//with the right input
			System.out.println("The first eleven digits are " + input);
			int twelfthDigit = count12thDigital(convertLongTointArray(input));
			System.out.println("the twelfth digit is " + twelfthDigit);
			System.out.println("System Exit");
			System.exit(0);
		}

	}

}
