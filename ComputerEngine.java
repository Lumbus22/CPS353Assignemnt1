public interface ComputerEngine {

  //* Reading, Writing, and Initialization Component *//  

  // initialize a computation to be performed
  Request initializeComputation(String parameters);
  // Recieve data from user
  Data fromUserData(int[] dataString);
  // Send data to computation component
  Response sendDataToCompute(int[] dataString );

  //* Computation Component *//   
    
  // Receive data from reader component
  Data receiveDataForComputation();
  // Manipulate Data
  Request performDigitFactorial();
  // Return data to data manager
  Response returnDigitFactorialToUserInterface(String outputURL);
}
public interface Request{
    
}
public interface Response{
    
}
