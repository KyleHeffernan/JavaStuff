/***********************************************
 * Person: this class simulates a Person
 * Java lab 7
 * Author: Kyle Heffernan
 * Date: 14/03/19
 ***********************************************/


package com.lab7.test;

public class Person
{
	//attributes
	private String firstName;
	private String surName;
	private Date dateOfBirth;
	private String gender;
	
	//constructor
	public Person(String firstName, String surName, Date dateOfBirth, String gender)
	{
		this.setFirstName(firstName);
		this.setSurName(surName);
		this.setDateOfBirth(dateOfBirth);
		this.setGender(gender);
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nFirst name: " +this.getFirstName() + "\nSurname: " +this.getSurName() + "\nDate of birth: " +this.getDateOfBirth() +"\nGender: " +this.getGender());
		
		return summary;
	}
	
	
	//GETTERS AND SETTERS
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
