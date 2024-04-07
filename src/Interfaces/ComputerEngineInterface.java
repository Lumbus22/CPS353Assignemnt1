package Interfaces;

import java.io.IOException;

public interface ComputerEngineInterface {
    // Receieve Data
      public String[] receiveDataForComputation() throws IOException;
  
    // Manipulate Data
    public long[][] performDigitFactorial();
  }
