import java.io.FileNotFoundException;
import java.io.IOException;

public interface UserToComputerEngineInterface{
    // Allows user to set inputFile source (in form of csv for now) 
      public String setSource(String inputFile);

    // Allows user to set outputFile source (in form of csv for now)
      public String setDestination(String outputFile);
    
    // Carries out the computation of the digit factorial, output formatted with default delimiter
      public long[][] exCompDefaultDelim() throws FileNotFoundException, IOException;

    // Carries out the computation of the digit factorial, output formatted with custom delimiter
      public long[][] exCompCustomDelim(String customDelim) throws FileNotFoundException;
    }
