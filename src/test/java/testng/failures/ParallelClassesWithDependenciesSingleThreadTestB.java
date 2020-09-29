package testng.failures;

import org.testng.annotations.Test;

@Test(groups = "parallelClasses", singleThreaded = true)
public class ParallelClassesWithDependenciesSingleThreadTestB extends SameThreadTestWithClassParamsAndDependencies {

    ParallelClassesWithDependenciesSingleThreadTestB() {
        super("v2");
    }

}
