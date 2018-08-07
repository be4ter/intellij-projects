package myTest;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {
    private List<TestCase> testCases = new ArrayList<>();

    @Override
    public void run(TestResult testResult) {
        for (TestCase cases : testCases) {
            cases.run(testResult);
        }
    }

    public void addTestcase(TestCase testCase) {
        this.testCases.add(testCase);
    }
}
