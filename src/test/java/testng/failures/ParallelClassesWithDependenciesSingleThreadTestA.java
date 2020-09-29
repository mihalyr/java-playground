package testng.failures;

import org.testng.annotations.Test;

@Test(groups = "parallelClasses", singleThreaded = true)
public class ParallelClassesWithDependenciesSingleThreadTestA extends SameThreadTestWithClassParamsAndDependencies {

    ParallelClassesWithDependenciesSingleThreadTestA() {
        super("v1");
    }

}
