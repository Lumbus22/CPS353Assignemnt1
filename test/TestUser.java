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

import java.io.File;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class TestUser {

    private CoordinatorImpl coordinator;

    @Before
    public void setUp() {
        this.coordinator = new CoordinatorImpl();
        // any other initialization
    }

    @Test
    public void testRun() {
        String delimiter = ";";
        String inputPath = "test" + File.separator + "testInputFile.test";
        String outputPath = "test1" + File.separator + "testOutputFile.test";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        assertTrue("Computation should complete successfully", isSuccess);
        // Further assertions can be added here to validate the output
    }

	public void run(String outputPath) {
        String delimiter = ";";
        String inputPath = "test" + File.separator + "testInputFile.test";

        coordinator.setSource(inputPath);
        boolean isSuccess = coordinator.startComputationCustDelimiter(outputPath, delimiter);

        // Consider throwing an exception or handling failure scenarios differently
        // if the computation is not successful
        if (!isSuccess) {
            throw new RuntimeException("Computation failed");
        }
    }
}
