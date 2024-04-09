
import coordinator.CoordinatorServiceGrpc;
import io.grpc.stub.StreamObserver;

public class CoordinatorServiceImpl extends CoordinatorServiceGrpc.CoordinatorServiceImplBase {

    @Override
    public void startComputation(coordinator.CoordinatorImpl.ComputationRequest request,
                                 StreamObserver<coordinator.CoordinatorImpl.ComputationResponse> responseObserver) {
        coordinator.CoordinatorImpl.ComputationResponse response = coordinator.CoordinatorImpl.ComputationResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Computation started successfully.")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void startComputationCustDelimiter(coordinator.CoordinatorImpl.CustomComputationRequest request,
                                              StreamObserver<coordinator.CoordinatorImpl.ComputationResponse> responseObserver) {
        coordinator.CoordinatorImpl.ComputationResponse response = coordinator.CoordinatorImpl.ComputationResponse.newBuilder()
                .setSuccess(true)
                .setMessage("Computation with custom delimiter started successfully.")
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void setSource(coordinator.CoordinatorImpl.SourceRequest request,
                          StreamObserver<coordinator.CoordinatorImpl.SourceResponse> responseObserver) {
        // Implement the server-side logic for SetSource RPC
        coordinator.CoordinatorImpl.SourceResponse response = coordinator.CoordinatorImpl.SourceResponse.newBuilder()
                .setSourceFilePath("Path set to: " + request.getInputFile())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
