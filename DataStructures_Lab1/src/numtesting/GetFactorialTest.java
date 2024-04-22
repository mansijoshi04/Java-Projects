package numtesting;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;
import primary.Numbers;

public class GetFactorialTest {

	   @Test
	    public void testGetFactorialMax() {
	        // Create an instance of Numbers
	        Numbers numbers = new Numbers();
	        
	        // Add values to the array
	        numbers.addValue(new Scanner("2.2\n"));
	        numbers.addValue(new Scanner("1.1\n"));
	        
	        // Use assertions to check the factorial of the maximum value
	        assertEquals(2, numbers.getFactorialMax(), 0.01);
	 }
}
