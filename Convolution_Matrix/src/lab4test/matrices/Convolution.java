/*
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package lab4test.matrices;

public class Convolution {
    private Matrix kernel;

    public Convolution(Matrix kernel) {
        this.kernel = kernel;
    }

    public Matrix filter(Matrix image) {
    	// calculating dimensions of the output matrix
        int rows = image.getRows() - kernel.getRows() + 1;
        int columns = image.getColumns() - kernel.getColumns() + 1;
        
        double[][] outputImage = new double[rows][columns];

        //for loop for processing the image
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Matrix subMatrix = null;
                try {
                	//reads subMatrix from the image
                    subMatrix = image.subMatrix(r, c, kernel.getRows(), kernel.getColumns());
                    
                    // multiplies the subMatrix with the kernel
                    Matrix multiplicationResult = subMatrix.mult(kernel);
                    
                    // calculates the sum of resultant matrix
                    outputImage[r][c] = multiplicationResult.sum();
                    
                   // handles the Illegal Argument Exception
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    }
                }
            }
        return new Matrix(outputImage);
    }
 }