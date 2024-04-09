package Implementations;

import java.io.IOException;

import Interfaces.CoordinatorInterface;

public class CoordinatorImpl implements CoordinatorInterface {

  private String sourceFilePath;
  private DataSystem dataSystem;

  public CoordinatorImpl() {
    this.dataSystem = new DataSystem("test/dataTests/testInput.csv", "test/dataTests/testOutput.csv");
  }

  public CoordinatorImpl(DataSystem dataSystem) {
    this.dataSystem = dataSystem;
  }

  public static void main(String[] args) {
    CoordinatorImpl coordinator = new CoordinatorImpl();
    String sourceFilePath = "ComputerEngine/document.csv";
    coordinator.setSource(sourceFilePath);
    String destinationFilePath = "ComputerEngine/document2.csv";
    boolean isSuccess = coordinator.startComputationCustDelimiter(destinationFilePath, "/");
    if (isSuccess) {
      System.out.println("Computation completed successfully and results are written to " + destinationFilePath);
    } else {
      System.err.println("Computation failed.");
    }
  }

  @Override
  public boolean startComputation(String destinationFilePath) {
    try {
      this.dataSystem.readFromFile();
      ComputationImpl computation = new ComputationImpl(sourceFilePath);
      computation.receiveDataForComputation();
      long[][] results = computation.performDigitFactorial();
      this.dataSystem.writeToFile(results, null);
      return true;
    } catch (IOException e) {
      e.printStackTrace();
      return false;
    }
  }

  public void setDataSystem(DataSystem dataSystem) {
    this.dataSystem = dataSystem;
  }

  @Override
  public boolean startComputationCustDelimiter(String destinationFilePath, String delimiter) {
    try {
      this.dataSystem = new DataSystem(sourceFilePath, destinationFilePath);
      this.dataSystem.readFromFile();
      ComputationImpl computation = new ComputationImpl(sourceFilePath);
      computation.receiveDataForComputation();
      long[][] results = computation.performDigitFactorial();
      this.dataSystem.writeToFile(results, delimiter);
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

