/***********************************************
 * MenuGUI: this class 
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 09/04/19
 ***********************************************/


package com.assignment.test;

//importing GUI modules
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
	//declaring attributes
	private JPanel patientPanel;
	private JPanel developerPanel;
	private JButton patientButton;
	private JButton developerButton;
	
	//constructor
	public MenuGUI()
	{
		//setting title
		super("Main menu");
		
		//setting type of layout
		setLayout(new GridLayout());
		
		//creating patientPanel
		patientPanel = new JPanel();
		patientPanel.setPreferredSize(new Dimension(300,50));
		add(patientPanel);
				
		//creating developerPanel
		developerPanel = new JPanel();
		developerPanel.setPreferredSize(new Dimension(300,50));
		add(developerPanel);

		
		//creating patientButton
		patientButton = new JButton("Add a Patient");
		patientButton.addActionListener(this);
		patientPanel.add(patientButton);
		
		//creating developerButton
		developerButton = new JButton("Developer options");
		developerButton.addActionListener(this);
		developerPanel.add(developerButton);
		
		//setting the layout and size of the frame
		setLayout(new GridLayout(1, 2));
		setSize(500,500);
		setVisible(true);		
	}

	
	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == patientButton)
		{
			this.dispose();
			PatientGUI myPatientGUI = new PatientGUI();
		}
		else if(anything.getSource() == developerButton)
		{
			this.dispose();
			DeveloperGUI myDeveloperGUI = new DeveloperGUI();
		}
		
	}
}
