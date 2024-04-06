import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestDataSystem {

    @Test
    public void testWriteToFile() throws IOException {
        DataSystem dataSystem = new DataSystem(null, null); // Assuming no-arg constructor
        String delimiter = ",";
        long[][] data = {{1, 2}, {3, 4}}; // Example data initialization

        dataSystem.writeToFile(data, delimiter);

        // The file path where DataSystem writes the file
        String filePath = "dataStorage\\output.txt";

        // Check that the file now exists
        File file = new File(filePath);
        assertTrue(file.exists(), "File does not exist: " + file.getPath());

        // Check that the file contains the expected text
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        assertTrue(content.contains(delimiter), "File content does not match expected text.");
    }
}
