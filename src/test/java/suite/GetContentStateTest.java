package suite;

import base.BaseTest;
import extension.SimpleExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({SimpleExtension.class})
public class GetContentStateTest extends BaseTest<String, GetContentStateResponse> {

    // P1:: same for a service module
    @Override
    protected String poolName() {
        return "my-service-test";
    }

    @Override
    protected HttpRequestWrapper requestWrapper(String request) {
        return new HttpRequestWrapper();
    }

    // P1 :: data provider for input and validations
    @Test
    public void testActiveContentResponse() {
        GetContentStateResponse stateResponse = callToService("CONTABC");
        Assertions.assertNull(stateResponse);
    }

    @Test
    public void testArchivedContentResponse() {
        GetContentStateResponse stateResponse = callToService("CONTXYZ");
        Assertions.assertNull(stateResponse);
    }
}
