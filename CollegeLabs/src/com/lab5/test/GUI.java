/***********************************************
 * GUI: this class tests out many GUI components
 * Java lab 5
 * Author: Kyle Heffernan
 * Date: 28/02/19
 ***********************************************/

package com.lab5.test;

//importing GUI modules
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener, MouseListener
{
	//Initializing UI components
	JButton button1;
	JButton button2;
	JLabel label1;
	JLabel label2;
	JPanel panel1;
	JPanel panel2;
	JTextField textField1;
	
	
	//constructor for setting up screen
	public GUI()
	{
		//setting title
		super("My first screen");
		
		//setting type of layout
		setLayout(new FlowLayout());
		
		//creating panel
		panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		//adding the panel to the frame
		add(panel1);
		
		
		//Creating button1
		button1 = new JButton("Button1");
		button1.setSize(70,70);
		button1.addActionListener(this);

		//adding button1 to panel 1
		panel1.add(button1);
		
		
		//Creating button2
		button2 = new JButton("Button2");
		button2.setSize(60,60);
		button2.addActionListener(this);

		//adding button2 to panel 1
		panel1.add(button2);
		
		
		//setting layout for panel 1
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		//creating 2nd panel with a label
		panel2 = new JPanel();
		label1 = new JLabel("This is the second panel");
		panel2.setBackground(Color.green);
		panel2.add(label1);
		
		//adding text field to panel 2
		textField1 = new JTextField("Name");
		textField1.setToolTipText("Enter your name");
		textField1.addActionListener(this);
		textField1.setSize(500, 40);
		panel2.add(textField1);
		
		
		panel2.addMouseListener(this);
		add(panel2);
		
		//setting the layout and size of the frame
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(800,800);
		setVisible(true);
		
	}
	
	//reactions to events
	public void actionPerformed(ActionEvent anything) 
	{
		//if button 1 is pressed
		if(anything.getSource() == button1)
		{
			JFrame popUp1 = new JFrame();
			label2 = new JLabel("Button 1 pressed");
			popUp1.add(label2);
			popUp1.setSize(200,200);
			popUp1.setVisible(true);
			

		}
		//if button 2 is pressed
		else if(anything.getSource() == button2)
		{
			System.out.println("Button 2 was clicked");

		}
		//if text is entered
		else if(anything.getSource() == textField1)
		{
			JFrame popUp2 = new JFrame();
			label2 = new JLabel("Name entered: " + textField1.getText());
			popUp2.add(label2);
			popUp2.setSize(200,200);
			popUp2.setVisible(true);
			
		}
		
	}
	
	//panel mouse over events
		public void mouseEntered(MouseEvent e)
		{
			JFrame popUp3 = new JFrame();
			label2 = new JLabel("You entered the panel");
			popUp3.add(label2);
			popUp3.setSize(200,200);
			popUp3.setVisible(true);
		}
		
		public void mouseExited(MouseEvent e)
		{
			JFrame popUp3 = new JFrame();
			label2 = new JLabel("You exited the panel");
			popUp3.add(label2);
			popUp3.setSize(200,200);
			popUp3.setVisible(true);
		}
		
		public void mouseClicked(MouseEvent event)
		{
			if(event.getButton() == MouseEvent.BUTTON1)
			{
				JFrame popUp3 = new JFrame();
				label2 = new JLabel("You left clicked the panel");
				popUp3.add(label2);
				popUp3.setSize(200,200);
				popUp3.setVisible(true);
			}
			else if(event.getButton() == MouseEvent.BUTTON3)
			{
				JFrame popUp3 = new JFrame();
				label2 = new JLabel("You right clicked the panel");
				popUp3.add(label2);
				popUp3.setSize(200,200);
				popUp3.setVisible(true);
			}
		}
		
		
		
		public void mouseReleased(MouseEvent e)
		{
			//
		}
		
		public void mousePressed(MouseEvent e)
		{
			//
		}

}