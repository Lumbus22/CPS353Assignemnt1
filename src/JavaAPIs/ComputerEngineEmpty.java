import java.io.FileNotFoundException;

public class ComputerEngineEmpty implements ComputerEngineInterface {

    @Override
    public void receiveDataForComputation() throws FileNotFoundException {
        
    }

    @Override
     public long[][] performDigitFactorial() {
        return new long[2][];
    }

}
