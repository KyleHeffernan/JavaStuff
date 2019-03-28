/***********************************************
 * Animal: This class simulates an animal has has the different traits of certain animals.
 * Java lab 2
 * Author: Kyle Heffernan
 * Date: 07/02/19
 ***********************************************/


package com.lab2.test;

public class Animal 
{
	//attributes
	private String name;
	private String breed;
	private int age;
	private boolean domesticAnimal;
	private String colour;
	
	//constructor
	public Animal(String name)
	{
		this.name = name;
		
	}
	//constructor
	public Animal(String name, String breed, int age, boolean domesticAnimal, String colour)
	{
		this.name = name;
		this.setBreed(breed);
		this.setAge(age);
		this.setDomesticAnimal(domesticAnimal);
		this.setColour(colour);
	}
	
	//toString() to print everything
	public String toString()
	{
		String summary = ("\nThis animal is called: " + this.name + "\nIt's breed is: " +this.getBreed() + "\nIt's age is: " + this.getAge() + "\nDomestic animal?: " +this.isDomesticAnimal() +"\nColour: " + this.getColour());
		
		return summary;
	}
	
	
	//SETTERS AND GETTERS
	
	public void setName(String name)
	{
		this.name = name;
	
	}
	public String getName()
	{
		return this.name;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isDomesticAnimal() {
		return domesticAnimal;
	}
	public void setDomesticAnimal(boolean domesticAnimal) {
		this.domesticAnimal = domesticAnimal;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	
	//make noise method
	public void makeNoise()
	{
		if(this.breed.equals("dog"))
		{
			System.out.println("bark");
		} 
		else if(this.breed.equals("cat"))
		{
			System.out.println("meow");
		}
		else if(this.breed.equals("lion"))
		{
			System.out.println("roar");
		}
	}
	
	public void makeNoise(boolean old)
	{
		if(old)
		{
			System.out.println("Quiet animal");
		}
		else
		{
			makeNoise();
		}
		
	}
	
}