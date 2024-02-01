public interface UserToComputerEngine{
    // Allows user to set source and destination for where input integers are read from and where output is saved to
    Response setSourceAndDest(String sourceURL, String destinationURL);

    // Carries out the computation of the digit factorial, with or without default delimiter
    Response exCompDefaultDelim(Source);
    Response exCompCustomDelim(String delim, Source);
}
