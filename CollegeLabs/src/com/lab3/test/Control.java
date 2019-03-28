/***********************************************
 * Control: This class acts as a control
 * Java lab 3
 * Author: Kyle Heffernan
 * Date: 14/02/19
 ***********************************************/


package com.lab3.test;

public class Control
{
	public static void main(String[] args)
	{
		Employee e1 = new Employee("John", "Carpet", 1234, 50000);
		HourlyEmployee e2 = new HourlyEmployee("Jimmy", "Whistle", 5643, 0, 20, 9);
		CommissionEmployee e3 = new CommissionEmployee("Gerald", "Nose", 8899, 30000, 500 );
		
		//testing calculatePay()
		System.out.println(e1.calculatePay());
		System.out.println(e2.calculatePay());
		System.out.println(e3.calculatePay());
		
		//printing objects using toString()
		System.out.println(e1);
		System.out.println(e2);
		System.out.println(e3);
		
		//Polymorhism
		Employee[] people = new Employee[3];
		people[0] = new Employee("Grahm", "Carp", 1235, 50600);
		people[1] = new HourlyEmployee("Jack", "Dack", 5243, 0, 22, 11);
		people[2] = new CommissionEmployee("Gerry", "Nossle", 8119, 45000, 750 );
		
		for(int i = 0; i < people.length; i++)
		{
			System.out.println(people[i].calculatePay());
			
		}
		
	}
	
}