
public interface DataSystemInterface {
    // Store data
    String[] writeToFile(String identifier, long[][] data);

    // Retrieve data
    String readFromFile(String identifier);

    // Update existing data
    String updateData(String identifier, String[] newData);

    // Delete data
    String deleteData(String identifier);
}
