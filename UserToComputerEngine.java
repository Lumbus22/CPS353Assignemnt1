public interface UserToComputerEngine{
    // Allows user to set source and destination for where input integers are read from and where output is saved to
    Response setSourceAndDest(String sourceURL, String destinationURL);

    // Carries out the computation of the digit factorial, with or without default delimiter
    Request exCompDefaultDelim(String source);
    Request exCompCustomDelim(String delim, String source);
}

public interface Request{

}

public interface Response{

}
