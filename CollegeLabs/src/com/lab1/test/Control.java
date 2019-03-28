/***********************************************
 * Control: The purpose of this class is to instantiate objects and test a print statement
 * Java lab 1
 * Author: Kyle Heffernan
 * Date: 31/01/19
 ***********************************************/


package com.lab1.test;

public class Control 
{
	public static void main(String[]args)
	{
		System.out.println("Hello World!!!");
		//Vehicle person1 = new Vehicle("Frisk");
		Vehicle person2 = new Vehicle("Jim", "08D665", 200, "Blue", true);
		
		//printing using the toString() method
		System.out.println(person2);
	}
	
}