package myTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class TestResult {
    public static final Logger log = LoggerFactory.getLogger(TestResult.class);
    private List<TestError> errors;
    private List<TestFailure> failures;
    private int runTestCount;

    public TestResult() {
        this.runTestCount = 0;
        this.failures = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public synchronized void startTest() {
        this.runTestCount++;
    }

    public void printCount() {
        log.debug("검사한 테스트 개수 : {} ", runTestCount);
        log.info("Total Test Success Count: {}", runTestCount - failures.size() - errors.size());
        log.info("Total Test Failure Count: {}", failures.size());
        log.info("Total Test Error Count: {}", errors.size());
    }

    public synchronized void addFailed(TestCase testCase) {
        this.failures.add(new TestFailure(testCase));
    }

    public synchronized void addError(TestCase testCase, Exception e) {
        this.errors.add(new TestError(testCase, e));
    }
}
