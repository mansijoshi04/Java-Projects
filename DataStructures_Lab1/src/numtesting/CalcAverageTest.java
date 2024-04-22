/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * This class contains the dynamically allocated array and its processing
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 */

package numtesting;

import static org.junit.Assert.*;
import java.util.Scanner;
import org.junit.Test;
import primary.*;

public class CalcAverageTest {

    @Test
    public void testCalcAverage() {
        // Create an instance of Numbers
        Numbers numbers = new Numbers();
        
        // Add values to the array
        numbers.addValue(new Scanner("2.2\n"));
        numbers.addValue(new Scanner("1.1\n"));
        
        // Use assertions to check the calculated average
        assertEquals(1.65f, numbers.calcAverage(), 0.01);
    }
}
