/***********************************************
 * Vehicle: The purpose of this class is to simulate a Vehicle 
 * Java lab 1
 * Author: Kyle Heffernan
 * Date: 31/01/19
 ***********************************************/

package com.lab1.test;

public class Vehicle 
{
	//attributes
	private String ownerName;
	private String regNumber;
	private float maxSpeed;
	private String colour;
	private boolean automatic;
	
	//constructors
	public Vehicle(String ownerName)
	{
		this.ownerName = ownerName;
		System.out.println(this.ownerName);
	}
	
	public Vehicle(String ownerName, String regNumber, float maxSpeed, String colour, boolean automatic)
	{
		this.ownerName = ownerName;
		this.regNumber = regNumber;
		this.maxSpeed = maxSpeed;
		this.colour = colour;
		this.automatic = automatic;
		
		System.out.println(this.ownerName);
		System.out.println(this.regNumber);
		System.out.println(this.maxSpeed);
		System.out.println(this.colour);
		System.out.println(this.automatic);
	}
	
	public String toString()
	{
		String summary = ("Owner name: " + this.ownerName + "\nRegistration: " + this.regNumber + "\nMax speed: " + this.maxSpeed + "\nColour: " + this.colour + "\nAutomatic?: " + this.automatic);
		return summary;
	}

}