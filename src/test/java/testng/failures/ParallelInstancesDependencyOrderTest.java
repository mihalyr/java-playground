package testng.failures;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.concurrent.atomic.AtomicInteger;

import static org.testng.Assert.assertEquals;

@Test(groups = "parallelInstances")
public class ParallelInstancesDependencyOrderTest {
    private final String prefix;
    private final int delay;
    private final AtomicInteger counter = new AtomicInteger();

    @Factory(dataProvider = "dp")
    ParallelInstancesDependencyOrderTest(String prefix, int delay) {
        this.prefix = prefix;
        this.delay = delay;
    }

    @DataProvider
    static Object[][] dp() {
        int repeat = 5;
        int instances = 3;
        Object[][] params = new Object[repeat * instances][2];
        for (int j=0; j < repeat; j++ ) {
            int delay = 1;
            for (int i = 0; i < instances; i++) {
                int index = (j*instances) + i;
                int order = index + 1;
                params[index][0] = "v" + order;
                params[index][1] = delay * 1000;
                delay <<= 1;
            }
        }
        return params;
    }

    @BeforeClass
    void setup() {
        work(delay);
    }

    @Test
    void testA() {
        assertEquals(1, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testA")
    void testB() {
        assertEquals(2, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testB")
    void testC() {
        assertEquals(3, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testC")
    void testD() {
        assertEquals(4, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testD")
    void testE() {
        assertEquals(5, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testE")
    void testF() {
        assertEquals(6, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testF")
    void testG() {
        assertEquals(7, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testG")
    void testH() {
        assertEquals(8, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testH")
    void testI() {
        assertEquals(9, counter.incrementAndGet());
    }

    @Test(dependsOnMethods = "testI")
    void testJ() {
        assertEquals(10, counter.incrementAndGet());
    }

    private static void work(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

