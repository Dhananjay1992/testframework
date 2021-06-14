package com.jsl.qa.automation.djframework.core.errors;

import javax.management.RuntimeErrorException;

public class WebDriverInitializationError extends Error {
    public static final String DEFAULT_MESSAGE = "Error occurred during initialization of web driver";

    public WebDriverInitializationError() {
        this(DEFAULT_MESSAGE);
    }

    public WebDriverInitializationError(String message) {
        super(message);

    }


}
