package numTesting;
import primary.*;
import static org.junit.Assert.*;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import org.junit.Test;

public class ReadValuesTest {
	@Test
	public void testReadFromFile() {
        Numbers numbers = new Numbers();
		// Create a temporary file with sample data
		try {
			File tempFile = File.createTempFile("testfile", ".txt");
			String testData = "2\n1.1\n2.2\n";
			Files.write(tempFile.toPath(), testData.getBytes());

			// Call readFromFile method
			numbers.readValues(tempFile.getAbsolutePath());

			// Check if values were correctly read from the file
			assertEquals(2, numbers.getNumItems(),2);
			assertEquals(1.1f, numbers.getNumbers()[0], 1.1);
			assertEquals(2.2f, numbers.getNumbers()[1], 2.2);

			// Clean up
			tempFile.delete();
		} catch (Exception e) {
			fail("Exception occurred: " + e.getMessage());
		}
	}
}