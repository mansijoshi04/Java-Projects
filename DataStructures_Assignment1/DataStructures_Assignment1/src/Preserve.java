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
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a preserve item, extends FoodItem, and adds jar size information.
 */
public class Preserve extends FoodItem {
    protected int jarSize;

    /**
     * Default constructor to initialize a Preserve object with default values.
     */
    public Preserve() {
        super();
        jarSize = 0;
    }

    /**
     * Returns a string representation of the Preserve item, including jar size.
     *
     * @return A string representing the Preserve item.
     */
    @Override
    public String toString() {
        return super.toString() + " size: " + jarSize + "mL";
    }

    /**
     * Prompts the user to add preserve item details and jar size, and adds the item to the inventory.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if the preserve item is added successfully, false if input is invalid.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }

        while (true) {
            System.out.print("Enter the size of the jar in milliliters: ");

            try {
                if (scanner.hasNextInt()) {
                    int size = scanner.nextInt();
                    if (size >= 0) {
                        jarSize = size;
                        return true;
                    } else {
                        System.out.println("Invalid input. Please enter a non-negative integer for jar size.");
                        scanner.nextLine();  // Clear the invalid input
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer for jar size.");
                    scanner.nextLine();  // Clear the invalid input
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for jar size.");
                scanner.nextLine();  // Clear the invalid input
            }
        }
    }
}
