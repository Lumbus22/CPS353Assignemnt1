import java.io.File;
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
    public void testComputationSuccessWithCustomDelimiter() {
        String delimiter = ";";
        String inputPath = "test/dataTests/testInputFile.test";
        String outputPath = "test1" + File.separator + "testOutputFile.test";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        assertTrue(isSuccess, "Computation should complete successfully");
    }

    // If run is intended to be a test, annotate with @Test and consider renaming for clarity
    public void run(String outputPath) {
        if (this.coordinator == null) {
            this.coordinator = new CoordinatorImpl();
        }
        String delimiter = ";";
        String inputPath = "test/dataTests/testInputFile.test";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        if (!isSuccess) {
            throw new RuntimeException("Computation failed");
        }
    }
}

