package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Assert {
    public static final Logger log = LoggerFactory.getLogger(Assert.class);

    private Assert() {
    }

    public static void assertTrue(boolean condition) throws AssertionFailedError {
        if (!condition) {
            throw new AssertionFailedError();
        }
        log.debug("Test 통과");
    }
}
