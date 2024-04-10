import Implementations.ComputationImpl;
import Implementations.CoordinatorImpl;
import Implementations.DataSystem;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestIntegration {

    @Test
    public void testStartComputation() {
        try {
            String inputFilePath = "test/dataTests/testInput.csv";
            String outputFilePath = "test/dataTests/testOutput.csv";

            DataSystem testDataSystem = new DataSystem(inputFilePath, outputFilePath);

            ComputationImpl computationEngine = new ComputationImpl(inputFilePath);
            computationEngine.setDataSystem(testDataSystem);

            String serverAddress = "localhost";
            int serverPort = 50058;
            CoordinatorImpl coordinator = new CoordinatorImpl(serverAddress, serverPort);

            coordinator.setSource(inputFilePath);

            computationEngine.receiveDataForComputation();
            long[][] computationResult = computationEngine.performDigitFactorial();

            boolean userToComputerResult = coordinator.startComputation(outputFilePath);

            assertNotNull(computationResult, "Computation result should not be null");
            assertTrue(userToComputerResult, "Processing user request failed");
        } catch (IOException e) {
            e.printStackTrace();
            fail("IOException was thrown");
        }
    }


}

