import java.io.IOException;

public class DataSystemEmpty implements DataSystemInterface{
    
    // Retrieve data
    public void readFromFile() throws IOException{

    }
    
    // Store data
    public void writeToFile(long[][] data, String delimiter) throws IOException{

    }


    // Set output file
    public void setDestination(String destinationFilePath){

    }

    // Update existing data
    public String updateData(String identifier, String[] newData){
        return identifier;
    }

    // Delete data
    public String deleteData(String identifier){
        return identifier;

    }
}
