/***********************************************
 * FileProcessor:
 * Java Assignment
 * Author: Kyle Heffernan
 * Date: 01/04/19
 ***********************************************/

package com.assignment.test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class FileProcessor
{
	//attributes
	private String fileName;
	private Scanner fileScanner;
	private File text;
	private PrintWriter writing;
	
	//constructor
	public FileProcessor(String fileName)
	{
		this.setFileName(fileName);
	}
	
	//opens file
	public void openFile()
	{
		setText(new File(getFileName()));
	}
	
	//reads through the file line by line
	String[] readFile()
	{
		String[] validRoles = new String[5];
		try
		{
			int i = 0;
			setFileScanner(new Scanner(getText()));
			while(getFileScanner().hasNextLine())
			{
				validRoles[i] = getFileScanner().nextLine();
				i++;
			}
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Run time error: " + e.getMessage());
		}
		
		return validRoles;
		
	}
	
	
	void fileWriting()
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
	
	void writeLine(String line)
	{
		getWriting().println(line);
	}
	
	//closes file
	public void closeReadFile()
	{
		getFileScanner().close();
	}
	
	//closes file
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
