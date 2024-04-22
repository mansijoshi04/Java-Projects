/*
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package lab4test.matrices;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMatrix extends Matrix {//inherits class Matrix
    private File file;

    private FileMatrix(Scanner input) {
        super(readMatrixData(input));
    }

    public FileMatrix(File file) throws IOException {
        super(readMatrixDataFromFile(file));
        this.file = file;
    }

    public FileMatrix(Matrix matrix) {
        super(matrix.getData());
    }

    @Override
    public boolean save(File file) {
        try (FileWriter writer = new FileWriter(file)) {
        	
        	//writes matrix dimensions to the file
            writer.write(getRows() + " " + getColumns() + System.lineSeparator());
            double[][] data = getData();
            for (double[] row : data) {
            	//writes the value of each component in a row separated by space
                for (double value : row) {
                    writer.write(value + " ");
                }
                writer.write(System.lineSeparator());
            }
            return true;
        } 
        catch (IOException e) { //handles IO exception
            e.printStackTrace();
            return false;
        }
    }
    
    //reads file matrix data
    private static double[][] readMatrixData(Scanner input) {
        int rows = input.nextInt();
        int columns = input.nextInt();
        double[][] matrixData = new double[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrixData[i][j] = input.nextDouble();
            }
        }
        return matrixData;
    }
    // reads the data and each value from the file scanner
    private static double[][] readMatrixDataFromFile(File file) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            int rows = scanner.nextInt();
            int columns = scanner.nextInt();
            double[][] matrixData = new double[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    matrixData[i][j] = scanner.nextDouble();
                }
            }
            return matrixData;
        }
     } 
 }