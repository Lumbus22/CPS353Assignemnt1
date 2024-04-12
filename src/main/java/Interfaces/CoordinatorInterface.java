package Interfaces;
public interface CoordinatorInterface{
    
    // Allows user to set inputFile source (in form of csv for now) 
      public String setSource(String inputFile);
    
      public boolean startComputation(String destinationFilePath);

      public boolean startComputationCustDelimiter(String destinationFilePath, String delimiter);
    }
