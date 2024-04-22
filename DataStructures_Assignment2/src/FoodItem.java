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
import java.util.Formatter;
import java.util.InputMismatchException;
import java.io.*;

/**
 * A generic class to represent a food item.
 *
 * @param <T> The type of the food item.
 */
public abstract class FoodItem<T> implements Comparable<FoodItem<T>>{
    private int itemCode;
    protected T itemName;
    protected float itemPrice;
    private int itemQuantityInStock;
    protected float itemCost;

    public FoodItem() {
        setItemCode(0);
        itemName = null;
        setItemPrice(0.0f);
        setItemQuantityInStock(0);
        itemCost = 0.0f;
    }

    public FoodItem(int itemCode, T itemName, float itemPrice, int itemQuantityInStock, float itemCost) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.setItemPrice(itemPrice);
        this.itemQuantityInStock = itemQuantityInStock;
        this.itemCost = itemCost;
    }

    /**
     * Returns a string representation of the FoodItem.
     *
     * @return A string representing the FoodItem.
     */
    public String toString() {
        return "Item: " + getItemCode() + " " + itemName + " " + getItemQuantityInStock() +
                " price: $" + getItemPrice() + " cost: $" + getItemCost();
    }
    
    @Override
    public int compareTo(FoodItem<T> other) {
        return Integer.compare(this.getItemCode(), other.getItemCode());
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
     * @param fromFile 
     * @return True if input is successful, false if input is invalid.
     */
    public boolean inputCode(Scanner scanner, boolean fromFile) {
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
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (!inputCode(scanner, fromFile))
            return false;

        if (!fromFile) {
            //scanner.nextLine();  // Consume newline
            System.out.print("Enter item name: ");
            itemName = (T) scanner.nextLine();
        }

        while (true) {
            try {
                System.out.print("Enter item quantity: ");
                int quantity = scanner.nextInt();
                if (quantity < 0) {
                    System.out.println("Invalid quantity. Please enter a non-negative integer.");
                } else {
                    setItemQuantityInStock(quantity);
                    scanner.nextLine();  // Consume newline
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid quantity. Please enter a valid integer.");
                scanner.nextLine();  // Clear invalid input
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
                    scanner.nextLine();  // Consume newline
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid cost. Please enter a valid float.");
                scanner.nextLine();  // Clear invalid input
            }
        }

        while (true) {
            try {
                System.out.print("Enter item sales price: ");
                float price = scanner.nextFloat();
                if (price < 0) {
                    System.out.println("Invalid sales price. Please enter a non-negative float.");
                } else {
                    setItemPrice(price);
                    scanner.nextLine();  // Consume newline
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid sales price. Please enter a valid float.");
                scanner.nextLine();  // Clear invalid input
            }
        }

        // ... (rest of the logic for other properties)

        return true;
    }
    

//    public int getItemCode() {
//        return itemCode;
//    }


    /**
     * Outputs the item details to a formatter.
     *
     * @param writer The formatter to write to.
     */
    public void outputItem(Formatter writer) {
//        writer.format("%d%n", itemCode);  // Output item code

        // Output additional item details specific to the item type
        if (this instanceof Fruit) {
            writer.format("f%n");
            writer.format("%d%n", itemCode);
           // writer.format("%s%n", ((Fruit<T>) this).getOrchardName());
        } else if (this instanceof Vegetable) {
            writer.format("v%n");
            writer.format("%d%n", itemCode);
           // writer.format("%s%n", ((Vegetable<T>) this).getFarmName());
        } else if (this instanceof Preserve) {
            writer.format("p%n");
            writer.format("%d%n", itemCode);
            //writer.format("%d%n", ((Preserve<T>) this).getJarSize());
        }

        // Output common item details
        writer.format("%s%n", itemName);
        writer.format("%d%n", itemQuantityInStock);
        writer.format("%.2f%n", getItemCost());
        writer.format("%.2f%n", getItemPrice());
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
    
	public float getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}

	public float getItemCost() {
		return itemCost;
	}

	public void setItemCost(float cost) {
		this.itemCost = cost;
		
	}
	
	public void setItemName(String itemName) {
	    this.itemName = (T) itemName;
	}

}

