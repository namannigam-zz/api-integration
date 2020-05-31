package suite;

import base.BaseTest;
import extension.SimpleExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({SimpleExtension.class})
public class GetInterestTest extends BaseTest<ContentRequest, GraphResponse> {

    private static final String INTEREST_BASE_URI = "/interests";
    private static final String GET_ALL_INTEREST_URI = "graph";
    private static final String INTEREST_URI_PATTERN = "%s/%s";
    private static final String INTEREST_URI_PAGE_PATTERN = "%s/%s/%s";

    @Override
    protected String poolName() {
        return "my-service-test";
    }

    @Override
    protected HttpRequestWrapper requestWrapper(ContentRequest request) {
        String uri = request == null ?
                String.format(INTEREST_URI_PATTERN, INTEREST_BASE_URI, GET_ALL_INTEREST_URI) :
                String.format(INTEREST_URI_PAGE_PATTERN, INTEREST_BASE_URI, GET_ALL_INTEREST_URI,
                        request.getContentId());
        return new HttpRequestWrapper();
    }


    @Test
    public void testCompleteInterestGraph() {
        Assertions.assertThrows(NullPointerException.class, () -> callToService(null).getInterests());
    }

    @Test
    public void testSpecificInterestPerPage() {
        ContentRequest contentId = new ContentRequest("CONT123");
        Assertions.assertNull(callToService(contentId));
    }
}