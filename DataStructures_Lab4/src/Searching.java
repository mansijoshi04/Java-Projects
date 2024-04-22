/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: Searching is a utility class that provides methods for performing
 * recursive and iterative binary and linear searches on an array of integers. It
 * also offers options for displaying search results and various search algorithms.
 *
 */
import java.util.Arrays;

public class Searching<T extends Comparable<T>> {


    /**
     * Performs a binary search on the given array to find the target element.
     *
     * @param arr    The array to search.
     * @param target The element to find.
     * @return The index of the target element if found; otherwise, -1.
     */
	public int binarySearch(T[] arr, T target) {
	    if (arr == null) {
	        return -1; // or handle the null array case as needed
	    }
	    return binarySearch(arr, target, 0, arr.length - 1);
	}

    private int binarySearch(T[] arr, T target, int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid].equals(target)) {
                return mid; // Element found
            } else if (arr[mid].compareTo(target) < 0) {
                return binarySearch(arr, target, mid + 1, high);
            } else {
                return binarySearch(arr, target, low, mid - 1);
            }
        }
        return -1; // Element not found
    }

    /**
     * Performs a linear search on the given array to find the target element.
     *
     * @param arr    The array to search.
     * @param target The element to find.
     * @return The index of the target element if found; otherwise, -1.
     */
    public int linearSearch(T[] arr, T target) {
        return linearSearch(arr, target, 0);
    }

    private int linearSearch(T[] arr, T target, int index) {
        if (index < arr.length) {
            if (arr[index].equals(target)) {
                return index; // Element found
            } else {
                return linearSearch(arr, target, index + 1);
            }
        }
        return -1; // Element not found
    }
}
