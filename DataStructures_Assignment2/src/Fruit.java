import java.util.Formatter;
import java.util.Scanner;

/**
 * Represents a fruit item, extends FoodItem, and adds orchard supplier information.
 */
public class Fruit<T> extends FoodItem<T> {

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
    public boolean addItem(Scanner scanner, boolean fromFile) {
        if (!super.addItem(scanner, fromFile)) {
            return false;
        }
        System.out.print("Enter the name of the orchard supplier: ");
        orchardName = scanner.nextLine();  // Use nextLine() to capture the full name
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
        writer.format("%s%n", orchardName);
    }

    public String getOrchardName() {
        return orchardName;
    }

    // Setter for jar size
    public void setOrchardName(String orchardName) {
        this.orchardName = orchardName;
    }
}
//	public void setItemName(String itemName) {
//	    this.itemName = (T) itemName;
//	}
//	
//    /**
//     * Sets the item quantity in stock for the fruit.
//     *
//     * @param quantity The quantity to set.
//     */
//    public void getItemQuantityInStock(int quantity) {
//        super.setItemQuantityInStock(quantity);
//    }
//
//    /**
//     * Sets the item price for the fruit.
//     *
//     * @param price The price to set.
//     * @return 
//     */
//    public float getItemPrice(float price) {
//        return price;
//    }
//
//    /**
//     * Sets the item cost for the fruit.
//     *
//     * @param cost The cost to set.
//     * @return 
//     */
//    public float setItemCost(float cost) {
//        return cost;
//    }


// Similarly update Vegetable and Preserve classes using generic programming and outputItem method
