public interface UserToComputerEngine{
    // Allows user to set source for where input integers are read from
    Response setSource(String sourceURL);

    // Allows user to set destination for output of digit factorials
    Response setDestination(String destinationURL);

    // Either uses default delimter of , or for user to choose their own delimeter
    Response setDelimiter(String[] delimiter);

    // Carries out the computation of the digit factorial
    Response executeComputation(Source);
}