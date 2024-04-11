import Implementations.CoordinatorImpl;
import org.junit.jupiter.api.Test;

public class TestCoordinator {

    @Test
    public void testCoordinator() {
        String serverAddress = "localhost";
        int serverPort = 50059;
        String sourceFilePath = "test/dataTests/testInput.csv";
        String destinationFilePath = "test/dataTests/testoutput.csv";

        CoordinatorImpl coordinator = new CoordinatorImpl(serverAddress, serverPort);
        coordinator.setSource(sourceFilePath);
        boolean isSuccess = coordinator.startComputation(destinationFilePath);

        if (isSuccess) {
            System.out.println("Test successful");
        } else {
            System.err.println("Test failed");
        }
    }
}
