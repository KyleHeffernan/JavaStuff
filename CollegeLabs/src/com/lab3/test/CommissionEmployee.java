/***********************************************
 * CommissionEmployee: This class inherits from Employee and has attributes of it's own
 * Java lab 3
 * Author: Kyle Heffernan
 * Date: 14/02/19
 ***********************************************/


package com.lab3.test;

public class CommissionEmployee extends Employee
{
	//attributes
	private double commissionEarned;

	//constructor
	public CommissionEmployee(String firstName, String surName, int staffNumber, double annualSalary, double commissionEarned)
	{
		super(firstName, surName, staffNumber, annualSalary);
		this.setCommissionEarned(commissionEarned);
	}

	//method to return the pay based on hours worked
	public double calculatePay()
	{
		double monthlySalary = super.calculatePay() + commissionEarned;
		return monthlySalary;
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = (super.toString() + "\nMonthly pay with commission: " +calculatePay());
		 
		return summary;
	}
	
		
	//Setters and Getters
	public double getCommissionEarned() {
		return commissionEarned;
	}

	public void setCommissionEarned(double commissionEarned) {
		this.commissionEarned = commissionEarned;
	}
		
}