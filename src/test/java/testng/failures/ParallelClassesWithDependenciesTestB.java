package testng.failures;

import org.testng.annotations.Test;

@Test(groups = "parallelClasses")
public class ParallelClassesWithDependenciesTestB extends SameThreadTestWithClassParamsAndDependencies {

    ParallelClassesWithDependenciesTestB() {
        super("v2");
    }

}
