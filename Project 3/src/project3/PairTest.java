package project3;

import java.util.ArrayList;
import java.util.Scanner;

//Application to accept 5 different pairs of numbers from the user
//these pairs will represent an x, y coordinate and will order them from closest 
//to farthest from the coordinates 0,0 then display them

public class PairTest {

	//test the pair object by creating a list of 5 pair of Numbers
	
	public static ArrayList<Pair<Double, Double>> listOfPairs;//will accept 5 pairs into a list 
	public static Scanner input;
	
	public static void main(String[] args) {
	
	input = new Scanner(System.in);
	listOfPairs = new ArrayList<Pair<Double, Double>>();
	
	userInput();//method that allows user to input paired numbers 
		//I seperated in another method to easily be accessed and changed in need
	
	printList();
	System.out.println("Now the list ordered closest to (0,0) to the farthest from (0,0)");
	
	listOfPairs = Pair.sort(listOfPairs);//replace the current list with the sorted list prived by method
	printList();
	

	}
	
	private static void userInput()
	{
		double firstNumber, secondNumber;
		for(int x = 0; x <5; x++)//places a loop to accept 5 answers from the user and inputs into the array
		{
			System.out.print("Input the x coordinate: ");
			firstNumber = input.nextDouble();
			System.out.print("Input the y coordinate: ");
			secondNumber = input.nextDouble();
			System.out.println("");
			
			listOfPairs.add(new Pair<Double, Double>(firstNumber,secondNumber));//adds new object of Pair to list
			
			
			
			
		}
	}
	
	private static void printList() //prints the list of pairs
	{
		Pair<Double, Double> tempPair;
		for(int x= 0; x <listOfPairs.size(); x++)
		{
			tempPair = listOfPairs.get(x);
			System.out.printf("Location: (%s); Distance from (0,0) is %.2f%n", tempPair.toString(), tempPair.getDistance());
		}
		System.out.println();
	}

}
