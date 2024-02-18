import org.junit.Test;


public class TestDataSystem {
    @Test
    public void dataSystemTest(){
        String[] result = new DataSystem().storeData("String", "MY DATA");
        assert result == null;
    }

}