/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
import java.util.Scanner;

public class Employee {
	// initialization and declaring variables
	    private int employeeNumber;
	    private Person emp;
	    private double numHours;
	    private double hourlyPay;

	    public Employee(int employeeNumber, Person emp, double numHours, double hourlyPay) {
	        this.employeeNumber = employeeNumber;
	        this.emp = emp;
	        this.numHours = numHours;
	        this.hourlyPay = hourlyPay;
	    }

	    public Employee() {
	    }

	    public void readEmployee(Scanner scanner) {
	    	
	    	//prompts the user to enter the details of the employee
	    	//and takes the input from the user
	        System.out.print("Enter employee number: ");
	        employeeNumber = scanner.nextInt();
	        scanner.nextLine(); 

	        System.out.print("Enter first name: ");
	        String firstName = scanner.nextLine();

	        System.out.print("Enter last name: ");
	        String lastName = scanner.nextLine();

	        System.out.print("Enter email: ");
	        String email = scanner.nextLine();

	        System.out.print("Enter phone number: ");
	        long phoneNumber = scanner.nextLong();
	        scanner.nextLine(); 

	        System.out.print("Enter number of hours worked: ");
	        numHours = scanner.nextDouble();

	        System.out.print("Enter hourly pay: ");
	        hourlyPay = scanner.nextDouble();
	        
	        //constructor
	        emp = new Person(firstName, lastName, email, phoneNumber);
	        
	    }
	    public int getEmployeeNumber() {
			return employeeNumber;
		}

		public void setEmployeeNumber(int employeeNumber) {
			this.employeeNumber = employeeNumber;
		}

		public double getNumHours() {
			return numHours;
		}

		public void setNumHours(double numHours) {
			this.numHours = numHours;
		}

		public double getHourlyPay() {
			return hourlyPay;
		}

		public void setHourlyPay(double hourlyPay) {
			this.hourlyPay = hourlyPay;
		}

		//formats and output the input by user for the final table
	    public void printEmployee() {
		System.out.printf("%10d| %20s| %15s| %15s| %10d| %10.2f\n", employeeNumber , emp.getFirstName(),
				emp.getLastName(), emp.getEmail(), emp.getPhoneNumber(), numHours*hourlyPay);
			}
	   
	}

