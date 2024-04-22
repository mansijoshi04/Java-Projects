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
 * Represents an inventory that can store food items.
 */
public class Inventory {
    private FoodItem[] inventory;
    protected int numItems;
    protected static final int MAX_ITEMS = 20;

    /**
     * Default constructor to initialize an Inventory object with an array of FoodItem and zero items.
     */
    public Inventory() {
        inventory = new FoodItem[MAX_ITEMS];
        numItems = 0;
    }

    /**
     * Returns a string representation of the inventory.
     *
     * @return A string representing the inventory.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Inventory:\n");
        for (int i = 0; i < numItems; i++) {
            result.append(inventory[i].toString()).append("\n");
        }
        return result.toString();
    }

    /**
     * Checks if a FoodItem already exists in the inventory based on item code.
     *
     * @param item The FoodItem to check.
     * @return The index of the existing item if found, or -1 if not found.
     */
    public int alreadyExists(FoodItem item) {
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].isEqual(item)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Prompts the user to add a new FoodItem to the inventory.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if the FoodItem is added successfully, false otherwise.
     */
    public boolean addItem(Scanner scanner) {
        if (numItems >= MAX_ITEMS) {
            System.out.println("Inventory is full. Cannot add more items.");
            return false;
        }
        char choice;

        while (true) {
            try {
                System.out.print("Do you wish to add a fruit(f), vegetable(v), or a preserve(p)? ");
                String input = scanner.nextLine().toLowerCase();

                if (input.length() == 1) {
                    choice = input.charAt(0);
                    if (choice == 'f' || choice == 'v' || choice == 'p') {
                        break;  // Valid choice, exit the loop
                    }
                }

                throw new InputMismatchException("Invalid entry. Please select f, v, or p.");
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            }
        }

        FoodItem newItem = null;

        switch (choice) {
            case 'f':
                newItem = new Fruit();
                break;
            case 'v':
                newItem = new Vegetable();
                break;
            case 'p':
                newItem = new Preserve();
                break;
            default:
                System.out.println("Invalid choice. Please select f, v, or p.");
                return false;
        }

        if (newItem != null && newItem.addItem(scanner)) {
            int existingIndex = alreadyExists(newItem);
            if (existingIndex != -1) {
                System.out.println("Item code already exists.");
                return false;
            }

            inventory[numItems++] = newItem;
            return true;
        }

        return false;
    }

    /**
     * Updates the quantity of a FoodItem in the inventory based on the specified action (buy or sell).
     *
     * @param scanner    The Scanner object to read input from.
     * @param buyOrSell  True for buying, false for selling.
     * @return True if the quantity is updated successfully, false otherwise.
     */
    public boolean updateQuantity(Scanner scanner, boolean buyOrSell) {
        if (numItems == 0) {
            System.out.println("Error...could not " + (buyOrSell ? "buy" : "sell") + " item. Inventory is empty.");
            
            return false;
        }
        System.out.print("Enter the code for the item: ");
        if (scanner.hasNextInt()) {
            int code = scanner.nextInt();
            int index = -1;

            for (int i = 0; i < numItems; i++) {
                if (inventory[i].getItemCode() == code) {  // Fixed the code comparison
                    index = i;
                    break;
                }
            }

            if (index == -1) {
                System.out.println("Code not found in inventory...");
                return false;
            }

            FoodItem item = inventory[index];
            System.out.print("Enter valid quantity to " + (buyOrSell ? "buy" : "sell") + ": ");
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                // Check for negative quantity
                if (quantity < 0) {
                    System.out.println("Invalid quantity. Please enter a positive integer.");
                    return false;
                }
                return buyOrSell ? item.updateItem(quantity) : item.updateItem(-quantity);
            } else {
                System.out.println("Invalid quantity...");
            }
        } else {
            System.out.println("Invalid code...");
        }

        return false;
    }
    public int getItemQuantity(int itemCode) {
        for (int i = 0; i < numItems; i++) {
            if (inventory[i].getItemCode() == itemCode) {
                return inventory[i].getItemQuantityInStock();
            }
        }
        return -1;  // Return -1 if item code is not found
    }
}
