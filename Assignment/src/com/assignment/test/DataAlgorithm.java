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
	private String test;
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	//constructor
	public DataAlgorithm(String test)
	{
		this.test = test;
	}
	
	public void testData()
	{
		//instantiating an object of FileProcessor, with the filename data.txt
		FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
		fp.openFile();
		patientList = fp.readFile();
		fp.closeReadFile();
		System.out.print(patientList);
	}
	
	
	
	/*
	 Algorithm to get the probability of tonsillitis based on a patients symptoms
	 
	 Example data: 18 patients
	 9 with tonsillitis (TS)
	 9 without TS
	 
	 temperature hot:    5/18  1/9 who hot have TS  4/9 who hot have no TS
	 temperature normal: 8/18  7/9 who normal have TS  1/9 who normal have no TS
	 temperature cool:   5/18  1/9 who cool have TS, 4/9 who cool have no TS
	 
	 aches yes:          10/18 7/9 who ache have TS, 3/9 who aches have no TS
	 aches no:           8/18  2/9 who don't ache have TS, 6/9 who don't ache have no TS
	 
	 sore throat yes:    10/18 7/9 who have sore throat have TS,  3/9 who have sore throat have no TS
	 sore throat no:     8/18  2/9 who have no sore throat have TS  6/9 who don't have sore throat have no TS
	 
	 
	 P(temperature hot and has tonsillitis) = 1/9
	 P(aches yes and has tonsillitis) = 7/9
	 P(sore throat yes and has tonsillitis) = 7/9
	 P(has tonsillitis) = 9/18
 	
 	 P(temperature hot and no tonsillitis) = 4/9
 	 P(aches yes and no tonsillitis) = 3/9
	 P(sore throat yes and no tonsillitis) = 3/9
	 P(no tonsillitis) = 9/18
	 
	 For an individual patient multiply the probability of each of the 3 symptoms
	 leading to tonsillitis by each other and then multiply it by the overall chance of tonsillitis
	 
	 Then  multiply the probability of each of the 3 symptoms
	 not leading to tonsillitis by each other and then multiply it by the overall chance of not having tonsillitis
	 
	 example: patient has temperature hot, aches yes, sore throat yes
	 temperature hot: 1/9 TS, 4/9 no TS
	 aches yes: 7/9 TS, 3/9 no TS
	 sore throat yes: 7/9 TS, 3/9 no TS
	 
	 Yes: (1/9) * (7/9) * (7/9) * (9/18) = 0.036
	 No: (4/9) * (3/9) * (3/9) * (9/18) = 0.025
	 
	 0.036 + 0.025 = 0.061
	 
	 0.036/0.061= 0.059 = 59% Probability of patient having tonsillitis
	 0.025/0.061=0.041 = 41% Probability of patient not having tonsillitis
	 
	 */
	

}
