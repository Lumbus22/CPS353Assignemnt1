import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class TestComputerEngine {

    @Test
    public void testReceiveDataForComputation() {
        DataSystemInterface mockDataSystem = mock(DataSystemInterface.class);
        Data expectedData = new Data();

        when(mockDataSystem.retrieveData(anyString())).thenReturn(expectedData);

        ComputerEngineImpl engine = new ComputerEngineImpl(mockDataSystem);

        Data actualData = engine.receiveDataForComputation();

        assertNotNull(actualData);
        assertEquals(expectedData, actualData);
    }

    @Test
    public void testPerformDigitFactorial() {
        ComputerEngineImpl engine = new ComputerEngineImpl(null); // Passing null since DataSystemInterface is not used in this test

        Request request = engine.performDigitFactorial();

        assertNotNull(request);
    }
}
