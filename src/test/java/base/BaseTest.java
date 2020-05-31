package base;

import suite.HttpRequestWrapper;

public abstract class BaseTest<T, R> {

    protected R callToService(T request) {
        requestWrapper(request); // use this
        System.out.println("calling the service...");
        return null;
    }

    // same at application layer
    protected abstract String poolName();

    // changes per request to service
    protected abstract HttpRequestWrapper requestWrapper(T request);
}