import java.util.Scanner;
import java.security.SecureRandom;
import java.util.Arrays;

public class TestSearchSort {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();
        Integer[] randomArr = null;  // Initialize array to be populated later
        Integer[] sortedArr = null;

        SortingAlgorithms<Integer> sortingAlgorithms = new SortingAlgorithms<>();
        Searching<Integer> searching = new Searching<>();

        // Implement the menu system
        while (true) {
            System.out.println("Select your option in the menu below:");
            System.out.println("1: Initialize and populate an array of 1000 random integers.");
            System.out.println("2: Perform recursive binary search.");
            System.out.println("3: Perform recursive linear search.");
            System.out.println("4: Sort the array");
            System.out.println("5: Quit");
            System.out.print(">");

            int choice = scanner.nextInt();
           // scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Generate and set the random array
                    randomArr = SortingAlgorithms.generateRandomInts(1000);
                    System.out.println("Array of randomly generated integers: " + Arrays.toString(randomArr));
                    break;

                case 2:
                	
                    System.out.print("Please enter an integer value to search:" + "\n>");
                    int target = scanner.nextInt();
                    scanner.nextLine();
                    // Sort the array before performing a binary search
                    sortedArr = Arrays.copyOf(randomArr, randomArr.length);
                    Arrays.sort(sortedArr);
                    long startBinary = System.nanoTime();
                    int binaryResult = searching.binarySearch(sortedArr, target);
                    long endBinary = System.nanoTime();
                    displaySearchResult("Recursive Binary Search", sortedArr, target, binaryResult, startBinary, endBinary);
                    break;

                    
                case 3:
                    System.out.print("Please enter an integer value to search:" + "\n>");
                    int linearTarget = scanner.nextInt();
                    scanner.nextLine();
                    long startLinear = System.nanoTime();
                    int linearResult = searching.linearSearch(randomArr, linearTarget);
                    long endLinear = System.nanoTime();
                    displaySearchResult("Recursive Linear Search", randomArr, linearTarget, linearResult, startLinear, endLinear);
                    break;
                    
                case 4:
                    displaySortingSubMenu(randomArr, sortingAlgorithms);
                    break;
                case 5:
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Invalid entry, please try again...");
                    break;
            }
        }
    }

    private static void displaySortingSubMenu(Integer[] randomArr, SortingAlgorithms<Integer> sortingAlgorithms) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSelect a sorting algorithm to sort the data array\n");
            System.out.println("\tB. Bubble Sort");
            System.out.println("\tI. Insertion Sort");
            System.out.println("\tS. Selection Sort");
            System.out.println("\tM. Merge Sort");
            System.out.println("\tQ. Quick Sort");
            System.out.println("\tR. Return to Main Menu");
            System.out.print(">");

            String sortChoice = scanner.nextLine().toUpperCase();

            switch (sortChoice) {
                case "B":
                	System.out.println(Arrays.toString(randomArr));
                    long startBubble = System.nanoTime();
                    sortingAlgorithms.bubbleSort(randomArr);
                    long endBubble = System.nanoTime();
                    displaySortedArray("Bubble Sort", randomArr, "O(n^2)", startBubble, endBubble);
                    break;
                case "I":
                	System.out.println(Arrays.toString(randomArr));
                    long startInsertion = System.nanoTime();
                    sortingAlgorithms.insertionSort(randomArr);
                    long endInsertion = System.nanoTime();
                    displaySortedArray("Insertion Sort", randomArr, "O(n^2)", startInsertion, endInsertion);
                    break;
                case "S":
                	System.out.println(Arrays.toString(randomArr));
                    long startSelection = System.nanoTime();
                    sortingAlgorithms.selectionSort(randomArr);
                    long endSelection = System.nanoTime();
                    displaySortedArray("Selection Sort", randomArr, "O(n^2)", startSelection, endSelection);
                    break;
                case "M":
                	System.out.println(Arrays.toString(randomArr));
                    long startMerge = System.nanoTime();
                    sortingAlgorithms.mergeSort(randomArr);
                    long endMerge = System.nanoTime();
                    displaySortedArray("Merge Sort", randomArr, "O(n log n)", startMerge, endMerge);
                    break;
                case "Q":
                	System.out.println(Arrays.toString(randomArr));
                    long startQuick = System.nanoTime();
                    sortingAlgorithms.quickSort(randomArr);
                    long endQuick = System.nanoTime();
                    displaySortedArray("Quick Sort", randomArr, "O(n log n)", startQuick, endQuick);
                    break;
                case "R":
                    System.out.println("Returning to main menu...");
                    return;
                default:
                    System.out.println("Invalid sorting choice, please try again...");
                    break;
            }
        }
    }

    private static void displaySortedArray(String algorithmName, Integer[] randomArr, String complexity, long start, long end) {
        System.out.println(algorithmName + ":");
        System.out.println(Arrays.toString(randomArr)+"\n");
        System.out.println(algorithmName + ": " + complexity + " Complexity\n");
       // System.out.println("Sorted: " + Arrays.toString(randomArr)+"\n");
        long nanoseconds = end - start;
        System.out.println("Time taken in nanoseconds: " + nanoseconds);
        System.out.println("Time taken in milliseconds: " + nanoseconds / 1_000_000);
    }
    
    private static void displaySearchResult(String searchType, Integer[] randomArr, int target, int result, long start, long end) {
        System.out.println( Arrays.toString(randomArr)+"\n");
        //System.out.println("Target value: " + target);
        if (result != -1) {
            System.out.println(target + " was found at index position " + result + " : " + searchType + ".\n");
        } else {
            System.out.println(target + " was not found in the array.");
        }
        long nanoseconds = end - start;
        System.out.println("Time taken in nanoseconds: " + nanoseconds);
        System.out.println("Time taken in milliseconds: " + nanoseconds / 1_000_000+"\n");
    }
}

