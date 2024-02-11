import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DataSystemIntegrationTest {

    @Test
    void testDataSystemIntegration() {
        // initialize input and output 
        InputConfig inputConfig = new InputConfig();
        inputConfig.setInputSource(List.of(145, 40585)); // example input data
        
        OutputConfig outputConfig = new OutputConfig();
        
        DataSystem dataSystem = new DataSystem();
        
        // Store data using the DataSystem
        Response storeResponse = dataSystem.storeData("testIdentifier", new Data(inputConfig.getInputData()));
        assertNotNull(storeResponse, "Store data response should not be null");
        
        // retrieve the dta and verify
        DataResponse retrieveResponse = dataSystem.retrieveData("testIdentifier");
        assertNotNull(retrieveResponse); //retrieve data response should not be null
        assertEquals(List.of(145, 40585), retrieveResponse.getData().getInputData(), "Retrieved data should match stored data");
        
        // Update the data and verfy
        dataSystem.updateData("testIdentifier", new Data(List.of(123, 456)));
        DataResponse updatedResponse = dataSystem.retrieveData("testIdentifier");
        assertEquals(List.of(123, 456), updatedResponse.getData().getInputData(), "Updated data should match");
        
        // delete the data and verify
        Response deleteResponse = dataSystem.deleteData("testIdentifier");
        assertNotNull(deleteResponse, "Delete response should not be null");
        
        // Attempt to retrieve deleted data and verfy it's no longer available
        DataResponse deletedDataResponse = dataSystem.retrieveData("testIdentifier");
        assertNull(deletedDataResponse.getData()); //Data should be null
    }
}
