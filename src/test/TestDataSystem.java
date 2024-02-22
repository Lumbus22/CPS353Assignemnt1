import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TestDataSystem {
    @Test
    public void testGetSystemProperty() {
        assertEquals("11.0.12", System.getProperty("java.version"));
        
    }
    @Test
    public void testDataSystem(){
        DataSystem dataSystem = new DataSystem("\\src\\test\\inputTests\\inputtests.csv", "\\src\\test\\outpputTests\\outputtests.csv");
        assertEquals("\\src\\test\\inputTests\\inputtests.csv", dataSystem.inputFilePath);
        assertEquals("\\src\\test\\outpputTests\\outputtests.csv", dataSystem.outPutFilePath);
    }
}
