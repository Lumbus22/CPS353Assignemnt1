package coordinator;

import coordinator.CoordinatorImplOuterClass.*;
import coordinator.CoordinatorServiceGrpc.CoordinatorServiceImplBase;
import io.grpc.stub.StreamObserver;

public class CoordinatorServiceImpl extends CoordinatorServiceImplBase {

    private String sourceFilePath = "";

    @Override
    public void startComputation(SetSourceRequest request, StreamObserver<ComputationResponse> responseObserver) {
        boolean success = false;
        String result = "";

        try {
            String data = "Data from " + this.sourceFilePath;
            result = processData(data); // Now 'result' is accessible here
            success = result != null && !result.isEmpty();
            System.out.println("Computation result: " + result);
        } catch (Exception e) {
            e.printStackTrace();
            result = "Error processing data"; // You can assign a default value or error message to 'result' here
        }

        ComputationResponse response = ComputationResponse.newBuilder()
                .setIsSuccess(success)
                .setMessage(result) // 'result' is accessible here as well
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }


    private String processData(String data) {
        return "Processed: " + data;
    }

    @Override
    public void startComputationCustDelimiter(StartComputationCustDelimiterRequest request, StreamObserver<ComputationResponse> responseObserver) {
        // Similar to startComputation, but uses a custom delimiter
        boolean success = performComputation(this.sourceFilePath, request.getDestinationFilePath(), request.getDelimiter());

        ComputationResponse response = ComputationResponse.newBuilder()
                .setIsSuccess(success)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setSource(SetSourceRequest request, StreamObserver<SetSourceResponse> responseObserver) {
        this.sourceFilePath = request.getInputFile();

        SetSourceResponse response = SetSourceResponse.newBuilder()
                .setSourceFilePath(this.sourceFilePath)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private boolean performComputation(String sourcePath, String destinationPath, String delimiter) {
        return true; // Placeholder
    }
}

