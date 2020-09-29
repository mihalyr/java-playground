package testng.failures;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

@Test(groups = "parallelInstances", singleThreaded = true)
public class ParallelInstancesWithDependenciesSingleThreadTest extends SameThreadTestWithClassParamsAndDependencies {

    @Factory(dataProvider = "prefixes")
    ParallelInstancesWithDependenciesSingleThreadTest(String prefix) {
        super(prefix);
    }

    @DataProvider
    static Object[][] prefixes() {
        return new Object[][]{
                new Object[]{"v1"},
                new Object[]{"v2"}
        };
    }

}
