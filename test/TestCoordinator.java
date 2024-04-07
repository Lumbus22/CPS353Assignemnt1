import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

 public class TestCoordinator {

     @Test
     public void testSetSource() {
         // Arrange
         DataSystem mockDataSystem = Mockito.mock(DataSystem.class);
         CoordinatorImpl coordinator = new CoordinatorImpl(mockDataSystem);
         String expectedSourceFilePath = "test/dataTests/testInput.csv";

         // Act
         String actualSourceFilePath = coordinator.setSource(expectedSourceFilePath);

         // Assert
         Assert.assertEquals(expectedSourceFilePath, actualSourceFilePath);
     }
}
