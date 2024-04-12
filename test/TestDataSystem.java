import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Implementations.DataSystem;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;


public class TestDataSystem {

    @Test
    public void testWriteToFile() throws IOException {
        String testOutputFilePath = "testOutput.txt";
        String testDelimiter = ",";
        long[][] testData = {{1, 2, 3}, {4, 5, 6}};

        DataSystem dataSystem = new DataSystem(null, testOutputFilePath);
        dataSystem.writeToFile(testData, testDelimiter);

        try (BufferedReader reader = new BufferedReader(new FileReader(testOutputFilePath))) {
            String line = reader.readLine();
            assertEquals("1,2,3", line);

            line = reader.readLine();
            assertEquals("4,5,6", line);
        }

        new java.io.File(testOutputFilePath).delete();
    }
}
