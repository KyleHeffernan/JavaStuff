/***********************************************
 * CurrentAccount: this class simulates a bank account
 * Java lab 4
 * Author: Kyle Heffernan
 * Date: 21/02/19
 ***********************************************/

package com.lab4.test;

public class CurrentAccount extends Account implements ValidatedAccount
{
	//attributes
	private double penaltyAmount;
	
	//constructor
	public CurrentAccount(String accountName, String sortCode, String branchName, boolean inCredit, double acctBalance, double penaltyAmount)
	{
		super(accountName, sortCode, branchName, inCredit, acctBalance);
		this.setPenaltyAmount(penaltyAmount);
			
	}

	public void withdraw(double takeAmount)
	{
		if(getAcctBalance() - takeAmount < 0)
		{
			System.out.println("\nInsufficient funds\n");

		}
		else
		{
			super.withdraw(takeAmount);		
		}
	}
	
	public void checkCredit()
	{
		String message;
		
		if(isInCredit() == true)
		{
			message = "This account is in credit";
		}
		else
		{
			message = "This account is not in credit";
		}
		
		 checkCredit(message);
	}
	
	public void checkCredit(String warningMessage)
	{
		if(getAcctBalance() <= 100 && getAcctBalance() >= 0)
		{
			System.out.println("\nAccount is low on funds\n");
		}

		System.out.println(warningMessage);
	}
	
	
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = (super.toString() + "\nPenalty amount: " +this.penaltyAmount);
		
		return summary;
	}
	
	@Override
	public void getDetails() 
	{
		System.out.println ("account type is current");
		
	}

	@Override
	public void valuableAccount() 
	{
		System.out.println ("account type is current and balance is "+getAcctBalance());
		
	}
	
		
		
	//Setters and Getters
	public double getPenaltyAmount() {
		return penaltyAmount;
	}

	public void setPenaltyAmount(double penaltyAmount) {
		this.penaltyAmount = penaltyAmount;
	}
	
}
