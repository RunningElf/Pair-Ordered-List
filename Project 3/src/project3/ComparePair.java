package project3;

import java.util.Comparator;
//import java.lang.Math;

//comparator class implementing comparator and overriding compare methods to use in the Pair sorting methods
public class ComparePair implements Comparator<Pair<Double, Double>>
{
	

	@Override
	public int compare(Pair<Double, Double> pair, Pair<Double, Double> pair2) {
		//if objects are the same distance from 0,0 return 0
		if(pair.getDistance() == pair2.getDistance()) 
			return 0;
		
		//compare the two elements in an x-y axis having 0,0 as starting point. Which object is closest to
		//0, 0 will come first. 
		else if(pair.getDistance() > pair2.getDistance())
			return 1;
		
		else //returns a negative number if object 2 comes before object 1 on the x-axis
			return -1;

	
	}
	
	

}
