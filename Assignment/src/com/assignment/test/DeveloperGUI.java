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
		
		//Setting type of layout
		setLayout(new GridLayout());
		
		//Creating menuPanel
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,50));
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
		
		
		//creating showAll (text area)
		showAll = new JTextArea("All patients:");
		scroll = new JScrollPane(showAll, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setPreferredSize(new Dimension(440,290));
		displayPanel.add(scroll);
		displayPanel.setVisible(false);
		
		//Setting the layout and size of the frame
		setLayout(new GridLayout(2, 1));
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
		//if the testButton is pressed, testData() is called and the algorithm is tested
		else if(anything.getSource() == testButton)
		{
			DataAlgorithm myDataAlgorithm = new DataAlgorithm();
			accuracy = myDataAlgorithm.testData();
			JOptionPane.showMessageDialog(this, accuracy);
		}
		//If the showButton is pressed,
		else if(anything.getSource() == showButton)
		{
			//Instantiating an object of FileProcessor, with the filename data.csv
			FileProcessor fp = new FileProcessor("src\\com\\assignment\\test\\data.csv");
			fp.openFile();
			displayList = fp.readFile();
			fp.closeReadFile();
			
			displayString = ("All people: ");
			for(int i = 0; i < displayList.size(); i++)
			{
				displayString = displayString + displayList.get(i) + "\n";
			}
			showAll.setText(displayString);
			displayPanel.setVisible(true);
		}
	}

}
