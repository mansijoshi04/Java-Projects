/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
import java.util.Scanner;
public class Lab1Test {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		Lab1 lab1 = new Lab1();
		
		System.out.println("Collatz conjecture tester"); //shows this as output
		System.out.print("Enter start value:");
		int value = keyboard.nextInt();
		
		lab1.generateAllValues(value);
		keyboard.close();
	}
}
