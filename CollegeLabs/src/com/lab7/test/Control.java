/***********************************************
 * Control: this class acts as a control for the lab task
 * Java lab 7
 * Author: Kyle Heffernan
 * Date: 14/03/19
 ***********************************************/


package com.lab7.test;

public class Control
{

	public static void main(String[] args) 
	{
		//instantiating first employee
		Date firstDate = new Date(20, 10, 1980);
		Job firstJob = new Job(50000, "Engineer", 1224);
		Date firstStartDate = new Date(16, 11, 1988);
		Employee firstEmployee = new Employee("Peter", "Quill", firstDate, "Male", firstJob, firstStartDate);
		
		//Person firstPerson = new Person("Kyle", "Jackson", firstDate, "Male");
		
		/*
		//instantiating second employee
		Date secondDate = new Date(04, 03, 1968);
		Job secondJob = new Job(32000, "Pilot", 3303);
		Date secondStartDate = new Date(01, 06, 1995);
		Employee secondEmployee = new Employee("Carol", "Danvers", secondDate, "Female", secondJob, secondStartDate);
		*/
		
		
		//System.out.println(firstJob);
		//System.out.println(firstDate);
		//System.out.println(firstPerson);
		System.out.println(firstEmployee);
		//System.out.println(secondEmployee);

	}

}
