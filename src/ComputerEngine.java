public interface ComputerEngine {
  Data receiveDataForComputation();
  
  // Manipulate Data
  Request performDigitFactorial();
  
  // Return data to data manager
  Response returnDigitFactorial(String outputURL);
}
public interface Request{
    
}
public interface Response{
    
}
public interface Data{
  
}
