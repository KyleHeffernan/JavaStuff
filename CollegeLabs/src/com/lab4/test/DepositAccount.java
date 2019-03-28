/***********************************************
 * DepositAccount: this class 
 * Java lab 4
 * Author: Kyle Heffernan
 * Date: 21/02/19
 ***********************************************/

package com.lab4.test;

public class DepositAccount extends Account implements ValidatedAccount
{
	//attributes
	private double interestRate;
	
	//constructor
	public DepositAccount(String accountName, String sortCode, String branchName, boolean inCredit, double acctBalance, double interestRate)
	{
		super(accountName, sortCode, branchName, inCredit, acctBalance);
		this.setInterestRate(interestRate);
			
	}

	public void withdraw(double takeAmount)
	{
		System.out.println("\nYou can't withdraw from a deposit account.\n");
	}
	
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = (super.toString() + "\nInterest rate: " +this.interestRate);
		
		return summary;
	}
	
	
	@Override
	public void getDetails() 
	{
		System.out.println ("account type is deposit");
		
	}

	@Override
	public void valuableAccount() 
	{
		System.out.println ("account type is deposit and balance is "+getAcctBalance());
		
	}
		
		
	//Setters and Getters
	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
}
