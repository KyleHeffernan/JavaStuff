/***********************************************
 * MenuGUI: This is the GUI that lets the user is initially greeted with, allowing them to test a patient or enter dev options
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 09/04/19
 ***********************************************/


package com.assignment.test;

import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuGUI extends JFrame implements ActionListener
{
	//Attributes
	private JPanel titlePanel;
	private JPanel buttonPanel;
	private JLabel titleLabel;
	private JButton patientButton;
	private JButton developerButton;
	
	//Constructor
	public MenuGUI()
	{
		//Setting title
		super("Main menu");
		
		
		//Creating titlePanel
		titlePanel = new JPanel();
		titlePanel.setPreferredSize(new Dimension(450,50));
		add(titlePanel);
		
		//Creating buttonPanel
		buttonPanel = new JPanel();
		add(buttonPanel);
		
		
		//Creating titleLabel
		titleLabel = new JLabel("Tonsillitis Checker");
		titlePanel.add(titleLabel);
		
		
		//Creating patientButton
		patientButton = new JButton("Test a Patient");
		patientButton.addActionListener(this);
		buttonPanel.add(patientButton);
		
		//Creating developerButton
		developerButton = new JButton("Developer options");
		developerButton.addActionListener(this);
		buttonPanel.add(developerButton);
		
		
		//Setting the layout and size of the frame
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(500,500);
		setVisible(true);
		setLocation(200, 200);
	}

	
	public void actionPerformed(ActionEvent anything)
	{
		//If patientButton is pressed, it brings the user to PatientGUI
		if(anything.getSource() == patientButton)
		{
			this.dispose();
			PatientGUI myPatientGUI = new PatientGUI();
		}
		//If developerButton is pressed, it brings the user to DeveloperGUI
		else if(anything.getSource() == developerButton)
		{
			this.dispose();
			DeveloperGUI myDeveloperGUI = new DeveloperGUI();
		}
		
	}
}
