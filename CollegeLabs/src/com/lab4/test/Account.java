/***********************************************
 * Account: this class simulates a bank account
 * Java lab 4
 * Author: Kyle Heffernan
 * Date: 21/02/19
 ***********************************************/


package com.lab4.test;

public class Account implements ValidatedAccount
{
	//attributes
	private String accountName;
	private int accountNumber;
	private String sortCode;
	private String branchName;
	private boolean inCredit;
	private double acctBalance;
	
	protected static int  currentNumber = 100;

	
	
	//constructor
	public Account(String accountName, String sortCode, String branchName, boolean inCredit, double acctBalance)
	{
		this.setAccountName(accountName);
		this.setSortCode(sortCode);
		this.setBranchName(branchName);
		this.setInCredit(inCredit);
		this.setAcctBalance(acctBalance);
		
		// Set the account number to next available account number
		this.setAccountNumber(currentNumber);
				
		// And update/increment the next available account number
		currentNumber++;
	}

	public void deposit(double depAmount)
	{
		acctBalance = acctBalance + depAmount;
	}
	
	public void withdraw(double takeAmount)
	{
		acctBalance = acctBalance - takeAmount;
		if(acctBalance < 0)
		{
			inCredit = false;
		}
	}
	
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nName: " +this.accountName + "\nAccount number: " +this.accountNumber + "\nSort code: " +this.sortCode + "\nBranch name: " +this.branchName + "\nIn credit? " +this.inCredit + "\nAccount balance: " +this.acctBalance);
		 
		return summary;
	}
		
	
	// This is one of the ValidatedAccount interface methods so this has to be implemented 
	@Override
	public void getDetails() 
	{
		System.out.println("Account type is account");
			
	}

	// This is one of the ValidatedAccount interface methods so this has to be implemented 
	@Override
	public void valuableAccount() 
	{
		System.out.println("Account type is account and balance is " +getAcctBalance());
			
	}
	
	//Getters and Setters
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isInCredit() {
		return inCredit;
	}

	public void setInCredit(boolean inCredit) {
		this.inCredit = inCredit;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

}
