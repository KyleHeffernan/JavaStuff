/***********************************************
 * Person: this class simulates a person
 * Java lab 8
 * Author: Kyle Heffernan
 * Date: 27/03/19
 ***********************************************/


package com.lab8.test;


public class Person
{
	//attributes
	private String firstName;
	private String surName;
	private String city;
	
	//constructor
	public Person(String firstName, String surName, String city)
	{
		this.firstName = firstName;
		this.surName = surName;
		this.city = city;
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nThe person is called " +this.firstName + " " +this.surName + " and is from " +this.city);
		
		return summary;
	}
		

}
