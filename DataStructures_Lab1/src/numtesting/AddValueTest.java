package numtesting;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;
import primary.Numbers;

public class AddValueTest {

	@Test
	public void testAddValue() {
	    // Create an instance of Numbers
	    Numbers numbers = new Numbers();
	    
	    // Add values to the array using addValue method
	    numbers.addValue(new Scanner("2.2\n"));
	    numbers.addValue(new Scanner("1.1\n"));
	    
	    assertEquals(1.1f, numbers.findMinMax()[0], 0.01); // Minimum value
	    assertEquals(2.2f, numbers.findMinMax()[1], 0.01); // Maximum value
	}

}
