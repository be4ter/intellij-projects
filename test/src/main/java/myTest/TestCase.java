package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestCase implements Test {
    public static final Logger log = LoggerFactory.getLogger(TestCase.class);

    protected String testCaseName;

    public TestCase(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public void run(TestResult testResult) {
        testResult.startTest();
        before();
        try {
            testRun();
        } catch (InvocationTargetException e) {
            if (isAssertionFailed(e)) {
                testResult.addFailure(this);
            } else {
                testResult.addError(this, e);
            }
        } catch (Exception e) {
            testResult.addError(this, e);
        } finally {
            tearDown();
        }
    }

    private boolean isAssertionFailed(InvocationTargetException e) {
        return e.getTargetException() instanceof AssertionFailedError;
    }

    protected void tearDown() {
    }

    ;

    protected void before() {
    }

    ;

    public void testRun() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            log.info("{} execute ", testCaseName); // 테스트 케이스들 구별을 위해 name 출력 코드
            Method method = this.getClass().getMethod(this.testCaseName, null);
            method.invoke(this, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getTestCaseName() {
        return testCaseName;
    }
}
