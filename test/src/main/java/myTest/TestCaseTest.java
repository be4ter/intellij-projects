package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestCaseTest extends TestCase {
    public static final Logger log = LoggerFactory.getLogger(TestCaseTest.class);
    private int base;

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        new TestCaseTest("runTest");
        new TestCaseTest("runMinusTest");
        TestResult testResult = new TestResult();
        testSuite.run(testResult);
        testResult.printCount();
    }

    public TestCaseTest(String testCaseName) {
        super(testCaseName);
    }

    public void before() {
        base = 10;
    }

    public void runTest() {
        before();
        long sum = 10 + base;
        try {
            Assert.assertTrue(sum == 20);
        } catch (AssertionFailedError assertionFailedError) {
        }
    }

    public void runMinusTest() {
        before();
        long minus = 100 - base;
        try {
            Assert.assertTrue(minus == 80);
        } catch (AssertionFailedError assertionFailedError) {
        }
    }
}
