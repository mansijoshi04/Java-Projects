/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
import java.util.Scanner;

	public class Lab3Test {
	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter the name of the store: ");
	        String storeName = scanner.nextLine();

	        System.out.print("Enter the number of employees: ");
	        int numEmployees = scanner.nextInt();
	        scanner.nextLine(); 

	        Store store = new Store(numEmployees);
	        store.readEmployeeDetails(scanner);

	        Store.printTitle(storeName);
	        store.printEmployeeDetails();

	        scanner.close();
	    }
	}

