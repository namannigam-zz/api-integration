package extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import static org.junit.jupiter.api.extension.ExtensionContext.Namespace.GLOBAL;

public class SimpleExtension implements BeforeAllCallback, AfterAllCallback,
        ExtensionContext.Store.CloseableResource {

    private static boolean startedTests = false;

    @Override
    public void beforeAll(ExtensionContext context) {
        if (!startedTests) {
            startedTests = true;
            System.out.println("Starting up the server before all tests!");
            context.getRoot().getStore(GLOBAL).put("simple-proxy-extension", this);
        }
    }

    @Override
    public void close() {
        System.out.println("Closing the resources after test!");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("Shutting down the server before all tests!");
    }
}