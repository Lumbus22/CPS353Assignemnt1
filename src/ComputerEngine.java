public interface ComputerEngine {
  Data receiveDataForComputation();

    // Manipulate Data
  Request performDigitFactorial();

    // Return data to data manager
  Response returnDigitFactorial(String outputURL);
}

public class ComputerEngineImpl implements ComputerEngine {

  private DataSystemInterface dataStore;

  @Override
  public Data receiveDataForComputation() {
    return null;
  }

  @Override
  public Request performDigitFactorial() {
    return new Request();
  }

  @Override
  public Response returnDigitFactorial(String outputURL) {
    return new Response();
  }
}
