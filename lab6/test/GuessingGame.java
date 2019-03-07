/***********************************************
 * GuessingGame: this class simulates a guessing game using a GUI
 * Java lab 6
 * Author: Kyle Heffernan
 * Date: 07/03/19
 ***********************************************/

package com.lab6.test;

//importing GUI modules
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GuessingGame extends JFrame implements ActionListener
{
	//Initializing UI components
	JButton generateButton;
	JButton checkButton;
	JLabel label1;
	JLabel popUpLabel;
	JPanel panel1;
	JPanel panel2;
	JTextField textField1;
	//initializing variables
	private int randomNum;
	private int guesses = 0;
	private int guessNum;
	private boolean generated = false;
	private boolean errorCaught;
	
	//constructor for setting up screen
	public GuessingGame()
	{
		//setting title
		super("Guessing Game");
		
		//setting type of layout
		setLayout(new FlowLayout());
		
		//creating panel 1
		panel1 = new JPanel();
		panel1.setBackground(Color.blue);
		//adding the panel to the frame
		add(panel1);
		
		
		//creating generateButton
		generateButton = new JButton("Generate the random number");
		generateButton.setSize(70,70);
		generateButton.addActionListener(this);

		//adding generateButton to panel 1
		panel1.add(generateButton);
		
		
		//Creating checkButton
		checkButton = new JButton("Check your guess");
		checkButton.setSize(60,60);
		checkButton.addActionListener(this);

		//adding button2 to panel 1
		panel1.add(checkButton);
		
		
		//setting layout for panel 1
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		//creating 2nd panel with a label
		panel2 = new JPanel();
		label1 = new JLabel("Then make a guess");
		panel2.setBackground(Color.green);
		panel2.add(label1);
		
		//adding text field to panel 2
		textField1 = new JTextField("Enter your guess");
		textField1.setToolTipText("Enter a number from 0 to 100");
		textField1.addActionListener(this);
		textField1.setSize(500, 40);
		panel2.add(textField1);
		
		//adding the panel to the frame
		add(panel2);
		
		//setting the layout and size of the frame
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setSize(800,800);
		setVisible(true);
		
	}
	
	//reactions to events
	public void actionPerformed(ActionEvent anything) 
	{
		//if generateButton is pressed
		if(anything.getSource() == generateButton)
		{
			Random rando = new Random();
			randomNum = rando.nextInt(100);
			generated = true;
			
			System.out.println(randomNum);
		}
		
		//if text is entered or if checkButton is pressed
		else if(anything.getSource() == textField1 || anything.getSource() == checkButton)
		{
			//resetting error check
			errorCaught = false;
			//makes sure a number has been generated before its compared
			if(generated == false)
			{
				JOptionPane.showMessageDialog(this, "Please generate a number first");
				
			}
			else
			{
				//making sure a number was input
				try
				{
					guessNum = Integer.valueOf(textField1.getText());
					
				}
				catch(java.lang.NumberFormatException e)
				{
					JOptionPane.showMessageDialog(this, "Please enter a number between 0 and 100");
					errorCaught = true;
				}
				
				
				if(errorCaught == false)
				{
					
					if(guessNum > 100 || guessNum < 0)
					{
						JOptionPane.showMessageDialog(this, "Please enter a number between 0 and 100");
					}
					//if the input was suitable the numbers are compared
					else
					{
						guesses++;
						//correct answer entered
						if(randomNum == guessNum)
						{
							JOptionPane.showMessageDialog(this, "You entered: " +textField1.getText() + "\n\nCorrect! \n\n Number of guesses: " +guesses);
							
						}
						//answered too high
						else if(randomNum < guessNum)
						{
							JOptionPane.showMessageDialog(this, "You entered: " +textField1.getText() + "\n\nGuess lower!");
							
						}
						//answered too low
						else if(randomNum > guessNum)
						{
							JOptionPane.showMessageDialog(this, "You entered: " +textField1.getText() + "\n\nGuess higher!");
							
						}
					}
				}//end if
			}//end else
		}//end else if
		
	}//end actionPerformed

}