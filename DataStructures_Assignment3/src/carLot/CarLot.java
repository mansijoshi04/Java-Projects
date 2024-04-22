/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *
 * Description: The CarLot class represents a car lot with an inventory of cars.
 * It maintains information about the current date and allows operations such as
 * adding cars to the inventory, retrieving cars based on license plates,
 * and updating the current date. The class utilizes a HashMap to store cars
 * with their license plates as keys for efficient retrieval. This implementation
 * is intended for managing and manipulating a collection of cars in a car lot setting.
 */
package carLot;

import java.util.HashMap;
import java.util.Map;

/**
 * The CarLot class represents a car lot with an inventory of cars.
 */
public class CarLot {
    private Map<String, Car> inventory;
    private String currentDate;

    /**
     * Constructs a CarLot object with the specified current date.
     *
     * @param currentDate The current date of the car lot.
     */
    public CarLot(String currentDate) {
        this.currentDate = currentDate;
        this.inventory = new HashMap<>();
    }

    /**
     * Adds a car to the inventory.
     *
     * @param car The car to be added to the inventory.
     */
    public void addCar(Car car) {
        inventory.put(car.getLicensePlate(), car);
    }

    /**
     * Retrieves a car from the inventory based on the license plate.
     *
     * @param licensePlate The license plate of the car to be retrieved.
     * @return The car with the specified license plate, or null if not found.
     */
    public Car getCarByLicensePlate(String licensePlate) {
        return inventory.get(licensePlate);
    }

    /**
     * Gets the current date of the car lot.
     *
     * @return The current date of the car lot.
     */
    public String getCurrentDate() {
        return currentDate;
    }

    /**
     * Sets the current date of the car lot.
     *
     * @param currentDate The new current date of the car lot.
     */
    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * Gets the inventory of the car lot.
     *
     * @return The inventory of the car lot.
     */
    public Map<String, Car> getInventory() {
        return inventory;
    }

    /**
     * Sets the inventory of the car lot.
     *
     * @param inventory The new inventory of the car lot.
     */
    public void setInventory(Map<String, Car> inventory) {
        this.inventory = inventory;
    }
}
