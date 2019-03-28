/***********************************************
 * Control: This acts as a control class in which objects are created.
 * Java lab 2
 * Author: Kyle Heffernan
 * Date: 07/02/19
 ***********************************************/

package com.lab2.test;

public class Control
{

	public static void main(String[] args)
	{
		//Animal a1 = new Animal("Leo");
		Animal a2 = new Animal("Spot","dog", 4, true, "brown");
		
		//printing objects using toString()
		//System.out.println(a1);
		//System.out.println(a2);

		//using SETTERS AND GETTERS
		//name
		a2.setName("Sam");
		System.out.println(a2.getName());
		
		//breed
		a2.setBreed("cat");
		System.out.println(a2.getBreed());
		
		//age
		a2.setAge(5);
		System.out.println(a2.getAge());
		
		//is it a domestic animal
		a2.setDomesticAnimal(true);
		System.out.println(a2.isDomesticAnimal());
		
		//colour
		a2.setColour("green");
		System.out.println(a2.getColour());
		
		//testing makeNoise methods
		a2.makeNoise(false);
		a2.makeNoise(true);
	}

}