import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class TestUserToComputerEngine {

    private UserToComputerEngineImpl userToEngine;

    @Before
    public void setUp() {
        userToEngine = new UserToComputerEngineImpl();
    }

    @Test
    public void testSetSourceAndDest() {
        String sourceURL = "http://source.url";
        String destinationURL = "http://destination.url";

        Response response = userToEngine.setSourceAndDest(sourceURL, destinationURL);

        assertNotNull(response);
    }

    @Test
    public void testExCompDefaultDelim() {
        String source = "sourceString";

        Request request = userToEngine.exCompDefaultDelim(source);

        assertNotNull(request);
    }
}
