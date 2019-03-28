package com.lab4.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;

public class SimpleGUI extends JFrame implements ActionListener
{
	JButton button1;
	//can now use button anywhere
	
	
	//constructor for setting up screen
	public SimpleGUI()
	{
		
		super("My first screen");
		JButton button1 = new JButton("Click this to make something happen");

		add(button1);
		
		//link the listener to the button you want to monitor
		button1.addActionListener(this);;
		
		setSize(400,400);
		setVisible(true);
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent anything) 
	{
		System.out.println("The button was clicked");
		
	}

}
