/***********************************************
 * DataAlgorithm:this class gets an ArrayList of Patient classes from the FileProcessor class and
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

import java.util.ArrayList;


public class DataAlgorithm
{
	//attributes
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private int i;
	private float totalPatients = 0;
	private float totalTS = 0;           
	private float totalNoTS = 0;       
    
	private float tempTS;                
	private float tempNoTS;              
	private float achesTS;               
	private float achesNoTS;
	private float throatTS;
	private float throatNoTS;
	
	private float totalYes;
	private float totalNo;
	private float divNum;
	private float yesChance;
	private float noChance;
	
	Patient currentPatient;
	private String currentTemp;
	private String currentAches;
	private String currentThroat;
	
	private String results;
	
	private String accuracy;
	private long newSize;
	private ArrayList<Patient> tempPatientList = new ArrayList<Patient>();
	private ArrayList<Patient> testPatientList = new ArrayList<Patient>();
	
	
	
	//   *** CONSTRUCTORS ***
	
	//constructor used for giving the probability to a single patient
	public DataAlgorithm(Patient currentPatient)
	{
		//instantiating an object of FileProcessor, with the filename data.txt
		FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
		fp.openFile();
		patientList = fp.readFile();
		fp.closeReadFile();
		
		//setting the current patients symptoms to test
		this.currentPatient = currentPatient;
		currentTemp = currentPatient.getTemperature();
		currentAches = currentPatient.getAches();
		currentThroat = currentPatient.getThroat();
	}
	
	//constructor used for testing the accuracy of the algorithm
	public DataAlgorithm()
	{
		//instantiating an object of FileProcessor, with the filename data.txt
		FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
		fp.openFile();
		patientList = fp.readFile();
		fp.closeReadFile();
		
		newSize = Math.round((patientList.size() * .7));
		
		//puts first 70% of patients into a temporary list
		for(i=0; i < newSize; i++)
		{
			tempPatientList.add(patientList.get(i));
		}
		
		//puts last 30% of patients into a testPatientList, to be used to tested
		for(i = (int) newSize; i < patientList.size(); i++)
		{
			testPatientList.add(patientList.get(i));
		}
		
		//clears patientList and returns the patients from the temporary list. patientList is now only 70% of its original size
		patientList.clear();
		for(i = 0; i < newSize; i++)
		{
			patientList.add(tempPatientList.get(i));
		}
	}
	
	
	public void gettingTotals()
	{
		//putting the total amount of patients into an attribute
		totalPatients = patientList.size();
		
		//for loop which gets the total amount of patients that do and do not have tonsillitis
		for(i = 0; i < totalPatients; i++)
		{
			if(patientList.get(i).getTonsillitis().equals("yes"))
			{
				totalTS++;
			}
			else if(patientList.get(i).getTonsillitis().equals("no"))
			{
				totalNoTS++;
			}
		}
		
		//for loop in which there are if statements getting how many times certain symptoms lead to tonsillitis
		for(i = 0; i < totalPatients; i++)
		{
			//if else which gets the amount of times that the current temperature lead to tonsillitis, or lead to no tonsillitis
			if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				tempTS++;
			}
			else if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("no"))
			{
				tempNoTS++;
			}
			
			//if else which gets the amount of times that the current aches lead to tonsillitis, or lead to no tonsillitis
			if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				achesTS++;
			}
			else if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("no"))
			{
				achesNoTS++;
			}
			
			//if else which gets the amount of times that the current throat lead to tonsillitis, or lead to no tonsillitis
			if(patientList.get(i).getThroat().equals(currentThroat) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				throatTS++;
			}
			else if(patientList.get(i).getThroat().equals(currentThroat) && patientList.get(i).getTonsillitis().equals("no"))
			{
				throatNoTS++;
			}
			
		}
	}
	
	
	public void calculations()
	{
		totalYes = (tempTS/totalTS) * (achesTS/totalTS) * (throatTS/totalTS) * (totalTS/totalPatients);
		totalNo = (tempNoTS/totalNoTS) * (achesNoTS/totalNoTS) * (throatNoTS/totalNoTS) * (totalNoTS/totalPatients);
		
		divNum = totalYes + totalNo;
		
		yesChance = totalYes/divNum;
		noChance = totalNo/divNum;
	}
	
	
	public String returnResults()
	{
		//System.out.println("\nChance of tonsillitis: " + Math.round(100 * yesChance));
		//System.out.println("\nChance of no tonsillitis: " + Math.round(100 * noChance));
		results = ("\nChance of tonsillitis: " + Math.round(100 * yesChance) + "%" + "\nChance of no tonsillitis: " + Math.round(100 * noChance) + "%");
		return results;
	}
	
	
	public String testData()
	{
		
		accuracy = ("The algorithm is " + "" + "% accurate");
		return accuracy;
	}
	
	
	/*
	 *** Explanation of Algorithm to get the probability of tonsillitis based on a patients symptoms ***
	 
	 For an individual patient multiply the probability of each of the 3 symptoms
	 leading to tonsillitis by each other and then multiply it by the overall chance of tonsillitis = x
	 
	 Then  multiply the probability of each of the 3 symptoms
	 not leading to tonsillitis by each other and then multiply it by the overall chance of not having tonsillitis = y
	 
	 Add them together to get z, then divide x by z to get chance of tonsillitis, and y by z to get chance of no tonsillitis
	 
	 
	 
	 Example: patient has temperature hot, aches yes, sore throat yes
	 Example data: 18 patients
	 9 with tonsillitis (TS)
	 9 without TS
	 
	 temperature hot: 1/9 TS, 4/9 no TS
	 aches yes: 4/9 TS, 7/9 no TS
	 sore throat yes: 7/9 TS, 3/9 no TS
	 
	 Yes: (1/9) * (4/9) * (7/9) * (9/18) = 0.01920438957
	 No: (4/9) * (7/9) * (3/9) * (9/18) = 0.05761316872
	 
	 0.01920438957 + 0.05761316872 = 0.07681755829
	 
	 0.01920438957 / 0.07681755829  = 0.25 (*100) = 25% Probability of patient having tonsillitis
	 0.05761316872 / 0.07681755829  = 0.75 (*100) = 75% Probability of patient not having tonsillitis
	 */
}
