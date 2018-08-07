package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase implements Test {
    public static final Logger log = LoggerFactory.getLogger(TestCase.class);

    public String testCaseName;

    public TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public void after() {
    }

    public void before() {
    }

    private void runTestCase() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        log.debug("{} excute", testCaseName);
        Method method = this.getClass().getMethod(testCaseName, null);
        method.invoke(this, null);
    }

    public TestResult run() {
        TestResult testResult = createTestResult();
        run(testResult);
        return testResult;
    }

    public void run(TestResult testResult) {
        testResult.startTest();
        before();
        try {
            runTestCase();
        } catch (InvocationTargetException ite) {
            if (isAssertionFailed(ite)) {
                testResult.addFailed(this);
            } else {
                testResult.addError(this, ite);
            }
        } catch (Exception e) {
            testResult.addError(this, e);
        } finally {
            after();
        }
    }

    private boolean isAssertionFailed(InvocationTargetException ite) {
        return ite.getTargetException() instanceof AssertionFailedError;
    }

    private TestResult createTestResult() {
        return new TestResult();
    }

    public String getTestCaseName() {
        return testCaseName;
    }
}
