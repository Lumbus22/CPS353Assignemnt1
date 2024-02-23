import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.io.IOException;

public class TestDataSystem {
    @Test
    public void testGetSystemProperty() {
        assertEquals("11.0.12", System.getProperty("java.version"));
        
    }
    @Test
    public void testDataSystemConstructor(){
        DataSystem dataSystem = new DataSystem("\\src\\test\\inputTests\\inputtests.csv", "\\src\\test\\outpputTests\\outputtests.csv");
        assertEquals("\\src\\test\\inputTests\\inputtests.csv", dataSystem.inputFilePath);
        assertEquals("\\src\\test\\outpputTests\\outputtests.csv", dataSystem.outPutFilePath);
    }
    /* Furture testing class to  work on
    @Test
    public void testInputAndOuput(){
        
        DataSystem dataSystem = new DataSystem("/src/test/dataTests/tests.csv", "/src/test/dataTests/tests.csv");
        
        try {
            dataSystem.readFromFile(); // Ensure data is read before access
        } catch (IOException e) {
            // Handle the exception here
            e.printStackTrace();
        }

        long[][] testArray = {{1,2,3},{}};
        String[] numberStrings;
        
        numberStrings = dataSystem.getNumberStrings();

        

        //Writes the testArray to the output file
        try {
            dataSystem.writeToFile(testArray, ",");
        } catch (IOException e) {
            // Handle the exception here
            e.printStackTrace();
        }

        // Convert numberStrings array to 2D long array
        long[][] numberArray = new long[numberStrings.length][];
        for (int i = 0; i < numberStrings.length; i++) {
            String[] numbers = numberStrings[i].split(",");
            numberArray[i] = new long[numbers.length];
            for (int j = 0; j < numbers.length; j++) {
                numberArray[i][j] = Long.parseLong(numbers[j]);
            }
        }
        
        //Asserts the output file has the correct content
        assertEquals(long[][].class, numberArray);


    }
*/
}
