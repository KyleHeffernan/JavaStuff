/***********************************************
 * DataAlgorithm:
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

import java.util.ArrayList;

public class DataAlgorithm
{
	//attributes
	ArrayList<Patient> patientList = new ArrayList<Patient>();
	int i;
	float totalPatients = 0;
	float totalTS = 0;           
	float totalNoTS = 0;       

	float tempTS;                
	float tempNoTS;              
	float achesTS;               
	float achesNoTS;
	float throatTS;
	float throatNoTS;
	
	float totalYes;
	float totalNo;
	float divNum;
	float yesChance;
	float noChance;
	
	Patient currentPatient;
	String currentTemp;
	String currentAches;
	String currentThroat;
	
	String results;
	
	//constructor
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
	
	
	public void gettingTotals()
	{
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
		
		
		for(i = 0; i < totalPatients; i++)
		{
			if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				tempTS++;
			}
			else if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("no"))
			{
				tempNoTS++;
			}
			
			
			if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				achesTS++;
			}
			else if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("no"))
			{
				achesNoTS++;
			}
			
			
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
	
	
	/*
	 
	 Algorithm to get the probability of tonsillitis based on a patients symptoms
	 
	 Example data: 18 patients
	 9 with tonsillitis (TS)
	 9 without TS
	 
	 For an individual patient multiply the probability of each of the 3 symptoms
	 leading to tonsillitis by each other and then multiply it by the overall chance of tonsillitis
	 
	 Then  multiply the probability of each of the 3 symptoms
	 not leading to tonsillitis by each other and then multiply it by the overall chance of not having tonsillitis
	 
	 example: patient has temperature hot, aches yes, sore throat yes
	 
	 temperature hot: 1/9 TS, 4/9 no TS
	 aches yes: 4/9 TS, 7/9 no TS
	 sore throat yes: 7/9 TS, 3/9 no TS
	 
	 Yes: (1/9) * (4/9) * (7/9) * (9/18) = x
	 No: (4/9) * (7/9) * (3/9) * (9/18) = y
	 
	 x + y = z
	 
	 x/z= 0.059 = 59% Probability of patient having tonsillitis
	 y/z=0.041 = 41% Probability of patient not having tonsillitis
	 
	 */
}
