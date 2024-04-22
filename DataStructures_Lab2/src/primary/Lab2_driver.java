/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and its processing
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 */

/**
 *@author mansi
 */
package primary;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2_driver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Numbers numbers = null;
        boolean quit = false;

        while (!quit) {
            displayMainMenu();
            try {
            int choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    numbers = new Numbers();
                    System.out.println("Default array initialized.");
                    break;
                case 2:
                    System.out.print("Enter the new size of the array: ");
                    int size = keyboard.nextInt();
                    numbers = new Numbers(size);
                   // System.out.println("Array of size " + size + " initialized.");
                    break;
                case 3:
                    if (numbers == null) {
                        numbers = new Numbers(); // Initialize the array if it's not initialized
                    }
                    numbers.addValue(keyboard);
                    break;
                case 4:
                    if (numbers != null) {
                       // System.out.println("Numbers are:");
                        System.out.println(numbers);
                    } else {
                        System.out.println("");
                    }
                    break;
                case 5:
                    if (numbers != null) {
                        Float[] minMaxMod = numbers.findMinMax();
                        float factorialMax = numbers.getFactorialMax();
                        System.out.println("Average is: " + String.format("%.2f", numbers.calcAverage()) +
                                ", Minimum value is " + minMaxMod[0] +
                                ", Maximum value is " + minMaxMod[1] +
                                ", maxValue mod minValue is " +  String.format("%.2f", minMaxMod[2]) +
                                " factorial of Max is " + factorialMax);
                    } else {
                        System.out.println("Average is: 0.0, Minimum value is 0.0, Maximum value is 0.0 , max mod min is _______ factorial of Max is ____________");
                    }
                    break;

                case 6:
                    if (numbers == null) {
                        numbers = new Numbers();
                    }
                    numbers.addValues(keyboard, false); // Display messages
                    break;

                case 7:
                    if (numbers != null) {
                        System.out.print("Enter the name of the file to read data from: ");
                        String fileName = keyboard.next();
                        numbers.readValues(fileName);
                    } else {
                        System.out.println("Array is empty. Cannot read data.");
                    }
                    break;


                case 8:
                    if (numbers != null) {
                        System.out.print("Enter the name of the file to save data: ");
                        String fileName = keyboard.next();
                        numbers.saveValues(fileName);
                    } else {
                        System.out.println("Array is empty. Cannot save data.");
                    }
                    break;

                case 9:
                    quit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option (1-9).");
                    break;
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer between 1-9.");
            keyboard.nextLine();
        }
     }
    
   }
    /**
     *  Outputs the main menu to the console
     */
    public static void displayMainMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Initialize a default array");
        System.out.println("2: To specify the max size of the array");
        System.out.println("3: Add value to the array");
        System.out.println("4: Display values in the array");
        System.out.println("5: Display average of the values, minimum value, maximum value, max mod min, factorialMax");
        System.out.println("6: Add values in the array");
        System.out.println("7: Read data from a file");
        System.out.println("8: Save data to a file");
        System.out.println("9: To Exit");
        System.out.print("> ");
    }
}
