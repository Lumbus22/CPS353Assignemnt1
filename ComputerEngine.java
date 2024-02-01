public interface ComputerEngine {

  //* Reading, Writing, and Initialization Component *//  

  // initialize a computation to be performed
  Request initializeComputation(ComputationParameters parameters);
  // Recieve data from user
  Request fromUserData(int[] dataString);
  // Send data to computation component
  Response sendDataToCompute(Data data);

  //* Computation Component *//   
    
  // Receive data from reader component
  Data receiveDataForComputation();
  // Manipulate Data
  Request performDigitFactorial();
  // Return data to data manager
  Response returnDigitFactorialToUserInterface(outputURL);
}
public interface Request{
    
}
public interface Response{
    
}
