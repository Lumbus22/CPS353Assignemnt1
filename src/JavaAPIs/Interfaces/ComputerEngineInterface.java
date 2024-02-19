import java.io.FileNotFoundException;

public interface ComputerEngineInterface {
    // Receieve Data
      public void receiveDataForComputation() throws FileNotFoundException;
  
    // Manipulate Data
    public long[][] performDigitFactorial();
  }
