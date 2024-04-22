import java.util.Arrays;

/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */

public class Lab1 {
	
	// computes the value based on if it's even or odd
	public int computeNextValue(int value) {
		int nextValue;
		if (value % 2 == 0) {
			nextValue = value/2;
		} else {
			nextValue = value * 3 + 1;
		}
		return nextValue;
	}
	
	// generates all the values for the sequence
	public void generateAllValues(int value) {
		int count = 1;
		System.out.println(value);
		while(value != 1) {
			value = computeNextValue(value);
			System.out.println(value);
			count++;
		}
	//prints how long the sequence is
	System.out.printf("Sequence is %d long" , count);
	}		
}

