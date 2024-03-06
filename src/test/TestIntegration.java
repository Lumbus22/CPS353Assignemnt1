import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestIntegration {
    
    @Test
    public void testStartComputation() {
        DataSystem dataSystem = new DataSystem("/test/dataTests/inputtests.csv", "/test/dataTests/testoutput.csv");
        ComputationImpl computation = new ComputationImpl("/test/dataTests/inputtests.csv");

        CoordinatorImpl coordinator = new CoordinatorImpl(dataSystem);
        String sourceFilePath = "/test/dataTests/inputtests.csv";
        coordinator.setSource(sourceFilePath);
        String destinationFilePath = "/test/dataTests/testoutput.csv";
        boolean isSuccess = coordinator.startComputation(destinationFilePath);
        if (isSuccess) {
            System.out.println("Computation completed successfully and results are written to " + destinationFilePath);
        } else {
            System.err.println("Computation failed.");
        }
        assertEquals(true, isSuccess);
    }

}
