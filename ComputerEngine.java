public interface ComputerEngine {

    //* Reading, Writing, and Initialization Component *//  

    // initialize a computation to be performed
    Response initializeComputation(ComputationParameters parameters);
    // Recieve data from user
    Response fromUserData(int[] dataString);
    // Send data to computation component
    Response sendDataToCompute(Data data);

    //* Computation Component *//   
    
    // Receive data from reader component
    Data receiveDataForComputation();
    // Manipulate Data
    Response performDigitFactorial();
    // Return data to data manager
    Response returnDigitFactorialToUserInterface(outputURL);
}
