/***********************************************
 * DeveloperGUI: This is the GUI that lets the user test the accuracy of the algorithm 
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;


public class DeveloperGUI extends JFrame implements ActionListener
{
	//Attributes
	private JPanel menuPanel;
	private JPanel testPanel;
	private JButton menuButton;
	private JButton testButton;
	private String accuracy;
	
	//Constructor
	public DeveloperGUI()
	{
		//Setting title
		super("Developer options");
		
		//Setting type of layout
		setLayout(new GridLayout());
		
		//Creating menuPanel
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,50));
		add(menuPanel);
		
		//Creating testPanel
		testPanel = new JPanel();
		testPanel.setPreferredSize(new Dimension(300,50));
		add(testPanel);
		
		
		//Creating menuButton
		menuButton = new JButton("Main menu");
		menuButton.addActionListener(this);
		menuPanel.add(menuButton);
		
		//Creating testButton
		testButton = new JButton("Test accuracy");
		testButton.addActionListener(this);
		testPanel.add(testButton);
		
		//Setting the layout and size of the frame
		setLayout(new GridLayout(1, 2));
		setSize(500,500);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent anything)
	{
		//If the menuButton is pressed, the user is returned to the main menu
		if(anything.getSource() == menuButton)
		{
			this.dispose();
			MenuGUI myMenuGUI = new MenuGUI();
		}
		//if the testButton is pressed, testData() is called and the algorithm is tested
		else if(anything.getSource() == testButton)
		{
			DataAlgorithm myDataAlgorithm = new DataAlgorithm();
			accuracy = myDataAlgorithm.testData();
			JOptionPane.showMessageDialog(this, accuracy);
		}
		
	}

}
