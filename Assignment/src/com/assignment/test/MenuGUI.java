/***********************************************
 * MenuGUI: This is the GUI that lets the user select what they want to do
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 09/04/19
 ***********************************************/


package com.assignment.test;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;


public class MenuGUI extends JFrame implements ActionListener
{
	//Attributes
	private JPanel patientPanel;
	private JPanel developerPanel;
	private JButton patientButton;
	private JButton developerButton;
	
	//Constructor
	public MenuGUI()
	{
		//Setting title
		super("Main menu");
		
		//Setting type of layout
		setLayout(new GridLayout());
		
		//Creating patientPanel
		patientPanel = new JPanel();
		patientPanel.setPreferredSize(new Dimension(300,50));
		add(patientPanel);
				
		//Creating developerPanel
		developerPanel = new JPanel();
		developerPanel.setPreferredSize(new Dimension(300,50));
		add(developerPanel);

		
		//Creating patientButton
		patientButton = new JButton("Add a Patient");
		patientButton.addActionListener(this);
		patientPanel.add(patientButton);
		
		//Creating developerButton
		developerButton = new JButton("Developer options");
		developerButton.addActionListener(this);
		developerPanel.add(developerButton);
		
		//Setting the layout and size of the frame
		setLayout(new GridLayout(1, 2));
		setSize(500,500);
		setVisible(true);		
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
