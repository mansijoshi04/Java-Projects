/*
 * A brief description of the role of this class
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
public class Person {

	// initialization and declaring variables
	    private String firstName;
	    private String lastName;
	    private String email;
	    private long phoneNumber;

	    public Person(String firstName, String lastName, String email, long phoneNumber) {
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	    }
	    
	    //Accessors and mutators for variables
	    public String getFirstName() {
	        return firstName;
	    }

	    public String getLastName() {
	        return lastName;
	    }

	    public String getName() {
	        return firstName + " " + lastName;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public long getPhoneNumber() {
	        return phoneNumber;
	    }
	}

