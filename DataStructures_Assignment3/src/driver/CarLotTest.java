/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: This CarLotTest class demonstrates the usage of a CarLot, a class representing a car lot
 * and its inventory. It reads car information from a CSV file, populates the CarLot, and performs
 * searches based on license plates from a text file.
 */
package driver;

import carLot.Car;
import carLot.CarLot;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The main class to test the functionality of the CarLot class.
 */
public class CarLotTest {

    /**
     * The main method that serves as the entry point of the program.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        /* Dynamically obtain the current date */
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

        /* Create an instance of CarLot */
        CarLot carLot = new CarLot(currentDate);

        /* Read the contents of the .csv file and add cars to CarLot */
        try (BufferedReader csvReader = new BufferedReader(new FileReader("car_inventory.csv"))) {
            String line;
            while ((line = csvReader.readLine()) != null) {
                String[] data = line.split(",");
                int year = Integer.parseInt(data[0]);
                String make = data[1];
                String licensePlate = data[2];
                Car car = new Car(year, make, licensePlate);
                carLot.addCar(car);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Honest AC's Used Car Lot Inventory for " + carLot.getCurrentDate());

        /* Read license plates from the .txt file and print the report */
        try (BufferedReader txtReader = new BufferedReader(new FileReader("carSearch.txt"))) {
            String licensePlate;
            while ((licensePlate = txtReader.readLine()) != null) {
                Car car = carLot.getCarByLicensePlate(licensePlate);
                if (car != null) {
                    System.out.printf("%s %s %s%n", car.getLicensePlate(), car.getYear(), car.getMake());
                } else {
                    System.out.printf("%s\t\t\tNot found%n", licensePlate);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
