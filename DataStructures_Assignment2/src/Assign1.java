import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The main class for the inventory management program.
 */
public class Assign1 {

    /**
     * The main method to start the program and manage inventory.
     * @param args The command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        Inventory<String> inventory = new Inventory<>(); // Update with appropriate type for T
        Scanner scanner = new Scanner(System.in);

        displayMenu();
        while (true) {
            try {

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter an integer between 1 and 8.");
                    scanner.nextLine();
                    continue;
                }

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.println("Adding Item to Inventory...");
                        inventory.addItem(scanner, false);
                        break;
                    case 2:
                        //System.out.println("Displaying Current Inventory...");
                        inventory.displayInventory(false);
                        break;
                    case 3:
                      //  System.out.println("Buying Item(s)...");
                        if (!inventory.updateQuantity(scanner, true)) {
                           // System.out.println("Error... Could not buy item");
                        }
                        break;
                    case 4:
                       // System.out.println("Selling Item(s)...");
                        if (!inventory.updateQuantity(scanner, false)) {
                            //System.out.println("Error... Could not sell item");
                        }
                        break;
                    case 5:
                        System.out.print("Enter the code for the item: ");
                        int searchCode = scanner.nextInt();
                        scanner.nextLine();  // Consume the newline character

                        FoodItem foundItem = inventory.searchByCode(searchCode);

                        if (foundItem != null) {
                            System.out.println("Item found:");
                            System.out.println(foundItem);
                        } else {
                            System.out.println("Item with code " + searchCode + " not found in inventory.");
                        }
                        break;

                       
                    case 6:
                      //  System.out.println("Saving Inventory to File...");
                        System.out.print("Enter the filename to save to: ");
                        String saveFilename = scanner.nextLine();
                        inventory.saveToFile(saveFilename);
                        break;
                    case 7:
                       // System.out.println("Reading Inventory from File...");
                        System.out.print("Enter the filename to read from: ");
                        String readFilename = scanner.nextLine();
                        inventory.readFromFile(readFilename);
                        break;
                    case 8:
                        System.out.println("Exiting...");
                        scanner.close();
                        return; // Graceful exit
                    default:
                        System.out.println("Incorrect value entered. Please choose 1-8.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter an integer between 1 and 8.");
                scanner.nextLine(); // Clear the input buffer
            }
            displayMenu();
        }
    }

    /**
     * Displays the main menu to the console.
     */
    public static void displayMenu() {
        System.out.println("Please select one of the following:");
        System.out.println("1: Add Item to Inventory");
        System.out.println("2: Display Current Inventory");
        System.out.println("3: Buy Item(s)");
        System.out.println("4: Sell Item(s)");
        System.out.println("5: Search for Item");
        System.out.println("6: Save Inventory to File");
        System.out.println("7: Read Inventory from File");
        System.out.println("8: To Exit");
        System.out.print("> ");
    }
}
