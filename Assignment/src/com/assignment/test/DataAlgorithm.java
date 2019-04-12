/***********************************************
 * DataAlgorithm: This class gets an ArrayList of Patient classes from the FileProcessor class
 * and uses the Naive Bayes algorithm to find the probability of a patient having tonsillitis
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

import java.util.ArrayList;


public class DataAlgorithm
{
	//Attributes
	private int correct = 0;
	private int wrong = 0;
	private long newSize;
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
	private float totalPredictions;
	private float percentAccurate;
	private String currentTemp;
	private String currentAches;
	private String currentThroat;
	private String predictionTS;
	private String results;
	private String accuracy;
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	private ArrayList<Patient> testPatientList = new ArrayList<Patient>();
	private Patient currentPatient;
	
	
	//   *** CONSTRUCTORS ***
	
	//Constructor used for a single patient
	public DataAlgorithm(Patient userPatient)
	{
		//Instantiating an object of FileProcessor, with the filename data.csv
		FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
		fp.openFile();
		patientList = fp.readFile();
		fp.closeReadFile();
		
		//Setting the current patients symptoms to test
		this.currentPatient = userPatient;
		currentTemp = currentPatient.getTemperature();
		currentAches = currentPatient.getAches();
		currentThroat = currentPatient.getThroat();
	}
	
	//Constructor used for testing the accuracy of the algorithm
	public DataAlgorithm()
	{
		//Instantiating an object of FileProcessor, with the filename data.csv
		FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
		fp.openFile();
		patientList = fp.readFile();
		fp.closeReadFile();
		
		//Getting approximately 70% of patientList
		newSize = Math.round((patientList.size() * .7));
		
		//Puts last 30% of patientList into testPatientList to best compared against
		for(int i = (patientList.size() - 1); i > (newSize - 1); i--)
		{
			testPatientList.add(patientList.get(i));
			patientList.remove(i);
		}
		
	}
	
	
	//This method gets the various total values which are later used in the calculations
	public void gettingTotals()
	{
		//Resetting variables
		totalTS = 0;
		totalNoTS = 0;
		tempTS = 0;
		tempNoTS = 0;
		achesTS = 0;
		achesNoTS = 0;
		throatTS = 0;
		throatNoTS = 0;
		totalPatients = patientList.size();
		
		
		//For loop in which there are if statements getting how many times certain symptoms lead to tonsillitis
		for(int i = 0; i < totalPatients; i++)
		{
			//If else which gets the total amount of times tonsillitis is yes, and tonsillitis is no
			if(patientList.get(i).getTonsillitis().equals("yes"))
			{
				totalTS++;
			}
			else if(patientList.get(i).getTonsillitis().equals("no"))
			{
				totalNoTS++;
			}
			
			//If else which gets the amount of times that the current temperature lead to tonsillitis, or lead to no tonsillitis
			if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				tempTS++;
			}
			else if(patientList.get(i).getTemperature().equals(currentTemp) && patientList.get(i).getTonsillitis().equals("no"))
			{
				tempNoTS++;
			}
			
			//If else which gets the amount of times that the current aches lead to tonsillitis, or lead to no tonsillitis
			if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("yes"))
			{
				achesTS++;
			}
			else if(patientList.get(i).getAches().equals(currentAches) && patientList.get(i).getTonsillitis().equals("no"))
			{
				achesNoTS++;
			}
			
			//If else which gets the amount of times that the current throat lead to tonsillitis, or lead to no tonsillitis
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
	
	
	//This method implements the Naive Bayes algorithm to get the overall chance of currentPatient having tonsillitis
	public void calculations()
	{
		//Resetting variables
		totalYes = 0;
		totalNo = 0;
		divNum = 0;
		yesChance = 0;
		noChance = 0;
		
		//Naive Bayes algorithm
		totalYes = (tempTS/totalTS) * (achesTS/totalTS) * (throatTS/totalTS) * (totalTS/totalPatients);
		totalNo = (tempNoTS/totalNoTS) * (achesNoTS/totalNoTS) * (throatNoTS/totalNoTS) * (totalNoTS/totalPatients);
		
		divNum = totalYes + totalNo;
		
		yesChance = totalYes/divNum;
		noChance = totalNo/divNum;
	}
	
	
	//This method returns the results of the algorithm in a readable string
	public String returnResults()
	{
		results = ("\nChance of tonsillitis: " + Math.round(100 * yesChance) + "%" + "\nChance of no tonsillitis: " + Math.round(100 * noChance) + "%");
		return results;
	}
	
	
	/*This method uses the first 70% of patientList as training data and compares 
	it's predictions to the patients in the last 30% to find the accuracy of the algorithm */
	public String testData()
	{
		int testSize = testPatientList.size();
		
		//For loop which goes through each patient is testPatientList
		for(int j = 0; j < testSize; j++)
		{
			currentTemp = testPatientList.get(j).getTemperature();
			currentAches = testPatientList.get(j).getAches();
			currentThroat = testPatientList.get(j).getThroat();
			
			gettingTotals();
			calculations();
			
			//This if else gets whether the algorithm predicts that a patient with the current symptoms would have tonsillitis
			if((yesChance * 100) > 50)
			{
				predictionTS = "yes";
			}
			else if((yesChance * 100) <= 50)
			{
				predictionTS = "no";
			}
			
			//This if else determines whether the prediction made by the algorithm was correct
			if(predictionTS.equals(testPatientList.get(j).getTonsillitis()))
			{
				correct++;
			}
			else
			{
				wrong++;
			}
			
		}
		//Getting the accuracy of the algorithm as a percentage
		totalPredictions = correct + wrong;
		percentAccurate = (correct/totalPredictions) * 100;
		
		//Returning the accuracy to DeveloperGUI in a nice looking string
		accuracy = ("Correct predictions: " +correct + "\nIncorrect predictions: " +wrong + "\nPercentage accurate: "+Math.round(percentAccurate) +"%");
		return accuracy;
	}
	
	
	/****** Explanation of Algorithm ******
	* 
	* For an individual patient multiply the probability of each of the 3 symptoms
	* leading to tonsillitis by each other and then multiply it by the overall chance of tonsillitis = x
	* 
	* Then  multiply the probability of each of the 3 symptoms
	* not leading to tonsillitis by each other and then multiply it by the overall chance of not having tonsillitis = y
	* Add them together to get z, then divide x by z to get chance of tonsillitis, and y by z to get chance of no tonsillitis
	* 
	* Example: patient has temperature hot, aches yes, sore throat yes
	* Example data: 18 patients
	* 9 with tonsillitis (TS)
	* 9 without TS
	*
	* temperature hot: 1/9 TS, 4/9 no TS
	* aches yes: 4/9 TS, 7/9 no TS
	* sore throat yes: 7/9 TS, 3/9 no TS
	* 
	* Yes: (1/9) * (4/9) * (7/9) * (9/18) = 0.01920438957
	* No: (4/9) * (7/9) * (3/9) * (9/18) = 0.05761316872
	* 
	* 0.01920438957 + 0.05761316872 = 0.07681755829
	* 
	* 0.01920438957 / 0.07681755829  = 0.25 (*100) = 25% Probability of patient having tonsillitis
	* 0.05761316872 / 0.07681755829  = 0.75 (*100) = 75% Probability of patient not having tonsillitis
	******************************************/
}
