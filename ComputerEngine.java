interface ComputerEngine{
    // Recieve data from user
    response fromUserData(int[] dataString);

    // Maipulate Data
    response performDigitFactorial();

    // Return data to data manager
    response returnDigitFactorialToUserInterface(outputURL);
}