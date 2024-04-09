import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestUser {

    private CoordinatorImpl coordinator;

    @BeforeEach
    public void setUp() {
        this.coordinator = new CoordinatorImpl();
    }

    @Test
    public void testComputationCustomDelimiter() {
        String delimiter = ";";
        String inputPath = "test/dataTests/testInput.csv";
        String outputPath = "test/dataTests/testoutput.csv";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        assertTrue(isSuccess, "Computation should complete successfully");
    }

    public void run(String outputPath) {
        if (this.coordinator == null) {
            this.coordinator = new CoordinatorImpl();
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
