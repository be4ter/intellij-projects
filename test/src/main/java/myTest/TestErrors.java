package myTest;

public class TestErrors {
    private TestCase testCase;
    private Exception exception;

    public TestErrors(TestCase testCase, Exception exception) {
        this.testCase = testCase;
        this.exception = exception;
    }

    public String getTestCaseName() {
        return testCase.getTestCaseName();
    }

    public Exception getException() {
        return exception;
    }
}
