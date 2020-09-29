package testng.failures;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

@Test(groups = "parallelInstances")
public class ParallelInstancesWithDependenciesTest extends SameThreadTestWithClassParamsAndDependencies {

    @Factory(dataProvider = "prefixes")
    ParallelInstancesWithDependenciesTest(String prefix) {
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
