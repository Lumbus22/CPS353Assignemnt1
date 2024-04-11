package coordinator;

import java.util.concurrent.TimeUnit;
import io.grpc.Channel;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.StatusRuntimeException;

public class CoordinatorClient {
    private final CoordinatorServiceGrpc.CoordinatorServiceBlockingStub blockingStub;

    public CoordinatorClient(Channel channel) {
        blockingStub = CoordinatorServiceGrpc.newBlockingStub(channel);
    }

    public void setSource(String sourceFilePath) {
        CoordinatorImplOuterClass.SetSourceRequest request = CoordinatorImplOuterClass.SetSourceRequest.newBuilder().setInputFile(sourceFilePath).build();
        try {
            CoordinatorImplOuterClass.SetSourceResponse response = blockingStub.setSource(request);
            System.out.println("Source file path set to: " + response.getSourceFilePath());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public void startComputationWithCustomDelimiter(String destinationFilePath, String delimiter) {
        CoordinatorImplOuterClass.StartComputationCustDelimiterRequest request = CoordinatorImplOuterClass.StartComputationCustDelimiterRequest.newBuilder()
                .setDestinationFilePath(destinationFilePath)
                .setDelimiter(delimiter)
                .build();
        try {
            CoordinatorImplOuterClass.ComputationResponse response = blockingStub.startComputationCustDelimiter(request);
            System.out.println("Computation success: " + response.getIsSuccess());
            System.out.println("Message: " + response.getMessage());
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 3) {
            System.err.println("Usage: CoordinatorClient <source file path> <destination file path> <delimiter>");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        String destinationFilePath = args[1];
        String delimiter = args[2];

        String target = "localhost:50059";
        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create()).build();
        try {
            CoordinatorClient client = new CoordinatorClient(channel);
            client.setSource(sourceFilePath);
            client.startComputationWithCustomDelimiter(destinationFilePath, delimiter);
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

