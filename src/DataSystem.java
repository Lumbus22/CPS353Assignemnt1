public class DataSystem implements DataSystemInterface {

  @Overide
  public Response storeData(String identifier, Data data) {
        //Send to data storage system
        return dataLocationMaybe;

    }

  @Override
  public Response updateData(String identifier, Data newData) {
        //Updates the current data
        return dataLocaiont;
    }

    // Delete data
  @Override
  public Response deleteData(String identifier) {
        //Returns the deleted data
        return deletdData;
    }
}
