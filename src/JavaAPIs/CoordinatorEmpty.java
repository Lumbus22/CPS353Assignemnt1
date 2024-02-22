import java.io.IOException;

public class CoordinatorEmpty implements CoordinatorInterface {

  private String sourceFilePath;
  private DataSystem dataSystem;


  @Override
  public boolean startComputation(String destinationFilePath) {
    return boolean;
  }

  @Override
  public boolean startComputationCustDelimiter(String destinationFilePath, String delimiter) {
    return boolean;
  }

  // Allows user to set inputFile source (in form of csv for now)
  @Override
  public String setSource(String inputFile) {
    return String;
  }

}

