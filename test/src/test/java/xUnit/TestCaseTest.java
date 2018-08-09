package xUnit;

public class TestCaseTest extends TestCase {

    private WasRun wasRun;

    public TestCaseTest(String testMethodName) {
        super(testMethodName);
    }

    public void testTemplateMethod() {
        wasRun = new WasRun("testMethod");
        wasRun.run();
        assert wasRun.log.equals("setUp testMethod tearDown");
    }

    public void testResult() {
        wasRun = new WasRun("testMethod");
        TestResult testResult = wasRun.run();
        assert testResult.summury().equals("1 run, 0 faild");
    }

    public void testFaildResult() {
        wasRun = new WasRun("testBrokenMethod");
        TestResult testResult = wasRun.run();
        assert testResult.summury().equals("1 run 1 faild");
    }

    public static void main(String[] args) {
        System.out.println(new TestCaseTest("testFaildResult").run().summury());
    }
}
