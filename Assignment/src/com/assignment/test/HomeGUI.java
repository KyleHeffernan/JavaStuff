/***********************************************
 * HomeGUI: this class simulates a person
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

//importing GUI modules
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class HomeGUI extends JFrame implements ActionListener
{
	//declaring GUI components and attributes
	private JPanel titlePanel;
	private JPanel inputPanel1;
	private JPanel inputPanel2;
	private JPanel inputPanel3;
	private JPanel bottomPanel;
	private JLabel titleLabel;
	private JLabel tempLabel;
	private JLabel achesLabel;
	private JLabel throatLabel;
	private JButton submitButton;
	
	//using button groups containing radio buttons so the user can only select one value for each symptom
	private ButtonGroup tempGroup;
	private JRadioButton tempHot;
	private JRadioButton tempNormal;
	private JRadioButton tempCool;
	
	private ButtonGroup achesGroup;
	private JRadioButton achesYes;
	private JRadioButton achesNo;
	
	private ButtonGroup throatGroup;
	private JRadioButton throatYes;
	private JRadioButton throatNo;
	
	Patient currentPatient;
	String results;
	
	
	
	//constructor
	public HomeGUI()
	{
		//setting title
		super("Homescreen");
		
		//setting type of layout
		setLayout(new GridLayout());
				
		
		//creating titlePanel
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(300,50));
		add(titlePanel);
		
		//creating inputPanel1
		inputPanel1 = new JPanel();
		inputPanel1.setPreferredSize(new Dimension(300,50));
		add(inputPanel1);
		
		//creating inputPanel2
		inputPanel2 = new JPanel();
		inputPanel2.setPreferredSize(new Dimension(300,50));
		add(inputPanel2);
		
		//creating inputPanel3
		inputPanel3 = new JPanel();
		inputPanel3.setPreferredSize(new Dimension(300,50));
		add(inputPanel3);
		
		//creating bottomPanel
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(300,50));
		add(bottomPanel);
		
		
		//creating titleLabel
		titleLabel = new JLabel("Please enter your symptoms");
		titlePanel.add(titleLabel);
		
		//creating tempLabel
		tempLabel = new JLabel("Temperature: ");
		inputPanel1.add(tempLabel);
		
		//creating achesLabel
		achesLabel = new JLabel("Aches: ");
		inputPanel2.add(achesLabel);
		
		//creating throatLabel
		throatLabel = new JLabel("Sore throat: ");
		inputPanel3.add(throatLabel);
		
		
		//creating tempButton group
		tempGroup = new ButtonGroup();
		tempHot = new JRadioButton("Hot");
		tempNormal = new JRadioButton("Normal");
		tempCool = new JRadioButton("Cool");
		tempGroup.add(tempHot);
		tempGroup.add(tempNormal);
		tempGroup.add(tempCool);
		inputPanel1.add(tempHot);
		inputPanel1.add(tempNormal);
		inputPanel1.add(tempCool);
		
		//creating achesButton group
		achesGroup = new ButtonGroup();
		achesYes = new JRadioButton("Yes");
		achesNo = new JRadioButton("No");
		achesGroup.add(achesYes);
		achesGroup.add(achesNo);
		inputPanel2.add(achesYes);
		inputPanel2.add(achesNo);
		
		//creating achesButton group
		throatGroup = new ButtonGroup();
		throatYes = new JRadioButton("Yes");
		throatNo = new JRadioButton("No");
		throatGroup.add(throatYes);
		throatGroup.add(throatNo);
		inputPanel3.add(throatYes);
		inputPanel3.add(throatNo);
		
		
		//creating submitButton
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);
				
		
		//setting the layout and size of the frame
		setLayout(new GridLayout(5, 1));
		setSize(400,500);
		setVisible(true);
		
	
	}
	
	
	//reactions to events
	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == submitButton)
		{
			if(  (tempHot.isSelected() == false && tempNormal.isSelected() == false && tempCool.isSelected() == false) || (achesYes.isSelected() == false && achesNo.isSelected() == false) || (throatYes.isSelected() == false && throatNo.isSelected() == false))
			{
				JOptionPane.showMessageDialog(this, "Please enter values for each symptom!");
			}
			else
			{
				currentPatient = new Patient("Not set", "Not set", "Not set", "Not set");
				
				//setting the patients temperature based on what is submitted
				if(tempHot.isSelected())
				{
					currentPatient.setTemperature("hot");
				}
				else if(tempNormal.isSelected())
				{
					currentPatient.setTemperature("normal");
				}
				else if(tempCool.isSelected())
				{
					currentPatient.setTemperature("cool");
				}
				
				//setting the patients aches based on what is submitted
				if(achesYes.isSelected())
				{
					currentPatient.setAches("yes");
				}
				else if(achesNo.isSelected())
				{
					currentPatient.setAches("no");
				}
				
				//setting the patients throat based on what is submitted
				if(throatYes.isSelected())
				{
					currentPatient.setThroat("yes");
				}
				else if(throatNo.isSelected())
				{
					currentPatient.setThroat("no");
				}
				
				//System.out.println(currentPatient);
				
				DataAlgorithm myDataAlgorithm = new DataAlgorithm(currentPatient);
				myDataAlgorithm.gettingTotals();
				myDataAlgorithm.calculations();
				results = myDataAlgorithm.returnResults();
				JOptionPane.showMessageDialog(this, results);
			}
			
		}
	}
}
