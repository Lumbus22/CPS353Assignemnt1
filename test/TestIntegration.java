import Implementations.ComputationImpl;
import Implementations.CoordinatorImpl;
import Implementations.DataSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIntegration {

    @Test
    public void testStartComputation() {
        // Define file paths
        String inputFilePath = "test/dataTests/testInput.csv";
        String outputFilePath = "test/dataTests/testOutput.csv";

        // Initialize DataSystem with input and output file paths
        DataSystem testDataSystem = new DataSystem(inputFilePath, outputFilePath);

        // Initialize ComputationImpl with the input file path
        ComputationImpl computationEngine = new ComputationImpl(inputFilePath);
        computationEngine.setDataSystem(testDataSystem);

        // Initialize CoordinatorImpl, assuming it requires server address and port
        String serverAddress = "localhost";
        int serverPort = 50051;
        CoordinatorImpl coordinator = new CoordinatorImpl(serverAddress, serverPort);

        // Trigger computation and interaction between components
        computationEngine.receiveDataForComputation();
        long[][] computationResult = computationEngine.performDigitFactorial();

        // Start computation by providing the output file path to the coordinator
        boolean userToComputerResult = coordinator.startComputation(outputFilePath);

        // Assertions to verify the outcomes
        assertNotNull(computationResult, "Computation result should not be null");
        assertTrue(userToComputerResult, "Processing user request failed");
    }
}

