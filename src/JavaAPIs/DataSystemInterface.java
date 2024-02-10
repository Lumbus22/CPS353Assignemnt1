public interface DataSystemInterface {
    // Store data
  Response storeData(String identifier, Data data);

    // Retrieve data
  DataResponse retrieveData(String identifier);

    // Update existing data
  Response updateData(String identifier, Data newData);

    // Delete data
  Response deleteData(String identifier);
}

public class DataSystem implements DataSystemInterface {

  @Overide
  public Response storeData(String identifier, Data data) {
        //Send to data storage system
        return dataLocationMaybe;

    }

    public DataResponse retrieveData(String identifier){
        // Retrieve data
        return RetrievedData;
    }
    
  @Override
  public Response updateData(String identifier, Data newData) {
        //Updates the current data
        return dataLocation;
    }

    // Delete data
  @Override
  public Response deleteData(String identifier) {
        //Returns the deleted data
        return deletedData;
    }
}

