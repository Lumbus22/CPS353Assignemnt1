import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.isNull;
import static org.junit.Assert.assertTrue;
import java.io.IOException;

public class TestCoordinator {

    @Test
    public void testStartComputation() throws IOException {
        DataSystem mockDataSystem = mock(DataSystem.class);
        CoordinatorImpl coordinator = new CoordinatorImpl(mockDataSystem);
        doNothing().when(mockDataSystem).readFromFile();
        doNothing().when(mockDataSystem).writeToFile(any(long[][].class), anyString());
        boolean isSuccess = coordinator.startComputation("/Users/davidvenuto/Desktop/TestCodeShit/ComputerEngine/document.csv");
        verify(mockDataSystem).readFromFile();
        verify(mockDataSystem).writeToFile(any(long[][].class), isNull());
        assertTrue(isSuccess);
    }
}
