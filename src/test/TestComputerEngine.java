import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class ComputerEngineImplTest {

    @Mock
    private DataSystemInterface mockDataSystem;

    private ComputerEngineImpl computerEngine;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        computerEngine = new ComputerEngineImpl();
        computerEngine.setDataSystem(mockDataSystem);
    }

    @Test
    public void testReceiveDataForComputation() {
        when(mockDataSystem.retrieveData(anyString())).thenReturn(new DataResponse(new Data()));
        Data actualData = computerEngine.receiveDataForComputation();
        assertNotNull(actualData);
    }

    @Test
    public void testPerformDigitFactorial() {
        Request request = computerEngine.performDigitFactorial();
        assertNotNull(request);
    }
}
