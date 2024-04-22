
import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PreserveTest {

    private Preserve preserve;

    @BeforeEach
    public void setUp() {
        preserve = new Preserve();
    }

    @Test
    public void testAddItem() {
        assertTrue(preserve.addItem(new Scanner("33\nJam\n15\n3.5\n4.0\n500\n")));
        assertEquals(500, preserve.jarSize);
    }
}