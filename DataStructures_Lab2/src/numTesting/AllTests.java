package numTesting;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddValuesTest.class, ReadValuesTest.class, SaveValuesTest.class })
public class AllTests {

}
