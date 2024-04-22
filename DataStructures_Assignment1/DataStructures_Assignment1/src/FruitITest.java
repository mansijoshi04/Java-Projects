
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTest {
	
	private Fruit fruit;

    @BeforeEach
    public void setUp() {
        fruit = new Fruit();
    }

    @Test
    public void testAddItem() {
        assertTrue(fruit.addItem(new Scanner("111\nApple\n10\n1.0\n1.5\nOrchardY\n")));
        assertEquals("OrchardY", fruit.orchardName);
    }
}
