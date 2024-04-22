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
 * Represents a food item with item code, name, price, quantity, and cost.
 */
public class FoodItem {
    private int itemCode;
    private String itemName;
    private float itemPrice;
    private int itemQuantityInStock;
    private float itemCost;

    /**
     * Default constructor to initialize a FoodItem object with default values.
     */
    public FoodItem() {
        setItemCode(0);
        itemName = "";
        itemPrice = 0.0f;
        setItemQuantityInStock(0);
        itemCost = 0.0f;
    }

    /**
     * Returns a string representation of the FoodItem.
     *
     * @return A string representing the FoodItem.
     */
    public String toString() {
        return "Item: " + getItemCode() + " " + itemName + " " + getItemQuantityInStock() +
                " price: $" + itemPrice + " cost: $" + itemCost;
    }

    /**
     * Gets the item code.
     *
     * @return The item code.
     */
    public int getItemCode() {
        return itemCode;
    }

    /**
     * Sets the item code.
     *
     * @param itemCode The item code to set.
     */
    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    /**
     * Updates the item quantity in stock.
     *
     * @param amount The amount to add or subtract from the item quantity.
     * @return True if the update is successful, false if insufficient stock.
     */
    public boolean updateItem(int amount) {
        if (this.getItemQuantityInStock() + amount < 0) {
            System.out.println("Insufficient stock. Transaction halted.");
            return false;
        }
        this.setItemQuantityInStock(this.getItemQuantityInStock() + amount);
        return true;
    }

    /**
     * Gets the item quantity in stock.
     *
     * @return The item quantity in stock.
     */
    public int getItemQuantityInStock() {
        return itemQuantityInStock;
    }

    /**
     * Sets the item quantity in stock.
     *
     * @param itemQuantityInStock The item quantity in stock to set.
     */
    public void setItemQuantityInStock(int itemQuantityInStock) {
        this.itemQuantityInStock = itemQuantityInStock;
    }

    /**
     * Checks if this FoodItem is equal to another FoodItem based on their item codes.
     *
     * @param item The FoodItem to compare.
     * @return True if the item codes are equal, false otherwise.
     */
    public boolean isEqual(FoodItem item) {
        return this.getItemCode() == item.getItemCode();
    }

    /**
     * Prompts the user to input the item code.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if input is successful, false if input is invalid.
     */
    public boolean inputCode(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the code for the item: ");
                setItemCode(scanner.nextInt());
                scanner.nextLine();  // Consume the newline character
                return true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }
    }

    /**
     * Prompts the user to input item details and adds the item to the inventory.
     *
     * @param scanner The Scanner object to read input from.
     * @return True if item is added successfully, false if input is invalid.
     */
    public boolean addItem(Scanner scanner) {
        if (!inputCode(scanner))
            return false;

        System.out.print("Enter item name: ");
        itemName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter item quantity: ");
                int quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Invalid quantity. Please enter a non-negative integer.");
                } else {
                    setItemQuantityInStock(quantity);
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid integer.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        while (true) {
            try {
                System.out.print("Enter item cost: ");
                float cost = scanner.nextFloat();
                if (cost < 0) {
                    System.out.println("Invalid cost. Please enter a non-negative float.");
                } else {
                    itemCost = cost;
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid cost. Please enter a valid float.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        while (true) {
            try {
                System.out.print("Enter item sales price: ");
                float price = scanner.nextFloat();
                if (price < 0) {
                    System.out.println("Invalid sales price. Please enter a non-negative float.");
                } else {
                    itemPrice = price;
                    scanner.nextLine();  // Consume the newline character
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid sales price. Please enter a valid float.");
                scanner.nextLine();  // Clear the invalid input from the scanner
            }
        }

        return true;
    }
}
