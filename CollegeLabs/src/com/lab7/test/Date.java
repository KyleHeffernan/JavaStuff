/***********************************************
 * Date: this class simulates a Date
 * Java lab 7
 * Author: Kyle Heffernan
 * Date: 14/03/19
 ***********************************************/


package com.lab7.test;

public class Date 
{
	//attributes
	private int day;
	private int month;
	private int year;
	
	//constructor
	public Date(int day, int month, int year)
	{
		//checks to make sure valid date is input
		if(day < 1 || day > 31 || month < 1 || month > 12)
		{
			System.out.println("Please enter a suitable date eg: 27 10 2017");
		}
		else
		{
			this.setDay(day);
			this.setMonth(month);
			this.setYear(year);
		}
		
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = (+this.getDay() + "/" +this.getMonth() + "/" +this.getYear());
		 
		return summary;
	}
	
	
	//SETTERS AND GETTERS
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}


}
