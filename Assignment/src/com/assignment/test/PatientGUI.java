/***********************************************
 * PatientGUI: This is the GUI that lets the user create a Patient and test the probability of it having tonsillitis
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/


package com.assignment.test;

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


public class PatientGUI extends JFrame implements ActionListener
{
	//Attributes
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
	private JButton menuButton;
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
	private Patient currentPatient;
	private String results;
	
	
	//Constructor
	public PatientGUI()
	{
		//Setting title
		super("Enter Patient's symptoms");
		
		//Setting type of layout
		setLayout(new GridLayout());
				
		
		//Creating titlePanel
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(300,50));
		add(titlePanel);
		
		//Creating inputPanel1
		inputPanel1 = new JPanel();
		inputPanel1.setPreferredSize(new Dimension(300,50));
		add(inputPanel1);
		
		//Creating inputPanel2
		inputPanel2 = new JPanel();
		inputPanel2.setPreferredSize(new Dimension(300,50));
		add(inputPanel2);
		
		//Creating inputPanel3
		inputPanel3 = new JPanel();
		inputPanel3.setPreferredSize(new Dimension(300,50));
		add(inputPanel3);
		
		//Creating bottomPanel
		bottomPanel = new JPanel();
		bottomPanel.setPreferredSize(new Dimension(300,50));
		add(bottomPanel);
		
		
		//Creating titleLabel
		titleLabel = new JLabel("Please enter your symptoms");
		titlePanel.add(titleLabel);
		
		//Creating tempLabel
		tempLabel = new JLabel("Temperature: ");
		inputPanel1.add(tempLabel);
		
		//Creating achesLabel
		achesLabel = new JLabel("Aches: ");
		inputPanel2.add(achesLabel);
		
		//Creating throatLabel
		throatLabel = new JLabel("Sore throat: ");
		inputPanel3.add(throatLabel);
		
		
		//Creating tempButton group
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
		
		//Creating achesButton group
		achesGroup = new ButtonGroup();
		achesYes = new JRadioButton("Yes");
		achesNo = new JRadioButton("No");
		achesGroup.add(achesYes);
		achesGroup.add(achesNo);
		inputPanel2.add(achesYes);
		inputPanel2.add(achesNo);
		
		//Creating achesButton group
		throatGroup = new ButtonGroup();
		throatYes = new JRadioButton("Yes");
		throatNo = new JRadioButton("No");
		throatGroup.add(throatYes);
		throatGroup.add(throatNo);
		inputPanel3.add(throatYes);
		inputPanel3.add(throatNo);
		
		
		//Creating submitButton
		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		bottomPanel.add(submitButton);
		
		//Creating menuButton
		menuButton = new JButton("Main menu");
		menuButton.addActionListener(this);
		bottomPanel.add(menuButton);
				
		
		//Setting the layout and size of the frame
		setLayout(new GridLayout(5, 1));
		setSize(500,500);
		setVisible(true);
		setLocation(200, 200);
	}
	
	
	//Reactions to events
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
				
				//Setting the patients temperature based on what is submitted
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
				
				//Setting the patients aches based on what is submitted
				if(achesYes.isSelected())
				{
					currentPatient.setAches("yes");
				}
				else if(achesNo.isSelected())
				{
					currentPatient.setAches("no");
				}
				
				//Setting the patients throat based on what is submitted
				if(throatYes.isSelected())
				{
					currentPatient.setThroat("yes");
				}
				else if(throatNo.isSelected())
				{
					currentPatient.setThroat("no");
				}
				
				//Instantiating an object of DataAlgorithm, passing the users symptoms
				DataAlgorithm myDataAlgorithm = new DataAlgorithm(currentPatient);
				myDataAlgorithm.gettingTotals();
				myDataAlgorithm.calculations();
				//Displaying the result of the algorithm
				results = myDataAlgorithm.returnResults();
				JOptionPane.showMessageDialog(this, results);
			}
			
		}
		//If the menuButton is pressed, the user is returned to the main menu
		else if(anything.getSource() == menuButton)
		{
			this.dispose();
			MenuGUI myMenuGUI = new MenuGUI();
		}
	}
}
