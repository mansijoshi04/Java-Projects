
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoodItemTest {

	private FoodItem item;

    @BeforeEach
    public void setUp() {
        item = new FoodItem();
    }
    @Test
    public void testUpdateItem() {
        assertTrue(item.updateItem(10));
        assertEquals(10, item.getItemQuantityInStock());
        
        assertTrue(item.updateItem(-5));
        assertEquals(5, item.getItemQuantityInStock());
        
        assertFalse(item.updateItem(-10));
    }

    @Test
    public void testIsEqual() {
        FoodItem anotherItem = new FoodItem();
        assertTrue(item.isEqual(anotherItem));
        
        anotherItem.setItemCode(10);
        assertFalse(item.isEqual(anotherItem));
    }

}
