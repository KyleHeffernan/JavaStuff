/***********************************************
 * Control:
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;


public class Control
{

	public static void main(String[] args) 
	{
		HomeGUI myHomeGUI = new HomeGUI();

		DataAlgorithm myDataAlgorithm = new DataAlgorithm();
		myDataAlgorithm.algorithm();
		
		System.out.println(myDataAlgorithm.totalTS);
		System.out.println(myDataAlgorithm.totalNoTS);

	}

}
