import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import Interfaces.CoordinatorInterface;

public class CoordinatorImpl implements CoordinatorInterface {

  private String sourceFilePath;
  protected DataSystem dataSystem;
  private ExecutorService executor;

  public CoordinatorImpl() {
    int numberOfThreads = 4;
    executor = Executors.newFixedThreadPool(numberOfThreads);
  }

  public CoordinatorImpl(DataSystem dataSystem) {
      this();
      this.dataSystem = dataSystem;
  }

  @Override
  public boolean startComputation(String destinationFilePath) {
    try {
      this.dataSystem.readFromFile();
      ComputationImpl computation = new ComputationImpl(sourceFilePath);
      
      executor.submit(() -> {
        try {
          computation.receiveDataForComputation();
          long[][] results = computation.performDigitFactorial();
          this.dataSystem.setDestination(destinationFilePath);
          this.dataSystem.writeToFile(results, null);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      executor.shutdown();
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
      
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public boolean startComputationCustDelimiter(String destinationFilePath, String delimiter) {
    try {
      this.dataSystem = new DataSystem(sourceFilePath, destinationFilePath);
      this.dataSystem.readFromFile();
      ComputationImpl computation = new ComputationImpl(sourceFilePath);
      
      executor.submit(() -> {
        try {
          computation.receiveDataForComputation();
          long[][] results = computation.performDigitFactorial();
          this.dataSystem.setDestination(destinationFilePath);
          this.dataSystem.writeToFile(results, delimiter);
        } catch (IOException e) {
          e.printStackTrace();
        }
      });

      executor.shutdown();
      executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  @Override
  public String setSource(String inputFile) {
    this.sourceFilePath = inputFile;
    return this.sourceFilePath;
  }

}


