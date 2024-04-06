import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;

public class TestComputation {

    private ComputationImpl computation;
    private DataSystem mockDataSystem;

    @BeforeEach
    public void setUp() {
        mockDataSystem = mock(DataSystem.class);
        computation = new ComputationImpl("dummy/path");
        computation.setDataSystem(mockDataSystem);
    }

    @Test
    public void testReceiveDataForComputation() throws IOException {
        String[] numberStrings = {"1", "2", "3"};
        when(mockDataSystem.getNumberStrings()).thenReturn(numberStrings);
        
        String[] result = computation.receiveDataForComputation();
        
        assertArrayEquals(numberStrings, result);
    }

    @Test
    public void testPerformDigitFactorial() {
        String[] numberStrings = {"1", "2"};
        long[][] expectedResults = {{1, 2}, {1, 2}};

        long[][] results = computation.performDigitFactorial(numberStrings);

        assertNotNull(results);
        assertArrayEquals(expectedResults[0], results[0]);
        assertArrayEquals(expectedResults[1], results[1]);
    }
}
