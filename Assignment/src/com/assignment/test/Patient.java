/***********************************************
 * Patient: This class is used to simulate a Patient with attributes for their symptoms and contains a ToString() to print an object
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;


public class Patient
{
	//Attributes
	private String temperature;
	private String aches;
	private String throat;
	private String tonsillitis;
	
	
	//Constructor
	public Patient(String temperature, String aches, String throat, String tonsillitis)
	{
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setThroat(throat);
		this.setTonsillitis(tonsillitis);
	}
	
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nTemperature: " +this.getTemperature() + "\nAches: " +this.getAches() + "\nSore throat: " +this.getThroat() + "\nTonsillitis: " +this.getTonsillitis());
		
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


	public String getTonsillitis() {
		return tonsillitis;
	}


	public void setTonsillitis(String tonsillitis) {
		this.tonsillitis = tonsillitis;
	}

}
