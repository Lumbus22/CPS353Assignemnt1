package coordinator;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import io.grpc.Grpc;
import io.grpc.InsecureServerCredentials;
import io.grpc.Server;
import io.grpc.protobuf.services.ProtoReflectionService;

public class CoordinatorServer {
    private Server server;

    private void start() throws IOException {
        int port = 50059; // Consider changing the port if needed

        server = Grpc.newServerBuilderForPort(port, InsecureServerCredentials.create())
                .addService(new CoordinatorServiceImpl()) // Make sure to use your CoordinatorServiceImpl
                .addService(ProtoReflectionService.newInstance()) // Optional: for reflection and tooling support
                .build()
                .start();
        System.out.println("Server started, listening on " + port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                System.err.println("*** shutting down gRPC server since JVM is shutting down");
                try {
                    if (server != null) {
                        server.shutdown().awaitTermination(30, TimeUnit.SECONDS);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace(System.err);
                }
                System.err.println("*** server shut down");
            }
        });
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        CoordinatorServer server = new CoordinatorServer();
        server.start();
        server.blockUntilShutdown();
    }
}

