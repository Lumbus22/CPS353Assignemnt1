import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class TestDataSystem {

    @Test
    public void testWriteToFile() throws IOException {
        DataSystem dataSystem = new DataSystem();
        String identifier = "testIdentifier";
        String text = "Hello, World!";

        // Call the method in DataSystem that writes text to a file
        dataSystem.writeToFile(identifier, text);

        // The file path where DataSystem writes the file
        String filePath = "dataStorage\\output.txt";

        // Check that the file now exists


        File file = new File(filePath);
        System.out.println("Expected file path: " + file.getPath());
        System.out.println("File exists: " + file.exists());
        assertTrue(file.exists());

        // Check that the file contains the expected text
        String content = new String(Files.readAllBytes(Paths.get(filePath)));
        assertTrue(content.contains(text + "\nNew Line"));
    }
}