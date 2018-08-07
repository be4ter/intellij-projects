package myTest;

public class TestError {
    private TestCase testCast;
    private Exception exception;

    public TestError(TestCase testCase, Exception e) {
        this.testCast = testCase;
        this.exception = e;
    }

    public String getTestCastName() {
        return testCast.getTestCaseName();
    }

    public Exception getException() {
        return exception;
    }
}
