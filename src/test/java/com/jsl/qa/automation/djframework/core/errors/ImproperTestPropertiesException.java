package com.jsl.qa.automation.djframework.core.errors;

public class ImproperTestPropertiesException extends Exception {
    public static final String DEFAULT_MESSAGE = "Error while loading test-config.properties file";

    public ImproperTestPropertiesException() {
        this(DEFAULT_MESSAGE);
    }

    public ImproperTestPropertiesException(String message) {
        super(message);
    }
}
