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
import java.util.Scanner;

/**
 * Represents a fruit item, extends FoodItem, and adds orchard supplier information.
 */
public class Fruit extends FoodItem {

    /**
     * The name of the orchard supplier for the fruit.
     */
    protected String orchardName;

    /**
     * Default constructor to initialize a Fruit object with default values.
     */
    public Fruit() {
        super();
        orchardName = "";
    }

    /**
     * Returns a string representation of the Fruit item, including orchard supplier.
     *
     * @return A string representing the Fruit item.
     */
    @Override
    public String toString() {
        return super.toString() + " orchard supplier: " + orchardName;
    }

    /**
     * Prompts the user to input fruit item details and orchard supplier, and adds the item to the inventory.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if the fruit item is added successfully, false if input is invalid.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the name of the orchard supplier: ");
        orchardName = scanner.nextLine();  // Use nextLine() to capture the full name
        return true;
    }
}
