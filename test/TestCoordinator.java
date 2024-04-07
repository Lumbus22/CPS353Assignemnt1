import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

 public class TestCoordinator {

     @Test
     public void testSetSource() {
         DataSystem mockDataSystem = Mockito.mock(DataSystem.class);
         CoordinatorImpl coordinator = new CoordinatorImpl(mockDataSystem);
         String expectedSourceFilePath = "test/dataTests/testInput.csv";

         String actualSourceFilePath = coordinator.setSource(expectedSourceFilePath);

         Assert.assertEquals(expectedSourceFilePath, actualSourceFilePath);
     }
}
