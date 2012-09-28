package edu.cmu.mse.rui.J2EE.HW4;
/*
 * 08-600 
 * Homework #4
 * Rui Li <ruili@andrew.cmu.edu> 
 * September 28, 2012 
 */

import java.util.Date;

public class HW4Data implements Comparable<HW4Data> {
	private Date createDate;
	private String description;
	private double amount;
	private double fee;
	private int chectNo;
	private boolean isCheck;
	private double currentBalance;

	public double getCurrentBalance() {
		return currentBalance;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getFee() {
		return fee;
	}

	public void setFee(double fee) {
		this.fee = fee;
	}

	public int getChectNo() {
		return chectNo;
	}

	public void setChectNo(int chectNo) {
		this.chectNo = chectNo;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	
	//Encapsulate the fee calc
	HW4Data(Date createDate, String des, double amount, int checkNo,
			boolean isCheck) {
		super();
		this.createDate = createDate;
		this.description = des;
		this.amount = amount;
		this.chectNo = checkNo;
		this.isCheck = isCheck;
		this.fee = calcFee(amount, isCheck);

	}

	private double calcFee(double amount, boolean isCheck) {
		double fee = 0.0;
		if (isCheck) {
			if (amount < 10)
				fee = 0.1;
			else if (amount >= 10 && amount <= 100)
				fee = amount * 0.01;
			else if (amount > 100)
				fee = 1.0;

		} else {
			if (amount >= 1 && amount < 100)
				fee = 0.5;
			else if (amount >= 100 && amount <= 1000)
				fee = amount * 0.005;
			else if (amount > 1000)
				fee = amount * 0.025;

		}
		return fee;

	}

	public double calBlance(double preBalance, double currentAmount,
			double fee, boolean isCheck) {
		double currentBalance = 0.0;
		if (isCheck) {
			currentBalance = preBalance - currentAmount - fee;
		} else
			currentBalance = preBalance + currentAmount - fee;

		return currentBalance;
	}



	@Override
	public int compareTo(HW4Data o) {
		// TODO Auto-generated method stub
		return this.getCreateDate().compareTo(o.getCreateDate());
	}

}
