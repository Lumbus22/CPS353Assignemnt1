import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import coordinator.CoordinatorImpl;
import coordinator.CoordinatorServiceGrpc;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import coordinator.CoordinatorServiceGrpc.CoordinatorServiceBlockingStub;

public class CoordinatorClient {
    private final CoordinatorServiceBlockingStub blockingStub;

    public CoordinatorClient(Channel channel) {
        blockingStub = CoordinatorServiceGrpc.newBlockingStub(channel);
    }

    public void startComputationWithDelimiter(String destinationFilePath, String delimiter) {
        CoordinatorImpl.CustomComputationRequest request = CoordinatorImpl.CustomComputationRequest.newBuilder()
                .setDestinationFilePath(destinationFilePath)
                .setDelimiter(delimiter)
                .build();

        CoordinatorImpl.ComputationResponse response;
        try {
            response = blockingStub.startComputationCustDelimiter(request);
            System.out.println("Computation started successfully: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose input mode: [1] File Upload [2] Enter Numbers");
        int choice = scanner.nextInt();
        scanner.nextLine();

        String inputData = null;
        if (choice == 1) {
            System.out.println("Enter the path to the input file:");
            inputData = scanner.nextLine();
        } else if (choice == 2) {
            System.out.println("Type in a list of numbers (e.g., 1,2,3,4):");
            inputData = scanner.nextLine();
        } else {
            System.err.println("Invalid choice");
            scanner.close();
            return;
        }

        System.out.println("Enter the path for the output file:");
        String outputPath = scanner.nextLine();

        System.out.println("Enter an optional delimiter (press Enter to skip, default is ','):");
        String delimiter = scanner.nextLine();
        delimiter = delimiter.isEmpty() ? "," : delimiter;

        String target = "localhost:50058";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        try {
            CoordinatorClient client = new CoordinatorClient(channel);
            client.startComputationWithDelimiter(outputPath, delimiter);
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
            scanner.close();
        }
    }
}

