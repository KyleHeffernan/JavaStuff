/***********************************************
 * DeveloperGUI: this class 
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class DeveloperGUI extends JFrame implements ActionListener
{
	//attributes
	private JPanel menuPanel;
	private JButton menuButton;
	
	//constructor
	public DeveloperGUI()
	{
		//setting title
		super("Developer options");
		
		//setting type of layout
		setLayout(new GridLayout());
		
		//creating menuPanel
		menuPanel = new JPanel();
		menuPanel.setPreferredSize(new Dimension(300,50));
		add(menuPanel);
		
		
		//creating menuButton
		menuButton = new JButton("Main menu");
		menuButton.addActionListener(this);
		menuPanel.add(menuButton);
		
		//setting the layout and size of the frame
		setLayout(new GridLayout(1, 1));
		setSize(500,500);
		setVisible(true);	
	}
	
	public void actionPerformed(ActionEvent anything)
	{
		if(anything.getSource() == menuButton)
		{
			this.dispose();
			MenuGUI myMenuGUI = new MenuGUI();
		}
		
	}

}
