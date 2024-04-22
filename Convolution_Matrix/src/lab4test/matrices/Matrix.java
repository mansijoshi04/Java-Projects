/*
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Course: CST8132 Object Oriented Programming
 * Program: CET-CS-Level 2
 * Professor: Daniel Cormier
  */
package lab4test.matrices;
import java.io.File;
import java.util.Arrays;
public class Matrix {

	// initialization and declaring variables
		private double[][] array;
		private int rows;
		private int columns;

		public Matrix(int rows, int columns) {
			this.rows = rows;
			this.columns = columns;
			this.array = new double[rows][columns];
		}
		
		public Matrix(double[][] array) {
			this.rows = array.length;
			this.columns = array[0].length;
			this.array = array;
		
		}

	    
	    public boolean save(File output) {
	        return false;
	    }

	    public int getRows() {
	        return array.length;
	    }

	    public int getColumns() {
	        return array[0].length;
	    }

	    public double[][] getData() {
	        return array;
	    }

		
		// compares if two matrices have same dimensions and if not it throws the exception
		public Matrix add(Matrix add) {
			if (rows != add.rows || columns != add.columns) {
				throw new IllegalArgumentException("Matrices must have the same dimensions");
			}
			// add two matrices
			Matrix result = new Matrix(rows, columns);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					result.array[i][j] = array[i][j] + add.array[i][j];
				}
			}

			return result;
	}
		
		// compares if two matrices have same dimensions and if not it throws the exception
		public Matrix sub(Matrix sub) {
			if (rows != sub.rows || columns != sub.columns) {
				throw new IllegalArgumentException("Matrices must have the same dimensions");
			}
			// subtracts two matrices
			Matrix result = new Matrix(rows, columns);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					result.array[i][j] = array[i][j] - sub.array[i][j];
				}
			}

			return result;
	}
		
		// compares if two matrices have same dimensions and if not it throws the exception
		public Matrix mult(Matrix mult) {
			if (rows != mult.rows || columns != mult.columns) {
				throw new IllegalArgumentException("Matrices must have the same dimensions");
			}
			// multiplies two matrices
			Matrix result = new Matrix(rows, columns);
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					result.array[i][j] = array[i][j] * mult.array[i][j];
				}
			}

			return result;
	}
		
		//calculates the sum of two multiplied matrices
		public double sum() {
			double sum = 0.0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < columns; j++) {
					sum += array[i][j];
				}
			}
			return sum;
	}
		
		public Matrix subMatrix(int startRow, int startColumn, int length, int width) {
			//checks for possible errors and throws the exception
			if (startRow < 0 || startRow >= rows || startColumn < 0 || startColumn >= columns) {
				throw new IllegalArgumentException("Invalid start row or column");
			}

			if (startRow + length > rows || startColumn + width > columns) {
				throw new IllegalArgumentException("Submatrix dimensions exceed matrix dimensions");
			}
			//creates subMatrix 
			Matrix result = new Matrix(length, width);
			for (int i = 0; i < length; i++) {
				for (int j = 0; j < width; j++) {
					result.array[i][j] = array[startRow + i][startColumn + j];
				}
			}
			return result;
	}

		//returns result to the toString method
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (double[] row : array) {
				result.append(Arrays.toString(row));
				result.append('\n');
			}
			return result.toString();
	}

}
