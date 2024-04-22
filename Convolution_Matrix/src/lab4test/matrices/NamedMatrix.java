/*
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package lab4test.matrices;

public class NamedMatrix extends Matrix {//inherits class Matrix
    private String name;

    public NamedMatrix(String name, double[][] array) {
        //calls the super class to initialize Matrix
    	super(array);
        this.name = name;
    }

    public String getName() {
        return name;//returns the name of the Matrix
        
    }
}
