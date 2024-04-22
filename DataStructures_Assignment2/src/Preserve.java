import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Formatter;


/**
 * Represents a preserve item, extends FoodItem, and adds jar size information.
 */
public class Preserve<T> extends FoodItem<T> {
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
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (!super.addItem(scanner, fromFile)) {
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

    /**
     * Outputs the item information to a formatter (file).
     *
     * @param writer The formatter.
     */
    @Override
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("%d%n", jarSize);
    }
    public int getJarSize() {
        return jarSize;
    }

    // Setter for jar size
    public void setJarSize(int jarSize) {
        this.jarSize = jarSize;
    }
}

//	public void setItemName(String itemName) {
//	    this.itemName = (T) itemName;
//	}
//
//	public void setItemCost(float itemCost) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	public void setJarSize(int jarSize2) {
//		// TODO Auto-generated method stub
//		
//	}


