import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ FoodItemTest.class, FruitTest.class, InventoryTest.class, PreserveTest.class, VegetableTest.class })
public class AllTests {

}
