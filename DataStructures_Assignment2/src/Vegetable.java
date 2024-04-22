import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Formatter;


/**
 * Represents a vegetable item, extends FoodItem, and adds farm supplier information.
 */
public class Vegetable<T> extends FoodItem<T> {
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
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (!super.addItem(scanner, fromFile)) {
            return false;
        }
        System.out.print("Enter the name of the farm supplier: ");
        farmName = scanner.nextLine();  // Use nextLine() to capture the full name
        return true;
    }

    /**
     * Outputs the item information to a formatter (file).
     *
     * @param writer The formatter.
     */
    @Override
    public void outputItem(Formatter writer) {
        super.outputItem(writer);
        writer.format("%s%n", farmName);
    }

    public String getFarmName() {
        return farmName;
    }

    // Setter for jar size
    public void setFarmName(String farmName) {
        this.farmName = farmName;
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
//	public void setFarmName(String farmName2) {
//		// TODO Auto-generated method stub
//		
//	}





