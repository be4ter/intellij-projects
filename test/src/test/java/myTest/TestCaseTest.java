package myTest;

public class TestCaseTest extends TestCase {
    private int base;

    public TestCaseTest(String testCaseName) {
        super(testCaseName);
    }

    @Override
    public void before() {
        base = 10;
    }

    public void runTest() {
        int sum = 10 + base;
        Assert.assertTrue(sum == 20);
    }

    public void minus() {
        int sum = 10 - base;
        Assert.assertFaild(sum == 10);
    }


    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite();
        testSuite.addTestCase(new TestCaseTest("runTest"));
        testSuite.addTestCase(new TestCaseTest("minus"));
        TestResult testResult = new TestResult();
        testSuite.run(testResult);
        testResult.printCount();
    }
}
