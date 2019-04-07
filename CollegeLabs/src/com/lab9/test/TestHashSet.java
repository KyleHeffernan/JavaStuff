/***********************************************
 * TestHashSet: This class uses many methods from the java Collection framework
 * Java lab 9
 * Author: Kyle Heffernan
 * Date: 04/04/19
 ***********************************************/



package com.lab9.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TestHashSet
{
	private Set<String> countries = new HashSet<String>();
	
	
	//constructor
	public TestHashSet()
	{
		String[] countriesString = 
			{"Albania", "Andorra", "Austria", "Belarus", "Belgium", "Bosnia Herzegovina", "Bulgaria", "Croatia", "Cyprus",
				"Czech Republic", "Denmark", "Estonia", "Hungary", "Iceland", "Ireland", "Italy", "Kosovo", "Latvia", "Liechtenstein",
				"Lithuania", "Luxemburg", "Macedonia", "Malta", "Moldova", "Monaco", "Montenegro", "Norway", "Poland",
				"Portugal", "Romania", "Russia", "San Marino", "Serbia", "Slovakia", "Slovenia", "Spain",
				"Sweden", "Switzerland", "the Netherlands", "the United Kingdom", "Turkey", "Ukraine"};
			
		for(int i = 0; i < countriesString.length; i++)
		{
			getCountries().add(countriesString[i]);
		}
		
	}
	
	
	public void printSet()
	{
		Iterator<String> i = countries.iterator();
		
		while(i.hasNext())
		{
			
			System.out.println(i.next());
		}
		
		
	}
	
	
	public void addEntry(String country)
	{
		countries.add(country);
	}

	
	public boolean matchEntry(String country)
	{
		return countries.contains(country);
	}
	
	
	public void clearSet()
	{
		countries.clear();
	}
	
	
	public ArrayList<String> sortSet()
	{
		ArrayList<String> sortedCountries = new ArrayList<String>(countries);
		Collections.sort(sortedCountries);
		
		return sortedCountries;
	}
	
	
	public ArrayList<String> reverseSet()
	{
		ArrayList<String> reversedCountries = new ArrayList<String>(countries);
		Collections.sort(reversedCountries);
		Collections.reverse(reversedCountries);
		
		return reversedCountries;
	}

	
	public ArrayList<String> shuffleSet()
	{
		ArrayList<String> shuffledCountries = new ArrayList<String>(countries);
		Collections.shuffle(shuffledCountries);
		
		return shuffledCountries;
	}
	
	
	
	//GETTERS AND SETTERS
	public Set<String> getCountries() {
		return countries;
	}

	public void setCountries(Set<String> countries) {
		this.countries = countries;
	}

}
