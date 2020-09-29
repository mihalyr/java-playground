package testng.failures;

import org.testng.annotations.Test;

@Test(groups = "parallelClasses")
public class ParallelClassesWithDependenciesTestA extends SameThreadTestWithClassParamsAndDependencies {

    ParallelClassesWithDependenciesTestA() {
        super("v1");
    }

}
