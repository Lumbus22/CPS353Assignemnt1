import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.io.IOException;

public class TestComputation {

    private ComputationImpl computation;

    @BeforeEach
    public void setUp() {
        final DataSystem newDataSystem = new DataSystem("test/dataTests/testInput.csv", "test/dataTests/testoutput.csv");
        computation = new ComputationImpl("dummy/path");
        computation.setDataSystem(newDataSystem);
    }

    @Test
    public void testReceiveDataForComputation() throws IOException {
        String[] numberStrings = {"0", "2", "3", "5"};

        String[] result = computation.receiveDataForComputation();

        assertArrayEquals(numberStrings, result);
    }

    @Test
    public void testPerformDigitFactorial() {
        String[] numberStrings = {"1", "2"};
        long[][] expectedResults = {{1, 2}, {1, 2}};

        long[][] results = computation.performDigitFactorial(numberStrings);

        assertNotNull(results);
        assertArrayEquals(expectedResults[0], results[0]);
        assertArrayEquals(expectedResults[1], results[1]);
    }
}
