/***********************************************
 * Employee: this class simulates a
 * Java lab 7
 * Author: Kyle Heffernan
 * Date: 14/03/19
 ***********************************************/


package com.lab7.test;

public class Employee extends Person
{
	//attributes
	private Job job;
	private Date startDate;
	private int personnelNumber;
	private static int nextNumber = 0001;
	
	//constructor
	public Employee(String firstName, String surName, Date dateOfBirth, String gender, Job job, Date startDate)
	{
		super(firstName, surName, dateOfBirth, gender);
		this.setJob(job);
		this.setStartDate(startDate);
		setPersonnelNumber(getNextNumber());
		setNextNumber(getNextNumber() + 1);
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		FileProcessor fp = new FileProcessor("C:\\Users\\kheff\\eclipse-workspace\\CollegeLabs\\src\\com\\lab7\\test\\names.txt");
		fp.openFile();
		fp.fileWriting();
		String summary = ("\n- - - - - - - -" + super.toString() + "\n  Job: " +this.getJob() + "\nStart Date: " +this.getStartDate() + "\nPersonnel number: " +this.getPersonnelNumber() + "\n- - - - - - - -");
		String line = (super.getFirstName() + " " + super.getSurName());
		fp.writeLine(line);
		fp.closeWriteFile();
		return summary;
	}

	
	//SETTERS AND GETTERS
	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getPersonnelNumber() {
		return personnelNumber;
	}

	public void setPersonnelNumber(int personnelNumber) {
		this.personnelNumber = personnelNumber;
	}

	public static int getNextNumber() {
		return nextNumber;
	}

	public static void setNextNumber(int nextNumber) {
		Employee.nextNumber = nextNumber;
	}

}
