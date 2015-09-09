/*
 * *Create an application that provides a solution for problem 20.8 
In addition to requirements specified in the description.  The class must satisfy the following

Default Constructor 
Two argument constructor for data used to initialize "first" and "second"
"toString" method for displaying the "first" and "second" data elements
Creates a  "Comparator" object (to be used by the sort method; i.e. 
create an instance of a  class that implements the interface [must override "compare" method])

The application must create an ArrayList of 5 Pair objects and then display the contents 
in sorted order largest to smallest, based on the method used to compare "Pair" objects.  
The class only supports types that extend Number. Assume the "Pair" objects contain x, y coordinates. 
Therefore calculate the distance from a 0,0 coordinate to determine 
the sorting order (i.e., ascending, smallest distance to largest distance).



Generic Class Pair
    Write a generic class Pair which as two type parameters - F and S -
each representing the type of the first and the second element of the pair,
respectively. Add get and set methods for the first and second elements of the pair.
[Hint: The class header should be public class Pair<F,S>.] 
 */

package project3;

import java.util.ArrayList;
import java.lang.Math;

public class Pair <F, S>
{
	private F firstElement;
	private S secondElement;
	private static ComparePair compare;
	
	public Pair()//default constructor
	{
	}
	
	public Pair(F firstElement, S secondElement)
	{
		this.firstElement = firstElement;
		this.secondElement = secondElement;
	}
	
	//sort method that accepts and array list to sort in order from smallest to lowest pair <assuming they are numbers>
	public static ArrayList<Pair<Double, Double>> sort
					(ArrayList<Pair<Double, Double>> sortPairArray)
	{
		//create a temporary array list to hold the sorted list to return
		ArrayList<Pair<Double, Double>> finalSort = 
				new ArrayList<Pair<Double, Double>>();
		
		compare = new ComparePair();//comparator object instantiated
	
		
		//loop to go through each item of the array
		for(int x = 0; x < sortPairArray.size(); x++)
		{
			//loop to go through each item already sorted in the new array to find where to insert new item
			for(int y = 0; y <= finalSort.size(); y++)
			{
				if(y==finalSort.size())//if the search is at the end of the sorted array then add the item at the end
				{
					finalSort.add(sortPairArray.get(x));
					break;//break out of for loop - not needed
				}
				if(compare.compare(sortPairArray.get(x), finalSort.get(y)) <= 0)//if the item is less than what is in the final array, insert item 
				{	
					finalSort.add(y, sortPairArray.get(x));
					break;//once item is added break out of for loop and continue to search
				}
			}
			
		}
		return finalSort;//return the sorted list
	}
	
	
	
	public double getDistance()//provides the distance of the two elements, assuming they are numbers from location 0,0
	{
		//return the length of the line by using x and y to make a triangle (Pythagorean Theorem)
				//c = sqrt(a^2 +b^2)
		return  Math.sqrt(Math.pow((double)this.getFirstElement(), 2) 
				+Math.pow((double)this.getSecondElement(), 2));
	}
	
	//toString method for displaying the "first" and "second" data elements
	public String toString()
	{
		return  firstElement.toString() + ", " + secondElement.toString();
	}
	
	//setter methods for the first and second elements
	public void setFirstElement(F firstElement)
	{
		this.firstElement = firstElement;
	}
	public void setSecondElement(S secondElement)
	{
		this.secondElement = secondElement;
	}
	
	
	//getter methods for the first and second Elements
	public F getFirstElement()
	{
		return this.firstElement;
	}
	public S getSecondElement()
	{
		return this.secondElement;
	}

	
}
