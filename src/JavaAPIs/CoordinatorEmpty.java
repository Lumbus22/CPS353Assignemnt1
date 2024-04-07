package JavaAPIs;

import Interfaces.CoordinatorInterface;

public class CoordinatorEmpty implements CoordinatorInterface {

 // private String sourceFilePath;

  @Override
  public boolean startComputation(String destinationFilePath) {
    return true;
  }

  @Override
  public boolean startComputationCustDelimiter(String destinationFilePath, String delimiter) {
    return true;
  }

  // Allows user to set inputFile source (in form of csv for now)
  @Override
  public String setSource(String inputFile) {
    return inputFile;
  }

}

