
package com.example.assignment02;
import java.util.*;

//Define a class to represent potato chip bags
class PotatoChipBag{
	private int size; // Regular or Large (use constants below)
	private double weight; // oz
	public static final int REGULAR = 1;
	private static final double REGULAR_WEIGHT = 9.25; // oz
	public static final int LARGE = 2;
	private static final double LARGE_WEIGHT = 15.75;

	 // Default constructor
public PotatoChipBag() {
	this(REGULAR, REGULAR_WEIGHT);
	}
//Parameterized constructor
public PotatoChipBag(int size, double weight) {
	this.size=size;
	this.weight=weight;
	}
//Getter and setter methods for size and weight
public int getSize() {
return size;
	}

public void setSize(int size) {
this.size=size;	
	}

public double getWeight() {
	return weight;
	}

public void setWeight(double weight) {
this.weight=weight;	
	}

//Method to check if the bag weight is correct within a tolerance
public boolean isBagCorrectWeight() {
	  double epsilon = 0.01; // Tolerance for comparison

	  if (size == REGULAR) {
          return (weight >= REGULAR_WEIGHT - epsilon) && (weight <= REGULAR_WEIGHT + epsilon);
      } else if (size == LARGE) {
          return (weight >= LARGE_WEIGHT - epsilon) && (weight <= LARGE_WEIGHT + epsilon);
      } else {
          return false;
      }
}
}
//Class to handle user input
class User{
	private Scanner keyboard=new Scanner(System.in);
	
	// Method to input an integer
	public int inputInteger() {
		int value= keyboard.nextInt();
		keyboard.nextLine();
		return value;
	}
	  
	// Method to input a double
	public double inputDouble() {
		double value = keyboard.nextDouble();
		keyboard.nextLine();
		return value;	
	}
	
	public double inputDouble(String message) {
		System.out.println(message);
		double value =inputDouble();
		return value;
	}

	public String next() {
		// TODO Auto-generated method stub
		return null;
	}
}

//Main class
public class assignment02 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PotatoChipBag bag = new PotatoChipBag();
        User user = new User();
        Scanner sc= new Scanner(System.in);
        int goodBags = 0;
        int badBags = 0;
        int totalBags = 0;
        String shouldContinue = "";
        do {
        System.out.println("Enter bag size:");
        System.out.println("1 for regular size");
        System.out.println("2 for large size");

        int size = user.inputInteger();

        if (size != PotatoChipBag.REGULAR && size != PotatoChipBag.LARGE) {
                System.out.println("Invalid bag size entered");
                continue;
         }

         double weight = user.inputDouble("Enter weight:");

        bag.setSize(size);
        bag.setWeight(weight);

     if (bag.isBagCorrectWeight()) {
          goodBags++;
         } else {
              badBags++;
          }

         totalBags++;

       System.out.println("Good bags: " + goodBags);
       System.out.println("Bad bags: " + badBags);
       System.out.println("Total bags: " + totalBags);
       
       
       System.out.println("Is there another order? (Yes/No)");
        shouldContinue = sc.next();
        
        } while (shouldContinue.equalsIgnoreCase("Yes"));

        System.out.println("Program by Lee Gwen");
    }
}