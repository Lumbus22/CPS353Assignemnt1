public interface ComputerEngine {
    Data receiveDataForComputation();

    // Manipulate Data
    Request performDigitFactorial(Array array);
}

public class ComputerEngineImpl implements ComputerEngine {

    private DataSystemInterface dataStore;

    @Override
    public Data receiveDataForComputation() {
        return null;
    }

    @Override
    public Request performDigitFactorial(Array array) {
        return new Request();
    }

}
