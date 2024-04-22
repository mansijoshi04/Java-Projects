/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: SortingAlgorithms is a Java class that provides implementations of various
 * sorting algorithms, including Bubble Sort, Insertion Sort, Selection Sort, Merge Sort,
 * and Quick Sort. These algorithms can be used to sort arrays of integers. The class offers
 * methods for each sorting algorithm and also contains helper methods for displaying arrays
 * and checking if an array is sorted. It serves as a utility for sorting arrays efficiently.
 */

import java.security.SecureRandom;
import java.util.Arrays;

public class SortingAlgorithms<T extends Comparable<T>> {
	
    /**
     * Generates an array of random integers.
     *
     * @param size The size of the array to generate.
     * @return An array of randomly generated integers.
     */
    public static Integer[] generateRandomInts(int size) {
        SecureRandom random = new SecureRandom();
        Integer[] randomArr = new Integer[size];

        for (int i = 0; i < size; i++) {
        	randomArr[i] = random.nextInt(880) + 120;  // Generate random integers between 10 and 100
        }

        return randomArr;
    }

    /**
     * Sorts an array using the Bubble Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (arr[i - 1].compareTo(arr[i]) > 0) {
                    // Swaps arr[i-1] and arr[i]
                    T temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    
    /**
     * Sorts an array using the Insertion Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void insertionSort(T[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && key.compareTo(arr[j]) < 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Sorts an array using the Selection Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void selectionSort(T[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                T temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }
    
    /**
     * Sorts an array using the Merge Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void mergeSort(T[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    private void mergeSort(T[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private void merge(T[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] leftArr = Arrays.copyOfRange(arr, left, mid + 1);
        T[] rightArr = Arrays.copyOfRange(arr, mid + 1, right + 1);

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            if (leftArr[i].compareTo(rightArr[j]) <= 0) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    /**
     * Sorts an array using the Quick Sort algorithm.
     *
     * @param arr The array to be sorted.
     */
    public void quickSort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        T temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
