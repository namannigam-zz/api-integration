package older;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import suite.GetContentStateTest;
import suite.GetInterestTest;

import java.io.IOException;

@RunWith(Suite.class)
@Suite.SuiteClasses({GetContentStateTest.class, GetInterestTest.class})
public class ServiceTestSuite {

    @BeforeAll
    public static void setUp() throws IOException {
        System.out.println("Starting up server before the suite!");
    }

    @AfterAll
    public static void tearDown() throws Exception {
        System.out.println("Shutting down simple-proxy after the suite!");
    }
}