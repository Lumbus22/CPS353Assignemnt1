import Implementations.ComputationImpl;
import Implementations.CoordinatorImpl;
import Implementations.DataSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

public class TestBenchmark {
    @Test
    public void testStartComputation() throws IOException {
        // Setup
        String filePath = "test/dataTests/testInput.csv";
        DataSystem testDataSystem = new DataSystem(filePath, "test/dataTests/testOutput.csv");
        ComputationImpl computerEngine = new ComputationImpl(filePath);
        computerEngine.setDataSystem(testDataSystem);
        CoordinatorImpl coordinator = new CoordinatorImpl(testDataSystem);

        // Read data first to focus on computation time
        computerEngine.receiveDataForComputation();

        final int iterations = 1000; // Increase iterations for more reliable averaging
        long totalDuration = 0;

        for (int i = 0; i < iterations; i++) {
            long startTime = System.nanoTime();
            long[][] computationResult = computerEngine.performDigitFactorial();
            long endTime = System.nanoTime();
            totalDuration += (endTime - startTime);
            assertNotNull(computationResult, "Computation result should not be null");
        }

        long averageDuration = totalDuration / iterations;

        // Check that average computation time meets performance expectations
        assertTrue(averageDuration < 500000, "Average computation took too long: " + averageDuration + " nanoseconds");

        System.out.println("Average computation took " + averageDuration + " nanoseconds.");
    }
}
