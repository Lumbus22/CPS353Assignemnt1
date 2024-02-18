public interface DataSystemInterface {
    // Store data
    String[] storeData(String identifier, String data);

    // Retrieve data
    String retrieveData(String identifier);

    // Update existing data
    String updateData(String identifier, String[] newData);

    // Delete data
    String deleteData(String identifier);
}
