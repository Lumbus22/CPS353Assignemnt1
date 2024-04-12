package datasystem;

import io.grpc.stub.StreamObserver;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataSystemImpl extends DataSystemGrpc.DataSystemImplBase {

    @Override
    public void readFromFile(datasystem.Datasystem.ReadRequest req, StreamObserver<datasystem.Datasystem.ReadResponse> responseObserver) {
        String filePath = req.getInputFilePath();
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }

            datasystem.Datasystem.ReadResponse response = datasystem.Datasystem.ReadResponse.newBuilder()
                    .addAllNumberStrings(lines)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.INTERNAL.withDescription("File read error.").asRuntimeException());
        }
    }

    @Override
    public void writeToFile(datasystem.Datasystem.WriteRequest req, StreamObserver<datasystem.Datasystem.WriteResponse> responseObserver) {
        String filePath = req.getOutputFilePath();
        String delimiter = req.getDelimiter();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String number : req.getNumbersList()) {
                writer.write(number + delimiter);
            }

            datasystem.Datasystem.WriteResponse response = datasystem.Datasystem.WriteResponse.newBuilder()
                    .setSuccess(true)
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (IOException e) {
            e.printStackTrace();
            responseObserver.onError(io.grpc.Status.INTERNAL.withDescription("File write error.").asRuntimeException());
        }
    }
}

