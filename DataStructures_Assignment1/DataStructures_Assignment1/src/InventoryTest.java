
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

public class InventoryTest {

	    private Inventory inventory;

	    @BeforeEach
	    public void setUp() {
	        inventory = new Inventory();
	    }

	    @Test
	    public void testAddItem() {
	        assertTrue(inventory.addItem(new Scanner("f\n11\nApple\n10\n1.0\n1.5\nOrchard\n")));
	        assertEquals(1, inventory.numItems);
	        
	        assertFalse(inventory.addItem(new Scanner("f\n11\nBanana\n10\n1.0\n1.5\nOrchard\n"))); // Duplicate
	    }
	    
	    @Test
	    public void testMaxInventoryLimit1() {
	        for (int i = 0; i < Inventory.MAX_ITEMS; i++) {
	            assertTrue(inventory.addItem(new Scanner("f\n" + (i + 10) + "\nFruit" + i + "\n10\n1.0\n1.5\nOrchard" + i + "\n")));
	        }
	        assertEquals(Inventory.MAX_ITEMS, inventory.numItems);

	        // Try adding one more item beyond the maximum limit
	        assertFalse(inventory.addItem(new Scanner("f\n999\nExcessFruit\n5\n1.0\n1.5\nExcessOrchard\n")));
	    }
	
	

    @Test
    public void testBuyItem_ValidQuantity_ItemQuantityUpdated() {
        assertTrue(inventory.addItem(new Scanner("f\n11\nApple\n10\n1.0\n1.5\nOrchard\n")));

        // Perform the buy operation
        assertTrue(inventory.updateQuantity(new Scanner("11\n5\n"), true));

        // Assert the result and check if item quantity is updated
        assertEquals(15, inventory.getItemQuantity(11));
    }

    @Test
    public void testBuyItem_InvalidQuantity_ErrorReturned() {
        assertTrue(inventory.addItem(new Scanner("f\n11\nApple\n10\n1.0\n1.5\nOrchard\n")));

        // Attempt to buy with an invalid (negative) quantity
        assertFalse(inventory.updateQuantity(new Scanner("11\n-5\n"), true));
    }

    @Test
    public void testSellItem_ValidQuantity_ItemQuantityUpdated() {
        assertTrue(inventory.addItem(new Scanner("f\n11\nApple\n10\n1.0\n1.5\nOrchard\n")));

        // Perform the sell operation
        assertTrue(inventory.updateQuantity(new Scanner("11\n5\n"), false));

        // Assert the result and check if item quantity is updated
        assertEquals(5, inventory.getItemQuantity(11));
    }

    @Test
    public void testSellItem_InvalidQuantity_ErrorReturned() {
        assertTrue(inventory.addItem(new Scanner("f\n11\nApple\n10\n1.0\n1.5\nOrchard\n")));

        // Attempt to sell with an invalid (negative) quantity
        assertFalse(inventory.updateQuantity(new Scanner("11\n-5\n"), false));
    }

    @Test
    public void testMaxInventoryLimit() {
        for (int i = 0; i < Inventory.MAX_ITEMS; i++) {
            assertTrue(inventory.addItem(new Scanner("f\n" + (i + 10) + "\nFruit" + i + "\n10\n1.0\n1.5\nOrchard" + i + "\n")));
        }
        assertEquals(Inventory.MAX_ITEMS, inventory.numItems);

        // Try adding one more item beyond the maximum limit
        assertFalse(inventory.addItem(new Scanner("f\n999\nExcessFruit\n5\n1.0\n1.5\nExcessOrchard\n")));
    }
}
