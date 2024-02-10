package test;

public class TestDataSystem {
    @Test
    public void DataSystemTest(){
        String result = new DataSystem().deleteData("String");
        assert result == null;
    }


}