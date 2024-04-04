import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class TestIntegration {

    @Test
    public void testStartComputation() throws IOException {
        String filePath = "source/to/file";
        DataSystem testDataSystem = new DataSystem("src/test/dataTests/inputtests.csv", "src/test/dataTests/testoutput.csv");
        
        ComputationImpl computerEngine = new ComputationImpl(filePath);
        computerEngine.setDataSystem(testDataSystem);
        
        CoordinatorImpl coordinator = new CoordinatorImpl(testDataSystem);

        computerEngine.receiveDataForComputation(); 
        long[][] computationResult = computerEngine.performDigitFactorial();
        
        boolean userToComputerResult = coordinator.startComputation("destination/path");

        assertNotNull(computationResult, "Computation result should not be null");

        assertTrue(userToComputerResult, "Processing user request failed");
    }
}
