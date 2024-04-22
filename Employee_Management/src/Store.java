/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
import java.util.Scanner;

class Store {
	private Employee[] employees;

	public Store(int size) {
		employees = new Employee[size];
	}

	//prompts user to enter the details of employee until it reaches
	//the number of employee input by user 
	public void readEmployeeDetails(Scanner scanner) {
		for (int i = 0; i < employees.length; i++) {
			System.out.printf("Enter details for Employee %d:\n", i + 1);
			employees[i] = new Employee();
			employees[i].readEmployee(scanner);
		}
	}
	
	public static void printLine() {
		System.out.println("============================================="
		  + "============================================================");
	}

	public static void printTitle(String storeName) {
		printLine();
		System.out.printf("\t"+"\t"+"%s Store Managment System\n", storeName);
		printLine();
	}
	
	//prints employee details and put proper spacing and format
	public void printEmployeeDetails() {
				
		System.out.printf("%10s| %20s| %15s| %15s| %10s| %10s\n",
				"Emp #", "First Name", "Last Name", "Email","Phone", "Salary");
		
		printLine();
		for (int i = 0; i < employees.length; i++) {
			employees[i].printEmployee();
		}


	}


}