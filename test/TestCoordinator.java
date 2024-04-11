import Implementations.CoordinatorImpl;

public class TestCoordinator {

    public static void main(String[] args) {
        String serverAddress = "localhost";
        int serverPort = 50059;
        String sourceFilePath = "path/to/test/input.csv";
        String destinationFilePath = "path/to/test/output.csv";

        CoordinatorImpl coordinator = new CoordinatorImpl(serverAddress, serverPort);
        coordinator.setSource(sourceFilePath);
        boolean isSuccess = coordinator.startComputation(destinationFilePath);

        if (isSuccess) {
            System.out.println("Smoke test passed: Data processed and written successfully.");
        } else {
            System.err.println("Smoke test failed: There was an issue with processing or writing the data.");
        }
    }
}
