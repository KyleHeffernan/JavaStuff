/***********************************************
 * FileProcessor: This class reads through a file line by line, and adds each line to a new Patient in patientList
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/

package com.assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FileProcessor
{
	//Attributes
	private String fileName;
	private Scanner fileScanner;
	private File text;
	private PrintWriter writing;
	private ArrayList<Patient> patientList = new ArrayList<Patient>();
	
	//Constructor
	public FileProcessor(String fileName)
	{
		this.setFileName(fileName);
	}
	
	//Opens file
	public void openFile()
	{
		setText(new File(getFileName()));
	}
	
	//Reads through the file line by line
	public ArrayList<Patient> readFile()
	{
		try
		{
			setFileScanner(new Scanner(getText()));
			while(getFileScanner().hasNextLine())
			{
				//Puts the current line into a string
				String line = getFileScanner().nextLine();
				//Splits the string by each comma, and puts the remaining strings into a string array
				String[] words = line.split(",");
				//Adds a new Patient to patientList using the elements from the string array
				patientList.add(new Patient(words[0], words[1], words[2], words[3]));
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Run time error: " + e.getMessage());
		}
		return patientList;
	}
	
	
	public void fileWriting()
	{
		try
		{
			setWriting(new PrintWriter(getText()));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Run time error: " + e.getMessage());
			
		}
	}
	
	public void writeLine(String line)
	{
		getWriting().println(line);
	}
	
	//Closes file
	public void closeReadFile()
	{
		getFileScanner().close();
	}
	
	//Closes file
	public void closeWriteFile()
	{
		getWriting().close();
	}

	
	//SETTERS AND GETTERS
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Scanner getFileScanner() {
		return fileScanner;
	}

	public void setFileScanner(Scanner fileScanner) {
		this.fileScanner = fileScanner;
	}

	public File getText() {
		return text;
	}

	public void setText(File text) {
		this.text = text;
	}

	public PrintWriter getWriting() {
		return writing;
	}

	public void setWriting(PrintWriter writing) {
		this.writing = writing;
	}
	
	
}
