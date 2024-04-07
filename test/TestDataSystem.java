import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TestDataSystem {

    @Test
    public void testWriteToFile() throws IOException {
        String testOutputFilePath = "testOutput.txt"; // Specify a path for test output
        String testDelimiter = ",";
        long[][] testData = {{1, 2, 3}, {4, 5, 6}}; // Test data to write

        DataSystem dataSystem = new DataSystem(null, testOutputFilePath); // Initialize with null input path as it's not used here
        dataSystem.writeToFile(testData, testDelimiter); // Perform the write operation

        // Now, read from the file and assert the contents
        try (BufferedReader reader = new BufferedReader(new FileReader(testOutputFilePath))) {
            String line = reader.readLine();
            assertEquals("1,2,3", line); // Check first line

            line = reader.readLine();
            assertEquals("4,5,6", line); // Check second line
        }

        // Optionally, delete the test file after assertion
        new java.io.File(testOutputFilePath).delete();
    }
}
