import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;


public class TestComputation {

    
    private ComputationImpl computation;
    private DataSystem mockDataSystem;

    @Before
    public void setUp() {
        computation = new ComputationImpl("dummyPath");
        computation.numberStrings = new String[]{"1", "2"};
        mockDataSystem = mock(DataSystem.class);
        computation = new ComputationImpl("dummy/path");
    }


    // Make sure that datasystem getNumberStrings = receiveDataForComputation numberStrings
    @Test
    public void testReceiveDataForComputation() throws IOException {
        String[] numberStrings = {"1", "2", "3"};
        when(mockDataSystem.getNumberStrings()).thenReturn(numberStrings);
        computation.setDataSystem(mockDataSystem);
        computation.receiveDataForComputation();
        assertArrayEquals(numberStrings, computation.getNumberStrings());
    }

    @Test
    public void testPerformDigitFactorial() {
        long[][] results = computation.performDigitFactorial();
        assertNotNull(results);
        assertTrue(results.length == 2 && results[0].length == 2);
        assertTrue(results[1][0] == 1 && results[1][1] == 2);
    }
}
