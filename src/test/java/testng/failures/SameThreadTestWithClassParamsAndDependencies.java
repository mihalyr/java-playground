package testng.failures;

import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

import static org.testng.Assert.assertEquals;

public abstract class SameThreadTestWithClassParamsAndDependencies {

    private final String prefix;
    private final AtomicInteger counter = new AtomicInteger();
    private final AtomicReference<Thread> threadHolder = new AtomicReference<>();

    SameThreadTestWithClassParamsAndDependencies(String prefix) {
        this.prefix = prefix;
    }

    @Test
    void testA(Method method) {
        log(method.getName());
        checkSameThread();
        work();
    }

    @Test(dependsOnMethods = "testA")
    void testB(Method method) {
        log(method.getName());
        checkSameThread();
        work();
    }

    @Test(dependsOnMethods = "testB")
    void testC(Method method) {
        log(method.getName());
        checkSameThread();
        work();
    }

    private void checkSameThread() {
        Thread current = Thread.currentThread();
        Thread other = threadHolder.updateAndGet(t -> t == null ? current : t);
        assertEquals(other, current);
    }

    private void log(String testName) {
        System.out.println(prefix
                + " " + counter.incrementAndGet()
                + " " + testName
                + " " + Thread.currentThread());
    }

    private static void work() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
