

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

//import org.junit.Test;
//import org.junit.*;


public class DataSystem implements DataSystemInterface {

    public static void main(String[] args) {
        long[][] array = new long[2][2];
        DataSystem dataSystem = new DataSystem();
        String[] data = dataSystem.writeToFile("testIdentifier", array);
        System.out.println(data);
        String readData = dataSystem.readFromFile("test");
        System.out.println(readData);
        String updatedData = dataSystem.updateData("test", new String[]{"This is an updated test"});
        System.out.println(updatedData);
        String deletedData = dataSystem.deleteData("test");
        System.out.println(deletedData);
    }
    
  
  @Override
  public String[] writeToFile(String identifier, long[][] data) {

      String[] returnString = new String[4];
  
      // Saves data to output.txt
      try {
          BufferedWriter writer = new BufferedWriter(new FileWriter("dataStorage\\output.txt"));
          writer.write(identifier + "\n");
          for (int i = 0; i < data.length; i++) {
              for (int j = 0; j < data[i].length; j++) {
                  writer.write(data[i][j] + ", ");
              }
              writer.write("\n");
          }
          
          writer.close();
  
          System.out.println(data + ", Was written to file output.txt");
      } catch(IOException e) { 
          e.printStackTrace();
      }
  
      // Send to data storage system
      return returnString;
  }
    
    @Override
    public String readFromFile(String identifier){
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

