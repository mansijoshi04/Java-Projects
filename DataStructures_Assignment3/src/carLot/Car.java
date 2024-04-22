/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: The Car class represents a car with information about its year, make, and license plate.
 */
package carLot;

public class Car {
    private int year;
    private String make;
    private String licensePlate;

    /**
     * Constructs a Car object with the specified year, make, and license plate.
     *
     * @param year         The year of the car.
     * @param make         The make (manufacturer) of the car.
     * @param licensePlate The license plate of the car.
     */
    public Car(int year, String make, String licensePlate) {
        this.year = year;
        this.make = make;
        this.licensePlate = licensePlate;
    }

    /**
     * Gets the year of the car.
     *
     * @return The year of the car.
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of the car.
     *
     * @param year The new year of the car.
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the make (manufacturer) of the car.
     *
     * @return The make of the car.
     */
    public String getMake() {
        return make;
    }

    /**
     * Sets the make (manufacturer) of the car.
     *
     * @param make The new make of the car.
     */
    public void setMake(String make) {
        this.make = make;
    }

    /**
     * Gets the license plate of the car.
     *
     * @return The license plate of the car.
     */
    public String getLicensePlate() {
        return licensePlate;
    }

    /**
     * Sets the license plate of the car.
     *
     * @param licensePlate The new license plate of the car.
     */
    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
