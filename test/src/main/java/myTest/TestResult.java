package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    public static final Logger log = LoggerFactory.getLogger(TestResult.class);
    private int testCount;
    private List<TestFailure> failures;
    private List<TestErrors> errors;

    public TestResult() {
        this.testCount = 0;
        this.failures = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public synchronized void startTest() {
        testCount += 1;
    }

    public void printCount() {
        log.info("Total Test Count: {}", testCount);
        log.info("Total Test Success Count: {}", testCount - failures.size() - errors.size());
        log.info("Total Test Failure Count: {}", failures.size());
        log.info("Total Test Error Count: {}", errors.size());
    }


    public void addFailure(TestCase testCase) {
        this.failures.add(new TestFailure(testCase));
    }

    public void addError(TestCase testCase, Exception e) {
        this.errors.add(new TestErrors(testCase, e));

    }
}
