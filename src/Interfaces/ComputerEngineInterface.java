import java.io.IOException;

public interface ComputerEngineInterface {
    // Receieve Data
      public void receiveDataForComputation() throws IOException;
  
    // Manipulate Data
    public long[][] performDigitFactorial();
  }
