/***********************************************
 * Patient:
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

public class Patient
{
	//attributes
	private String temperature;
	private String aches;
	private String throat;
	
	
	//constructor
	public Patient(String temperature, String aches, String throat)
	{
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setThroat(throat);
	}
	
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nTemperature: " +this.getTemperature() + "\nAches: " +this.getAches() + "\nSore throat: " +this.getThroat());
		
		return summary;
	}


	//GETTERS AND SETTERS
	public String getTemperature() {
		return temperature;
	}


	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}


	public String getAches() {
		return aches;
	}


	public void setAches(String aches) {
		this.aches = aches;
	}


	public String getThroat() {
		return throat;
	}


	public void setThroat(String throat) {
		this.throat = throat;
	}

}
