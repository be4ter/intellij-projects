package jnitTest;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealTestCaseTest {
    private RealTestCase realTestCase;

    @Before
    public void setUp() {
        realTestCase = new RealTestCase("test");
    }

    @Test
    public void testCreate() {
        assertEquals(new RealTestCase(), realTestCase);
    }
}
