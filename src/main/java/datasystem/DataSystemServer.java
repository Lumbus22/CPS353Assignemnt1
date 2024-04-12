package datasystem;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

public class DataSystemServer {

    private Server server;

    private void start() throws IOException {
        /* The port on which the server should run */
        int port = 50058;
        server = ServerBuilder.forPort(port)
                .addService(new DataSystemImpl())
                .build()
                .start();

        System.out.println("Server started, listening on port:" + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.err.println("*** shutting down gRPC server since JVM is shutting down...");
            DataSystemServer.this.stop();
            System.err.println("*** server shut down.");
        }));
    }

    private void stop() {
        if (server != null) {
            server.shutdown();
        }
    }

    private void blockUntilShutdown() throws InterruptedException {
        if (server != null) {
            server.awaitTermination();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        final DataSystemServer server = new DataSystemServer();
        server.start();
        server.blockUntilShutdown();
    }
}
