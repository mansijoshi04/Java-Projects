import java.util.*;
import java.io.*;



/**
 * Represents an inventory of food items.
 */
public class Inventory<T> {
    private ArrayList<FoodItem<T>> items;
    private List<FoodItem<T>> inventoryList;

    /**
     * Default constructor to initialize an Inventory object with an empty ArrayList.
     */
    public Inventory() {
        items = new ArrayList<>();
    }

    public FoodItem searchByCode(int itemCode) {
        try {
            for (FoodItem item : items) {
                if (item.getItemCode() == itemCode) {
                    return item;
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred while searching by item code: " + e.getMessage());
        }
        return null;  // Item not found or an error occurred
    }

    /**
     * Adds a food item to the inventory.
     *
     * @param scanner   The Scanner object to read input from.
     * @param fromFile  Specifies if the input is from a file.
     */
    public void addItem(Scanner scanner, boolean fromFile) {
        FoodItem<T> item;
        char choice;

        while (true) {
            System.out.print("Do you wish to add a fruit(f), vegetable(v) or a preserve(p)? ");
            choice = scanner.next().charAt(0);
            scanner.nextLine();  // Consume newline

            switch (Character.toLowerCase(choice)) {
                case 'f':
                    item = new Fruit<>();
                    break;
                case 'v':
                    item = new Vegetable<>();
                    break;
                case 'p':
                    item = new Preserve<>();
                    break;
                default:
                    System.out.println("Invalid choice. Please choose from f, v, or p.");
                    return;
            }

            if (item.addItem(scanner, fromFile)) {
                if (isCodeUnique(item.getItemCode())) {
                    items.add(item);
                    System.out.println("Item added to inventory.");
                } else {
                    System.out.println("Item code already exists. Please enter a unique item code.");
                }
                return;
            } else {
                System.out.println("Invalid input. Item not added to inventory.");
                return;
            }
        }
    }

    /**
     * Displays the current inventory.
     */
    /**
     * Displays the current inventory, sorted by item names.
     */
    public void displayInventory(boolean isReadFromFile) {
        Set<Integer> displayedItemCodes = new HashSet<>(); // Set to store displayed item codes

        if (isReadFromFile) {
            System.out.println("Inventory read from file:");
            for (FoodItem item : items) {
                int itemCode = item.getItemCode();
                if (!displayedItemCodes.contains(itemCode)) {
                    System.out.println(item); // Print the details of the item
                    displayedItemCodes.add(itemCode);
                }
            }
        } else {
            System.out.println("Current Inventory:");
            for (FoodItem item : items) {
                int itemCode = item.getItemCode();
                if (!displayedItemCodes.contains(itemCode)) {
                    System.out.println(item); // Print the details of the item
                    displayedItemCodes.add(itemCode);
                }
            }
        }
    }



    /**
     * Updates the quantity of an item in the inventory (buy or sell).
     *
     * @param scanner   The Scanner object to read input from.
     * @param isBuying  Specifies if the operation is buying (true) or selling (false).
     * @return True if the update is successful, false otherwise.
     */
    public boolean updateQuantity(Scanner scanner, boolean isBuying) {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty. Cannot perform update.");
            return false;
        }

        System.out.print("Enter the code for the item: ");
        int code = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (FoodItem<T> item : items) {
            if (item.getItemCode() == code) {
                int quantity;
                while (true) {
                    try {
                        System.out.print("Enter the quantity to " + (isBuying ? "buy: " : "sell: "));
                        quantity = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        if (isBuying || (item.getItemQuantityInStock() >= quantity)) {
                            int newQuantity = isBuying ? item.getItemQuantityInStock() + quantity :
                                    item.getItemQuantityInStock() - quantity;
                            item.setItemQuantityInStock(newQuantity);
                            System.out.println("Quantity updated successfully.");
                            return true;
                        } else {
                            System.out.println("Insufficient quantity to sell.");
                            return false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer for quantity.");
                        scanner.nextLine();  // Clear the invalid input
                    }
                }
            }
        }
        System.out.println("Item code not found in inventory.");
        return false;
    }

    /**
     * Checks if an item code is unique in the inventory.
     *
     * @param code The item code to check.
     * @return True if the code is unique, false otherwise.
     */
    private boolean isCodeUnique(int code) {
        for (FoodItem<T> item : items) {
            if (item.getItemCode() == code) {
                return false;
            }
        }
        return true;
    }

    /**
     * Saves the inventory to a file.
     *
     * @param filename The name of the file to save to.
     */
    public void saveToFile(String filename) {
        try (Formatter formatter = new Formatter(new FileWriter(new File(filename)))) {
            // Sort the items by item code
            Collections.sort(items, (item1, item2) -> Integer.compare(item1.getItemCode(), item2.getItemCode()));

            for (FoodItem item : items) {
                formatter.format("", item.getClass().getSimpleName().charAt(0));
                item.outputItem(formatter);
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads the inventory from a file.
     *
     * @param filename The name of the file to read from.
     */

    public void readFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String type = scanner.nextLine().trim();
                int itemCode = Integer.parseInt(scanner.nextLine().trim());
                String itemName = scanner.nextLine().trim();
                int itemQuantityInStock = Integer.parseInt(scanner.nextLine().trim());
                float itemCost = Float.parseFloat(scanner.nextLine().trim());
                float itemPrice = Float.parseFloat(scanner.nextLine().trim());

                switch (type) {
                    case "f":
                        String orchardName = scanner.nextLine().trim();
                        Fruit fruit = new Fruit();
                        fruit.setItemCode(itemCode);
                        fruit.setItemName(itemName);
                        fruit.setItemQuantityInStock(itemQuantityInStock);
                        fruit.setItemCost(itemCost);
                        fruit.setItemPrice(itemPrice);
                        fruit.setOrchardName(orchardName);  // Set orchard name
                        items.add(fruit);
                        break;

                    case "v":
                        String farmName = scanner.nextLine().trim();
                        Vegetable vegetable = new Vegetable();
                        vegetable.setItemCode(itemCode);
                        vegetable.setItemName(itemName);
                        vegetable.setItemQuantityInStock(itemQuantityInStock);
                        vegetable.setItemCost(itemCost);
                        vegetable.setItemPrice(itemPrice);
                        vegetable.setFarmName(farmName);  // Set farm name
                        items.add(vegetable);
                        break;

                    case "p":
                        int jarSize = Integer.parseInt(scanner.nextLine().trim());
                        Preserve preserve = new Preserve();
                        preserve.setItemCode(itemCode);
                        preserve.setItemName(itemName);
                        preserve.setItemQuantityInStock(itemQuantityInStock);
                        preserve.setItemCost(itemCost);
                        preserve.setItemPrice(itemPrice);
                        preserve.setJarSize(jarSize);  // Set jar size
                        items.add(preserve);
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    
}
