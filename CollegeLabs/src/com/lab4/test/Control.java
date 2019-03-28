/***********************************************
 * Control: this class acts as a control for the account classes and simple GUI
 * Java lab 4
 * Author: Kyle Heffernan
 * Date: 21/02/19
 ***********************************************/


package com.lab4.test;

public class Control 
{
	

	public static void main(String[] args) 
	
	{
		//testing GUI 
		//SimpleGUI myGUI = new SimpleGUI();
		
		Account person1 = new Account("Kyle", "A18N7", "Stillorgan", true, 800.5);
		DepositAccount person2 = new DepositAccount("Jim", "D28N7", "Sandyford", true, 150, 2);
		CurrentAccount person3 = new CurrentAccount("Chris", "A48B9", "Blackrock", true, 322, 5);

		
		System.out.println(person1);
		person1.deposit(20);
		person1.withdraw(30);
		System.out.println(person1);
		
		person2.withdraw(90);
		person3.withdraw(700);
		
		System.out.println(person3);
		person3.withdraw(290);
		System.out.println(person3);
		
		person3.checkCredit();
		
		person1.getDetails();
		person1.valuableAccount();
		person2.getDetails();
		person2.valuableAccount();
		person3.getDetails();
		person3.valuableAccount();
		
	}

}
