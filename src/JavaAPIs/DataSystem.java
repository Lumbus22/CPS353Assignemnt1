import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import org.junit.Test;

public interface DataSystemInterface{
   public String[] storeData(String identifier, String data) {

    }

    public String retrieveData(String identifier){

    }
    
  public String updateData(String identifier, String[] newData) {

    }

  public String deleteData(String identifier) {

    }
}

public class DataSystem implements DataSystemInterface {

  @Test
  @Override
  public String[] storeData(String identifier, String data) {
      String[] returnString = new String[4];
      data = "Hello";
     
     //Saves data to output.txt
      try{

        BufferedWriter writer = new BufferedWriter(new FileWriter("dataStorage\\output.txt"));

        writer.write(data + "\nNew Line");
        writer.close();

        System.out.println(data + ", Was wirtten to file output.txt");

      }catch(IOException e){
        e.printStackTrace();
      }
        //Send to data storage system
        return returnString;

    }

    @Override
    public String retrieveData(String identifier){
        // Retrieve data
        return identifier;//RetrievedData;
    }
    
  @Override
  public String updateData(String identifier, String[] newData) {
        //Updates the current data
        return identifier;
    }

    // Delete data
  @Override
  public String deleteData(String identifier) {
        //Returns the deleted data
        return identifier;
    }
}

