/*
 * Description: The main method of the image processing application
 * Student Name: _________________________ StudentID _______________
 * Due Date: June 24, 2023
 * Program: CET-CS CST8132 
 * Lab Professor: James Mwangi PhD.
 */
package lab4test.matrices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import lab4test.matrices.Convolution;
import lab4test.matrices.FileMatrix;
import lab4test.matrices.Matrix;
import lab4test.matrices.NamedMatrix;

/**
 * This class provides the driver of the image processing 
 * application
 */
public class Lab4Test {

	/**
	 * Fields
	 * Description: Kernels that can be used to do image 
	 * processing based on https://en.wikipedia.org/wiki/Kernel_(image_processing)
	 * 
	 * kernels Array of convolution kernels
	 */
	private NamedMatrix[] kernels = {
			new NamedMatrix("identity",new double[][]{
				{0, 0, 0},
				{0, 2, 0},
				{0, 0, 0}
			}),

			new NamedMatrix("ridge",new double[][] {
				{-1, -1, -1},
				{-1,  10, -1},
				{-1, -1, -1}			
			}),

			new NamedMatrix("sharpen",new double[][] {
				{ 0, -1,  0},
				{-1,  7, -1},
				{ 0, -1,  0}			
			}),

			new NamedMatrix("unsharpen masking 5x5",new double[][] {
				{-1.0/257, -1.0/65,  -3.0/128, -1.0/65,  -1.0/257},
				{-1.0/65, -16.0/257, -3.0/65, -16.0/257, -1.0/65},
				{-3.0/128, -3.0/65, 119.0/65,  -3.0/65,  -6.0/257},
				{-1.0/65, -16.0/257, -3.0/65, -16.0/257, -1.0/65},
				{-1.0/257, -1.0/65,  -3.0/128, -1.0/65,  -1.0/257}
			}),			

			new NamedMatrix("laplace",new double[][] { // ridge + identity
				{-1, -1, -1},
				{-1,  12, -1},
				{-1, -1, -1}			
			})
	};

	/**
	 * Description: Method that opens a dialog box to load an image file
	 * @return The selected File. If the dialog box is canceled, a 
	 * non existent File is returned
	 */
	public File getImageFile()
	{
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		File file;
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			System.out.println("You chose to open this file: "+file.getAbsolutePath());
		} else {
			file = new File("noneExistent");
			System.out.println("No file chosen");
		}
		return file;
	}

	/**
	 * Description: Method that returns the selected kernel. 
	 * This method handled all invalid kernel selections 
	 * @return A NamedMatrix of the kernel
	 */
	public NamedMatrix getKernel()
	{
		while (true) {
			System.out.println("Please select one of the following filters:");
			for (int i = 0; i < kernels.length; i++) {
				System.out.println((i + 1) + ". " + kernels[i].getName());
			}
			int filterSelection = getUserInputInteger("Select a filter: ");
			if (filterSelection >= 1 && filterSelection <= kernels.length) {
				return kernels[filterSelection - 1];
			} else {
				System.out.println("Invalid filter selection. Please try again.");
			}
		}
	}

	private int getUserInputInteger(String prompt) {
		Scanner scanner = new Scanner(System.in);
		int input;
		while (true) {
			try {
				System.out.print(prompt);
				input = scanner.nextInt();
				break;
			} catch (Exception e) {
				System.out.println("Invalid input. Please enter a valid integer.");
				scanner.nextLine(); // Consume the remaining newline character
			}
		}
		return input;
	}
	/**
	 * Description: Entry point for the application. Gets an 
	 * image file and selects kernel then applies filter to 
	 * the image and saves the file
	 * @param args Commandline parameters, not used
	 */
	public static void main(String[] args) {

		Lab4Test lab4 = new Lab4Test();

		// Choose image file
		File imageFile = lab4.getImageFile();
		if(!imageFile.exists())
			return;

		// Choose kernel
		NamedMatrix kernel = lab4.getKernel();

		try {
			// Create filtered image using original image and kernal
			Matrix originalImage = new FileMatrix(imageFile);
			Convolution convolve = new Convolution(kernel);
			FileMatrix filteredImage = new FileMatrix(convolve.filter(originalImage));

			// Save filtered image in a file named:
			//    "image file name" "-" "kernel name" "." "image file extension"
			String fileName = imageFile.getAbsolutePath();
			int dot = fileName.indexOf('.');
			String output = fileName.substring(0,dot)+"-"+kernel.getName()+fileName.substring(dot);
			File outputFile = new File(output);
			if(filteredImage.save(outputFile))
				System.out.println("File: "+output+" succesfully written");
			else
				System.out.println("Could not write file: "+output);

		} catch (FileNotFoundException e) {
			System.out.println("Could not find file: "+imageFile.getAbsolutePath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
