package xUnit;

import java.lang.reflect.Method;

public class TestCase {
    private String testMethodName;

    public TestCase(String testMethodName) {
        this.testMethodName = testMethodName;
    }

    public TestResult run() {
        TestResult testResult = new TestResult();
        testResult.testStart();
        setUp();
        try {
            Method methods = this.getClass().getMethod(testMethodName, null);
            System.out.println("method : " + methods);
            methods.invoke(this, null);
        } catch (Exception e) {
            testResult.testFaild();
        }
        tearDown();
        return testResult;
    }

    protected void setUp() {
    }

    protected void tearDown() {
    }


}
