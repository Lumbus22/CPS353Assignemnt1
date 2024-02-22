import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestComputation {

    private ComputationImpl computation;

    @Before
    public void setUp() {
        computation = new ComputationImpl("dummyPath");
        computation.numberStrings = new String[]{"1", "2"};
    }

    @Test
    public void testPerformDigitFactorial() {
        long[][] results = computation.performDigitFactorial();
        assertNotNull(results);
        assertTrue(results.length == 2 && results[0].length == 2);
        assertTrue(results[1][0] == 1 && results[1][1] == 2);
    }
}

