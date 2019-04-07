/***********************************************
 * Control: this class instantiates TestHashSet and calls it's functions
 * Java lab 9
 * Author: Kyle Heffernan
 * Date: 04/04/19
 ***********************************************/


package com.lab9.test;

import java.util.Iterator;

public class Control
{

	public static void main(String[] args)
	{
		//instantiating an object of TestHashSet
		TestHashSet myTestHashSet = new TestHashSet();
		myTestHashSet.printSet();
		
		//testing matchEntry method
		System.out.println(myTestHashSet.matchEntry("Estonia"));
		
		System.out.println("\n***\n");
		
		//myTestHashSet.clearSet();
		
		//testing addEntry method
		myTestHashSet.addEntry("Vatican city");
		myTestHashSet.printSet();
		
		System.out.println("\n***\n");
		
		//testing sortSet method
		Iterator<String> i = myTestHashSet.sortSet().iterator();
		while(i.hasNext())
		{
			System.out.println(i.next());
		}
		
		System.out.println("\n***\n");
		
		//testing reverseSet method
		Iterator<String> j = myTestHashSet.reverseSet().iterator();
		while(j.hasNext())
		{
			System.out.println(j.next());
		}
		
		System.out.println("\n***\n");
		
		//testing shuffleSet method
		Iterator<String> k = myTestHashSet.shuffleSet().iterator();
		while(k.hasNext())
		{
			System.out.println(k.next());
		}
		
	}

}
