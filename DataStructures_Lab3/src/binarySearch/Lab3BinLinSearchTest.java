/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: Lab3BinLinSearchTest is a test class for BinaryLinearSearch that allows
 * the user to initialize and populate an array of random integers, and perform 
 * recursive and iterative binary and linear searches.
 *
 */
package binarySearch;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Lab3BinLinSearchTest {

    /**
     * The main method where the program starts execution.
     *
     * @param args The command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        BinaryLinearSearch binaryLinearSearch = new BinaryLinearSearch();
        Scanner scanner = new Scanner(System.in);

        int[] unsortedArr = null;  // Initialize array to be populated later
        int[] sortedArr = null;

        while (true) {
            System.out.println("Select your option in the menu:");
            System.out.println("1. Initialize and populate an array of 32 random integers.");
            System.out.println("2. Perform recursive binary and linear search.");
            System.out.println("3. Perform iterative binary and linear search.");
            System.out.println("4. Exit.");

            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Generate and set the random array
                        unsortedArr = binaryLinearSearch.generateRandomInts(32);
                        System.out.println("Unsorted Array: " + Arrays.toString(unsortedArr));

                        // Create a copy of the unsorted array and sort it for binary search
                        sortedArr = Arrays.copyOf(unsortedArr, unsortedArr.length);
                        Arrays.sort(sortedArr);
                        System.out.println("Sorted Array: " + Arrays.toString(sortedArr));
                        break;

                    case 2:
                        // Perform recursive binary and linear search
                        System.out.print("Enter the search key: ");
                        int recursiveSearchKey = scanner.nextInt();
                        binaryLinearSearch.setRandomArray(sortedArr);  // Set the random array for search
                        long startNanoRec = System.nanoTime();
                        binaryLinearSearch.recursiveBinarySearch(sortedArr, recursiveSearchKey);
                        long endNanoRec = System.nanoTime();
                        long durationNanoRec = endNanoRec - startNanoRec;
                        System.out.println("Time taken in (nanoseconds): " + durationNanoRec);
                        System.out.println("Time taken in (milliseconds): " + (durationNanoRec / 1e6));
                        System.out.println();
                        startNanoRec = System.nanoTime();
                        binaryLinearSearch.recursiveLinearSearch(unsortedArr, recursiveSearchKey);
                        endNanoRec = System.nanoTime();
                        durationNanoRec = endNanoRec - startNanoRec;
                        System.out.println("Time taken in (nanoseconds): " + durationNanoRec);
                        System.out.println("Time taken in (milliseconds): " + (durationNanoRec / 1e6));
                        System.out.println();
                        break;

                    case 3:
                    	// Perform iterative binary and linear search
                        System.out.print("Enter the search key: ");
                        int iterativeSearchKey = scanner.nextInt();
                        binaryLinearSearch.setRandomArray(sortedArr);  // Set the random array for search
                        long startNanoIter = System.nanoTime();
                        binaryLinearSearch.iterativeBinarySearch(sortedArr, iterativeSearchKey);
                        long endNanoIter = System.nanoTime();
                        long durationNanoIter = endNanoIter - startNanoIter;
                        System.out.println("Time taken in (nanoseconds): " + durationNanoIter);
                        System.out.println("Time taken in (milliseconds): " + (durationNanoIter / 1e6));
                        System.out.println();
                        startNanoIter = System.nanoTime();
                        binaryLinearSearch.iterativeLinearSearch(unsortedArr, iterativeSearchKey);
                        endNanoIter = System.nanoTime();
                        durationNanoIter = endNanoIter - startNanoIter;
                        System.out.println("Time taken in (nanoseconds): " + durationNanoIter);
                        System.out.println("Time taken in (milliseconds): " + (durationNanoIter / 1e6));
                        System.out.println();
                        break;

                    case 4:
                        scanner.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                // Handle InputMismatchException by clearing the invalid input and displaying a message
                System.out.println("*****Input Mismatch. Please enter a valid integer.*****");
                scanner.next();
            }
        }
    }
}
