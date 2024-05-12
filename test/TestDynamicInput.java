import Implementations.CoordinatorImpl;
import Implementations.DataSystem;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDynamicInput {

    @Test
    public void testStartComputationWithFileInput() throws IOException {
        // Parameters to specify the number of digits and count of numbers
        int digits = 3; // Number of digits in each number
        int count = 10; // Number of numbers to generate

        // File paths setup
        String inputFilePath = "test/dataTests/testInput.csv";
        String outputFilePath = "test/dataTests/testoutput.csv";

        // Clear the file or create it if it doesn't exist, and prepare with random numbers
        try (FileWriter writer = new FileWriter(inputFilePath, false)) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            // Generate random numbers and format them as CSV on a single line
            for (int i = 0; i < count; i++) {
                long number = (long) (random.nextDouble() * (Math.pow(10, digits) - Math.pow(10, digits - 1)) + Math.pow(10, digits - 1));
                sb.append(number);
                if (i < count - 1) {
                    sb.append(",");
                }
            }
            writer.write(sb.toString());
        }

        DataSystem testDataSystem = new DataSystem(inputFilePath, outputFilePath);
        CoordinatorImpl coordinator = new CoordinatorImpl(testDataSystem);
        coordinator.setSource(inputFilePath); // Set source path after initialization

        // Start computation and measure duration
        long startTime = System.nanoTime();
        boolean isSuccess = coordinator.startComputation(outputFilePath);
        long endTime = System.nanoTime();
        assertTrue(isSuccess, "Computation failed or could not write to file.");
        long duration = endTime - startTime;
        assertTrue(duration < 1000000000, "Computation took too long: " + duration + " nanoseconds");
        System.out.println("Computation took " + duration + " nanoseconds.");
    }
}
