package datasystem;

import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataSystemClient {

    private final DataSystemGrpc.DataSystemBlockingStub blockingStub;

    public DataSystemClient(Channel channel) {
        this.blockingStub = DataSystemGrpc.newBlockingStub(channel);
    }

    public void readFromFile(String inputFilePath) {
        Datasystem.ReadRequest request = Datasystem.ReadRequest.newBuilder()
                .setInputFilePath(inputFilePath)
                .build();
        try {
            Datasystem.ReadResponse response = blockingStub.readFromFile(request);
            System.out.println("Received readFromFile response from server:");
            response.getNumberStringsList().forEach(System.out::println);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void writeToFile(String outputFilePath, List<String> numbers, String delimiter) {
        Datasystem.WriteRequest request = Datasystem.WriteRequest.newBuilder()
                .setOutputFilePath(outputFilePath)
                .addAllNumbers(numbers)
                .setDelimiter(delimiter)
                .build();
        try {
            Datasystem.WriteResponse response = blockingStub.writeToFile(request);
            System.out.println("Received writeToFile response from server. Success = " + response.getSuccess());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50058"; // Adjust the port if your server is listening on a different one
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        try {
            DataSystemClient client = new DataSystemClient(channel);

            // Example usage
            client.readFromFile("test/dataTests/dsInput.txt");
            client.writeToFile("test/dataTests/dsOutput.txt", List.of("1", "2", "3", "4"), ",");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}
