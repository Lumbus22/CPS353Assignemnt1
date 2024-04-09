package Interfaces;

import java.io.IOException;

public interface DataSystemInterface {
    // Retrieve data
    public void readFromFile() throws IOException;
    
    // Store data
    public void writeToFile(long[][] data, String delimiter) throws IOException;

    // Set output file
//    public void setDestination(String destinationFilePath);
//
//    // Update existing data
//    String updateData(String identifier, String[] newData);
//
//    // Delete data
//    String deleteData(String identifier);
}
