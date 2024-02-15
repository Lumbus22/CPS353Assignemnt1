public interface ComputerEngine {
    Data receiveDataForComputation();

    // Manipulate Data
    Request performDigitFactorial(String filePath);
}

public class ComputerEngineImpl implements ComputerEngine {

    private DataSystemInterface dataStore;

    @Override
    public Data receiveDataForComputation() {
        return null;
    }

    @Override
    public Request performDigitFactorial(String filePath) {
        return new Request();
    }

}
