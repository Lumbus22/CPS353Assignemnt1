
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestIntegration {
    
    @Test
    public void testStartComputation() {
        DataSystem dataSystem = new DataSystem("/src/test/inputTests/inputtests.csv", "/src/test/outpputTests/outputtests.csv");
        ComputationImpl computation = new ComputationImpl("/src/test/inputTests/inputtests.csv");

        CoordinatorImpl coordinator = new CoordinatorImpl(dataSystem);
        String sourceFilePath = "src/test/dataTests/inputtests.csv";
        coordinator.setSource(sourceFilePath);
        String destinationFilePath = "src/test/dataTests/testoutput.csv";
        boolean isSuccess = coordinator.startComputation(destinationFilePath);
        if (isSuccess) {
            System.out.println("Computation completed successfully and results are written to " + destinationFilePath);
        } else {
            System.err.println("Computation failed.");
        }
        assertEquals(true, isSuccess);
    }

}
