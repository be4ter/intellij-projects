package xUnit;

public class TestResult {
    int runCount;
    int runFaildCount;

    public String summury() {
        return String.format("%d run, %d faild", this.runCount, this.runFaildCount);
    }

    public void testStart() {
        this.runCount += 1;
    }

    public void testFaild() {
        this.runFaildCount += 1;
    }
}
