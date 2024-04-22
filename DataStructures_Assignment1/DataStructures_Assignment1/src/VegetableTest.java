
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VegetableTest {

	
	private Vegetable vegetable;

    @BeforeEach
    public void setUp() {
        vegetable = new Vegetable();
    }

    @Test
    public void testAddItem() {
        assertTrue(vegetable.addItem(new Scanner("22\nPotato\n10\n2.0\n2.5\nFarm\n")));
        assertEquals("Farm", vegetable.farmName);
    }
}