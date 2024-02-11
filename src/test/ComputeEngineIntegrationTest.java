import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComputeEngineIntegrationTest {

    @Test
    void testComputeEngineIntegration() {
        DataSystem dataSystem = new DataSystem();
        ComputerEngineImpl computeEngine = new ComputerEngineImpl();

        List<Integer> inputData = List.of(1, 10, 25);
        
        String testDataIdentifier = "testData";
        int x = computeEngine.performDigitFactorial();

        DataResponse computationResult = dataSystem.storeData(testDataIdentifier, x);
        computationResult = dataSystem.retrieveData(testDataIdentifier);

        assertNotNull(computationResult);
        List<String> expectedResults = List.of("Expected Result for 1", "Expected Result for 10", "Expected Result for 25");
        assertEquals(expectedResults, computationResult.getOutputData());
    }
}
