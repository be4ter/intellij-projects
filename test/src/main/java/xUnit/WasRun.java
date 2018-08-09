package xUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WasRun extends TestCase {
    public static final Logger logger = LoggerFactory.getLogger(WasRun.class);
    public String log = "";

    public WasRun(String testMethod) {
        super(testMethod);
    }

    public void testMethod() {
        log += "testMethod ";
        logger.debug(log);
    }

    @Override
    public void setUp() {
        log += "setUp ";
        logger.debug(log);
    }

    @Override
    public void tearDown() {
        log += "tearDown";
        logger.debug(log);
    }

    public void testBrokenMethod() throws Exception {
        throw new Exception();
    }
}
