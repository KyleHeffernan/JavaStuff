/***********************************************
 * DeveloperGUI: This is the GUI that lets the user test the accuracy of the algorithm 
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 09/04/19
 ***********************************************/


package com.assignment.test;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class DeveloperGUI extends JFrame implements ActionListener
{
	//Attributes
	private JPanel menuPanel;
	private JPanel displayPanel;
	private JButton menuButton;
	private JButton testButton;
	private JButton showButton;
	private JTextArea showAll;
	private JScrollPane scroll;
	private String accuracy;
	private String displayString;
	private ArrayList<Patient> displayList = new ArrayList<Patient>();
	
	//Constructor
	public DeveloperGUI()
	{
		//Setting title
		super("Developer options");
		
		
		//Creating menuPanel
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,65));
		add(menuPanel);
		
		//Creating displayPanel
		displayPanel = new JPanel();
		displayPanel.setPreferredSize(new Dimension(450,300));
		add(displayPanel);
		
		
		//Creating menuButton
		menuButton = new JButton("Main menu");
		menuButton.addActionListener(this);
		menuPanel.add(menuButton);
		
		//Creating testButton
		testButton = new JButton("Test accuracy");
		testButton.addActionListener(this);
		menuPanel.add(testButton);
		
		//Creating showButton
		showButton = new JButton("Display test data");
		showButton.addActionListener(this);
		menuPanel.add(showButton);
		
		
		//Creating showAll (text area)
		showAll = new JTextArea("All patients:");
		//Adding a scroll bar to the text area as there is a lot of text in it
		scroll = new JScrollPane(showAll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setPreferredSize(new Dimension(440,290));
		displayPanel.add(scroll);
		displayPanel.setVisible(false);
		
		//Setting the layout and size of the frame
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(500,500);
		setVisible(true);
		setLocation(200, 200);
	}
	
	public void actionPerformed(ActionEvent anything)
	{
		//If the menuButton is pressed, the user is returned to the main menu
		if(anything.getSource() == menuButton)
		{
			this.dispose();
			MenuGUI myMenuGUI = new MenuGUI();
		}
		
		//If the testButton is pressed, testData() is called and the algorithm is tested
		else if(anything.getSource() == testButton)
		{
			DataAlgorithm myDataAlgorithm = new DataAlgorithm();
			accuracy = myDataAlgorithm.testData();
			JOptionPane.showMessageDialog(this, accuracy);
		}
		
		//If the showButton is pressed, all of the contents of displayList are displayed in a textArea
		else if(anything.getSource() == showButton)
		{
			//Instantiating an object of FileProcessor, with the filename data.csv
			FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
			fp.openFile();
			displayList = fp.readFile();
			fp.closeReadFile();
			
			//Loops through each element of displayList, adding Patient to a string with is displayed in the textArea
			displayString = ("All patients: \n");
			for(int i = 0; i < displayList.size(); i++)
			{
				displayString = displayString + (i + 1) + ":"+ displayList.get(i) + "\n";
			}
			showAll.setText(displayString);
			displayPanel.setVisible(true);
		}
	}

}
