package test;

public class TestDataSystem {
    @Test
    public void dataSystemTest(){
        String result = new DataSystem().deleteData("String");
        assert result == null;
    }

}