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
 * Represents a vegetable item, extends FoodItem, and adds farm supplier information.
 */
public class Vegetable extends FoodItem {
    protected String farmName;

    /**
     * Default constructor to initialize a Vegetable object with default values.
     */
    public Vegetable() {
        super();
        farmName = "";
    }

    /**
     * Returns a string representation of the Vegetable item, including farm supplier.
     *
     * @return A string representing the Vegetable item.
     */
    @Override
    public String toString() {
        return super.toString() + " farm supplier: " + farmName;
    }

    /**
     * Prompts the user to add vegetable item details and farm supplier, and adds the item to the inventory.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if the vegetable item is added successfully, false if input is invalid.
     */
    @Override
    public boolean addItem(Scanner scanner) {
        if (!super.addItem(scanner)) {
            return false;
        }
        System.out.print("Enter the name of the farm supplier: ");
        farmName = scanner.nextLine();  // Use nextLine() to capture the full name
        return true;
    }
}
