package numTesting;

import static org.junit.Assert.*;

import java.io.*;
import java.util.Scanner;

import primary.*;
import org.junit.Test;

public class SaveValuesTest {
	
	Numbers numbers = new Numbers();

	@Test
	public void testSaveToFile() {
		// Create a temporary file for testing
		try {
			File tempFile = File.createTempFile("testing", ".txt");

			// Create a mock input for adding values to the array
			String mockInput = "2\n1.1\n2.2\n";
			InputStream inputStream = new ByteArrayInputStream(mockInput.getBytes());
			Scanner inputScanner = new Scanner(inputStream);

			// Add values to the array
			numbers.addValues(inputScanner, false);
			numbers.saveValues(tempFile.getAbsolutePath());

			// Check if the file was created and contains the correct data
			Scanner fileScanner = new Scanner(tempFile);
			assertEquals(2, fileScanner.nextInt(), 2);
			assertEquals(1.1f, fileScanner.nextFloat(), 1.1f);
			assertEquals(2.2f, fileScanner.nextFloat(), 2.2f);
			fileScanner.close();

			//delets the temporary file
			tempFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}