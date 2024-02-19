public interface UserToComputerEngineInterface{
// Allows user to set source and destination for where input integers are read from and where output is saved to
  Response setSourceAndDest(SourceInterface sourceInterface);

// Carries out the computation of the digit factorial, with or without default delimiter
  Request exCompDefaultDelim(String source);
  Request exCompCustomDelim(String delim, String source);
}
