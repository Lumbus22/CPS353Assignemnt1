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
        CoordinatorImplOuterClass.SetSourceResponse response;
        try {
            response = blockingStub.setSource(request);
        } catch (StatusRuntimeException e) {
            System.err.println("RPC failed: " + e.getStatus());
            return;
        }
        System.out.println("Source file path set to: " + response.getSourceFilePath());
    }

    public static void main(String[] args) throws Exception {
        String target = "localhost:50059";

        ManagedChannel channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            CoordinatorClient client = new CoordinatorClient(channel);
            client.setSource("path/to/source/file");
        } finally {
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS);
        }
    }
}

