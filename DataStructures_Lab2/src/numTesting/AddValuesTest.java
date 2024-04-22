package numTesting;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

import primary.*;

public class AddValuesTest {

	@Test
    public void testAddValues() {
        Numbers numbers = new Numbers();
        Scanner scanner = new Scanner("2\n1.1\n2.2\n");

        numbers.addValues(scanner, true);

	    assertEquals(2, numbers.getNumItems(),2); // Minimum value
	    assertEquals(1.1f, numbers.getNumbers()[0], 0.01);	    
	    assertEquals(2.2f, numbers.getNumbers()[1], 0.01);
    }
}
