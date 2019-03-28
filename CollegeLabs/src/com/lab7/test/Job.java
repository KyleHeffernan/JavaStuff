/***********************************************
 * Job: this class simulates a Job
 * Java lab 7
 * Author: Kyle Heffernan
 * Date: 14/03/19
 ***********************************************/


package com.lab7.test;

public class Job
{
	//attributes
	private double salary;
	private String role;
	private int jobID;
	
	
	//constructor
	public Job(double salary, String role, int jobID)
	{
		this.setSalary(salary);
		this.setRole(role);
		this.setJobID(jobID);
		
		//instantiating an object of FileProcessor, with the filename roles.txt
		FileProcessor fp = new FileProcessor("C:\\Users\\kheff\\eclipse-workspace\\CollegeLabs\\src\\com\\lab7\\test\\roles.txt");
		
		fp.openFile();
		//calling the readFile function with the fp object
		String[] validRoles = fp.readFile();
		fp.closeReadFile();
		
		boolean validRole = false;
		
		//going through the array of strings(each string is a line from roles.txt) and comparing them to role
		for(int i = 0; i< validRoles.length; i++)
		{
			if(role.equals(validRoles[i]))
			{
				System.out.println("Valid");
				validRole = true;
			}
		}
		
		if(validRole == false)
		{
			System.out.println("Not a valid role");
		}
			
	}
	
	//toString method to return a nice looking print statement
	public String toString()
	{
		String summary = ("\nSalary: " +this.getSalary() + "\nRole: " +this.getRole() + "\nJob ID: " +this.getJobID());
		 
		return summary;
	}

	
	//GETTERS AND SETTERS
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getJobID() {
		return jobID;
	}

	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	

}
