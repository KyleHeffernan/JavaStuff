/***********************************************
 * GUI: this class simulates a person
 * Java lab 8
 * Author: Kyle Heffernan
 * Date: 27/03/19
 ***********************************************/

package com.lab8.test;

//importing GUI modules
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener
{
	//Initializing UI components
	private JButton saveButton;
	private JButton showButton;
	private JButton deleteButton;
	private JPanel panel1;
	private JPanel panel2;
	private JPanel panel3;
	private JTextField fieldFirstName;
	private JTextField fieldSurName;
	private JTextField fieldCity;
	private JTextArea showAll;
	private ArrayList<Person> people = new ArrayList<Person>();
	private int i = 0;
	private String stringPeople;
	
	
	//constructor
	public GUI()
	{
		//setting title
		super("Lab 8 GUI");
		
		//setting type of layout
		setLayout(new FlowLayout());
		
		
		//creating panel 1
		panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		add(panel1);
		
		//creating panel 2
		panel2 = new JPanel();
		panel2.setBackground(Color.green);
		add(panel2);
		
		//creating panel 3
		panel3 = new JPanel();
		add(panel3);
		
		
		//adding text field to panel 1
		fieldFirstName = new JTextField("firstName");
		fieldFirstName.setToolTipText("Enter First Name");
		fieldFirstName.setPreferredSize(new Dimension(85,25));
		panel1.add(fieldFirstName);
		
		//adding text field to panel 1
		fieldSurName = new JTextField("surName");
		fieldSurName.setToolTipText("Enter Surname");
		fieldSurName.setPreferredSize(new Dimension(85,25));
		panel1.add(fieldSurName);
		
		//adding text field to panel 1
		fieldCity = new JTextField("city");
		fieldCity.setToolTipText("Enter City");
		fieldCity.setPreferredSize(new Dimension(85,25));
		panel1.add(fieldCity);
		
		
		//creating saveButton
		saveButton = new JButton("Save");
		saveButton.addActionListener(this);
		panel2.add(saveButton);
		
		//creating showButton
		showButton = new JButton("Show all");
		showButton.addActionListener(this);
		panel2.add(showButton);
		
		//creating deleteButton
		deleteButton = new JButton("Delete");
		deleteButton.addActionListener(this);
		panel2.add(deleteButton);
		
		
		//creating text area
		showAll = new JTextArea("All people:");
		showAll.setVisible(false);
		showAll.setPreferredSize(new Dimension(400,300));
		panel3.add(showAll);

				
		//setting the layout and size of the frame
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(600,500);
		setVisible(true);
	}
	
	//reactions to events
	public void actionPerformed(ActionEvent anything) 
	{
		i = 0;
		//if saveButton is pressed
		if(anything.getSource() == saveButton)
		{
			people.add(new Person(fieldFirstName.getText(), fieldSurName.getText(), fieldCity.getText()));
			JOptionPane.showMessageDialog(this, "Just added: " + people.get(people.size() - 1));
			i++;
		}
		
		//if showButton is pressed
		else if(anything.getSource() == showButton)
		{
			stringPeople = ("All people: ");
			for(i = 0; i < people.size(); i++)
			{
				
				stringPeople = stringPeople + people.get(i) + "\n";
			}
			showAll.setVisible(true);
			showAll.setText(stringPeople);
		}
		
		//if deleteButton is pressed
		else if(anything.getSource() == deleteButton)
		{
			people.clear();
		}
	}

}
