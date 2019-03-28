/***********************************************
 * Employee: This class simulates an employee
 * Java lab 3
 * Author: Kyle Heffernan
 * Date: 14/02/19
 ***********************************************/


package com.lab3.test;

public class Employee 
{
	//attributes
	private String firstName;
	private String surName;
	private int staffNumber;
	private double annualSalary;
	
	//constructor
	public Employee(String firstName, String surName, int staffNumber, double annualSalary)
	{
		this.setFirstName(firstName);
		this.setSurName(surName);
		this.setStaffNumber(staffNumber);
		this.setAnnualSalary(annualSalary);
	}

	//method to return the monthly pay
	public double calculatePay()
	{
		double monthlySalary = annualSalary / 12;
		return monthlySalary;
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nFirst Name: " + this.firstName + "\nSurname: " +this.surName + "\nStaff number: " + this.staffNumber + "\nAnnual salary: " +this.annualSalary);
		
		return summary;
	}
		
		
	//Setters and Getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
	}

	public double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(double annualSalary) {
		this.annualSalary = annualSalary;
	}
}