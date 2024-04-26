import Implementations.ComputationImpl;
import Implementations.CoordinatorImpl;
import Implementations.DataSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class TestBenchmark {
    @Test
    public void testStartComputation() throws IOException {
        long startTime = System.currentTimeMillis();

        // Setup
        String filePath = "test/dataTests/testInput.csv";
        DataSystem testDataSystem = new DataSystem("test/dataTests/testInput.csv", "test/dataTests/testOutput.csv");
        ComputationImpl computerEngine = new ComputationImpl(filePath);
        computerEngine.setDataSystem(testDataSystem);
        CoordinatorImpl coordinator = new CoordinatorImpl(testDataSystem);

        // Execution
        computerEngine.receiveDataForComputation();
        long[][] computationResult = computerEngine.performDigitFactorial();
        boolean userToComputerResult = coordinator.startComputation(testDataSystem.outPutFilePath);

        // Validation
        assertNotNull(computationResult, "Computation result should not be null");
        assertTrue(userToComputerResult, "Processing user request failed");

        // Performance Metrics
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        assertTrue(duration < 1000, "Performance test failed: Operation took too long.");

        System.out.println("Test completed in " + duration + " milliseconds.");
    }
}
