import Implementations.CoordinatorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUser {

    private CoordinatorImpl coordinator;

    @BeforeEach
    public void setUp() {
        String serverAddress = "localhost";
        int serverPort = 50051;
        this.coordinator = new CoordinatorImpl(serverAddress, serverPort);
    }

    @Test
    public void testComputationCustomDelimiter() {
        String delimiter = ";";
        String inputPath = "test/dataTests/testInput.csv";
        String outputPath = "test/dataTests/testOutput.csv";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        assertTrue(isSuccess, "Computation should complete successfully");
    }

    public void run(String outputPath) {
        if (this.coordinator == null) {
            String serverAddress = "localhost";
            int serverPort = 50051;
            this.coordinator = new CoordinatorImpl(serverAddress, serverPort);
        }
        String delimiter = ";";
        String inputPath = "test/dataTests/testInput.csv";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        if (!isSuccess) {
            throw new RuntimeException("Computation failed");
        }
    }
}
