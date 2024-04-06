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
