/***********************************************
 * HourlyEmployee: This class inherits from Employee and has attributes of it's own
 * Java lab 3
 * Author: Kyle Heffernan
 * Date: 14/02/19
 ***********************************************/


package com.lab3.test;

public class HourlyEmployee extends Employee
{
	//attributes
	private double hoursWorked;
	private double hourlyRate;
	
	//constructor
	public HourlyEmployee(String firstName, String surName, int staffNumber, double annualSalary, double hoursWorked, double hourlyRate)
	{
		super(firstName, surName, staffNumber, annualSalary);
		this.setHoursWorked(hoursWorked);
		this.setHourlyRate(hourlyRate);
	}
	
	//method to return the pay based on hours worked
	public double calculatePay()
	{
		double totalPay = getHoursWorked() * getHourlyRate();
		return totalPay;
	}

	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = (super.toString() + "\nWeekyly pay: " +calculatePay());
		 
		return summary;
	}
	
	
	//Setters and Getters
	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}
		
}