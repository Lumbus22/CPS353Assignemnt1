package coordinator;

import Implementations.DataSystem;
import Implementations.ComputationImpl;
import coordinator.CoordinatorImplOuterClass.SetSourceRequest;
import coordinator.CoordinatorImplOuterClass.ComputationResponse;
import coordinator.CoordinatorImplOuterClass.StartComputationCustDelimiterRequest;
import coordinator.CoordinatorImplOuterClass.SetSourceResponse;
import coordinator.CoordinatorServiceGrpc.CoordinatorServiceImplBase;
import io.grpc.stub.StreamObserver;
import java.io.IOException;

public class CoordinatorServiceImpl extends CoordinatorServiceImplBase {

    private String sourceFilePath = "test/dataTests/testInput.csv";

    @Override
    public void startComputationCustDelimiter(StartComputationCustDelimiterRequest request, StreamObserver<ComputationResponse> responseObserver) {
        String destinationFilePath = request.getDestinationFilePath();
        String delimiter = request.getDelimiter();
        boolean success = false;
        String message = "";

        try {
            DataSystem dataSystem = new DataSystem(sourceFilePath, destinationFilePath);
            dataSystem.readFromFile();

            // Use ComputationImpl for the computation part
            ComputationImpl computation = new ComputationImpl(sourceFilePath);
            String[] numberStrings = computation.receiveDataForComputation();

            // Check if data is received for computation
            if (numberStrings == null || numberStrings.length == 0) {
                throw new RuntimeException("No data received for computation.");
            }

            long[][] results = computation.performDigitFactorial(numberStrings);

            // Check if results are computed
            if (results == null || results.length == 0) {
                throw new RuntimeException("Computation did not produce any results.");
            }

            dataSystem.writeToFile(results, delimiter);

            success = true;
            message = "Computation completed successfully. Results written to " + destinationFilePath;
        } catch (IOException e) {
            message = "Failed to read from source file or write to destination file: " + e.getMessage();
            e.printStackTrace();
        } catch (RuntimeException e) {
            message = "Computation error: " + e.getMessage();
            e.printStackTrace();
        } catch (Exception e) {
            message = "Unexpected error during computation: " + e.getMessage();
            e.printStackTrace();
        }

        ComputationResponse response = ComputationResponse.newBuilder()
                .setIsSuccess(success)
                .setMessage(message)
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
}

