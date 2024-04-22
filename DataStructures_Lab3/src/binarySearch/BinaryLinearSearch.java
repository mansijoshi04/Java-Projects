/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description:: BinaryLinearSearch class provides methods for performing binary 
 * and linear searches on an array.It contains functions to generate random 
 * integers, perform iterative and recursive binary searches and iterative and recursive linear searches.
 */
package binarySearch;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author mansi
 *
 */
public class BinaryLinearSearch {
    private int[] randomArr;  // Array of randomly generated integers
    private int searchKey;    // Key to search for in the array

    /**
     * Generates an array of random integers.
     *
     * @param size The size of the array to generate.
     * @return An array of randomly generated integers.
     */
    public int[] generateRandomInts(int size) {
        SecureRandom random = new SecureRandom();
        int[] unsortedArr = new int[size];

        for (int i = 0; i < size; i++) {
            unsortedArr[i] = random.nextInt(91) + 10;  // Generate random integers between 10 and 100
        }

        return unsortedArr;
    }

    /**
     * Sets the randomly generated array.
     *
     * @param unsortedArr The array to set as the random array.
     */
    public void setRandomArray(int[] unsortedArr) {
        this.randomArr = unsortedArr;
    }

    /**
     * Performs an iterative binary search on a sorted array.
     *
     * @param sortedArr The sorted array to search.
     * @param key The key to search for.
     * @return The index where the key was found, or -1 if not found.
     */
    public int iterativeBinarySearch(int[] sortedArr, int key) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (sortedArr[mid] == key) {
                System.out.println("Number " + key + " found at index " + mid + ": Iterative Binary Search");
                return mid;
            }

            if (sortedArr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }

        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Performs a recursive binary search on a sorted array.
     *
     * @param sortedArr The sorted array to search.
     * @param key The key to search for.
     * @return The index where the key was found, or -1 if not found.
     */
    public int recursiveBinarySearch(int[] sortedArr, int key) {
        return recursiveBinarySearch(sortedArr, 0, sortedArr.length - 1, key);
    }

    /**
     * Performs a recursive binary search on a sorted array within a given range.
     *
     * @param arr   The sorted array to search.
     * @param left  The left index of the current search range.
     * @param right The right index of the current search range.
     * @param key   The key to search for.
     * @return The index where the key was found, or -1 if not found.
     */
    private int recursiveBinarySearch(int[] arr, int left, int right, int key) {
        if (left <= right) {
            int mid = left + (right - left) / 2;

            // Display binary search progress
            System.out.print("Binary Search Progress: ");
            displayBinarySearchProgress(arr, left, right, mid);

            if (arr[mid] == key) {
                System.out.println("Number " + key + " found at index " + mid + ": Recursive Binary Search");
                return mid;
            }

            if (arr[mid] < key)
                return recursiveBinarySearch(arr, mid + 1, right, key);
            else
                return recursiveBinarySearch(arr, left, mid - 1, key);
        }

        System.out.println("Number " + key + " was not found.");
        return -1;
    }

    /**
     * Displays the progress of binary search.
     *
     * @param arr   The array being searched.
     * @param left  The left index.
     * @param right The right index.
     * @param mid   The mid index.
     */
    private void displayBinarySearchProgress(int[] arr, int left, int right, int mid) {
        for (int i = left; i <= right; i++) {
            if (i == mid)
                System.out.print("[" + arr[i] + "] ");
            else
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * Performs an iterative linear search on an array.
     *
     * @param arr The array to search.
     * @param key The key to search for.
     */
    public void iterativeLinearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Number " + key + " found at index " + i + ": Iterative Linear Search");
                return;
            }
        }
        System.out.println("Number " + key + " was not found.");
    }

    /**
     * Performs a recursive linear search on an array.
     *
     * @param arr  The array to search.
     * @param key  The key to search for.
     * @return The index where the key was found, or -1 if not found.
     */
    public int recursiveLinearSearch(int[] arr, int key) {
        return recursiveLinearSearch(arr, 0, key);
    }

    /**
     * Performs a recursive linear search on an array starting from a specific index.
     *
     * @param arr   The array to search.
     * @param index The starting index for the search.
     * @param key   The key to search for.
     * @return The index where the key was found, or -1 if not found.
     */
    private int recursiveLinearSearch(int[] arr, int index, int key) {
        if (index >= arr.length) {
            System.out.println("Number " + key + " was not found.");
            return -1;
        }

        if (arr[index] == key) {
            System.out.println("Number " + key + " found at index " + index + ": Recursive Linear Search");
            return index;
        }

        return recursiveLinearSearch(arr, index + 1, key);
    }

    /**
     * Performs the search operations and measures their durations.
     */
    public void performSearch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number to search: ");
        int key = scanner.nextInt();

        long startTime, endTime, duration;

        // Perform iterative binary search
        startTime = System.nanoTime();
        iterativeBinarySearch(randomArr, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Iterative Binary Search Time: " + duration + " nanoseconds");

        // Perform recursive binary search
        startTime = System.nanoTime();
        recursiveBinarySearch(randomArr, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Recursive Binary Search Time: " + duration + " nanoseconds");

        // Perform iterative linear search
        startTime = System.nanoTime();
        iterativeLinearSearch(randomArr, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Iterative Linear Search Time: " + duration + " nanoseconds");

        // Perform recursive linear search
        startTime = System.nanoTime();
        recursiveLinearSearch(randomArr, key);
        endTime = System.nanoTime();
        duration = endTime - startTime;
        System.out.println("Recursive Linear Search Time: " + duration + " nanoseconds");
    }
}
