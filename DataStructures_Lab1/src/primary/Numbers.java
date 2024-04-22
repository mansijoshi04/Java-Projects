/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 */


/**
 * This class represents a dynamic array of Float values and provides various
 * methods for manipulating and processing the array.
 *
 * @author mansi
 */
package primary;

import java.util.Scanner;

public class Numbers {
    private Float[] numbers; // Reference to a dynamically allocated array of Float references
    private int size; // Max size of the numbers array
    private int numItems; // Number of values currently in the array

    // Default constructor - initializes the array of size 5.
    public Numbers() {
        this.size = 5;
        this.numbers = new Float[size];
        this.numItems = 0;
    }

    // Initialize constructor using an int parameter to set the size of the array
    public Numbers(int size) {
        this.size = size;
        this.numbers = new Float[size];
        this.numItems = 0;
    }

    /**
     * Adds a new Float value to the array.
     * @param keyboard A Scanner object for user input.
     */
    public void addValue(Scanner keyboard) {
        if (numItems < size) {
            System.out.print("Enter a value: ");
            float value = keyboard.nextFloat();
            numbers[numItems++] = value;
        } else {
            System.out.println("Array is full.");
        }
    }

    /**
     * Calculates and returns the average of all the values in the array.
     * @return The average of the values in the array, or 0.0 if the array is empty.
     */
    public float calcAverage() {
        if (numItems == 0) {
            System.out.println("Array is empty. Cannot calculate average.");
            return 0.0f;
        }

        float sum = 0;
        for (int i = 0; i < numItems; i++) {
            sum += numbers[i];
        }
        return sum / numItems;
    }

    /**
     * Finds and returns an array containing the minimum value, maximum value, and
     * the result of (max mod min) from the values in the array.
     * @return An array of Float values where the first element is the minimum
     *         value, the second element is the maximum value, and the third element
     *         is the result of (max mod min). If the array is empty, all elements
     *         are set to null.
     */
    public Float[] findMinMax() {
        if (numItems == 0) {
            System.out.println("Array is empty. Cannot find min/max.");
            return new Float[]{null, null, null};
        }

        Float min = numbers[0];
        Float max = numbers[0];

        for (int i = 1; i < numItems; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        Float maxModMin = (max % min);

        return new Float[]{min, max, maxModMin};
    }

    /**
     * Calculates and returns the factorial of the integer part of the maximum
     * value in the array.
     * @return The factorial of the integer part of the maximum value in the
     *         array.
     */
    public float getFactorialMax() {
        if (numItems == 0) {
            System.out.println("Array is empty. Cannot calculate factorial.");
            return 0.0f;
        }

        float maxValue = numbers[0];
        for (int i = 1; i < numItems; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
        }

        int intPart = (int) maxValue;
        float factorial = 1.0f;

        for (int i = 1; i <= intPart; i++) {
            factorial *= i;
        }

        return factorial;
    }
    
    /**
     * Returns a string representation of the values in the array, with each value
     * on a separate line.
     * @return A string containing the values in the array, each on a new line.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Numbers are:\n"); // Start with a newline
        for (int i = 0; i < numItems; i++) {
            result.append(numbers[i]);
            if (i < numItems - 1) {
                result.append("\n"); // Add a newline character after each number
            }
        }
        return result.toString();
    }
}
