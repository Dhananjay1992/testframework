package com.jsl.qa.automation.djframework.core.driver;

import com.jsl.qa.automation.djframework.core.config.ConfigLoader;
import com.jsl.qa.automation.djframework.core.errors.WebDriverInitializationError;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static com.jsl.qa.automation.djframework.core.driver.DriverHelper.*;
import static java.lang.Runtime.getRuntime;

@Component
public class WebDriverHandler {
    @Autowired
    ConfigLoader configLoader;
    Properties testProperties;
    private WebDriver driver;
    private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverHandler.class);

    public WebDriverHandler() {

    }

    public void setWebDriver() {
        this.killChromeDriverInstances();
        this.setWebDriver(this.defaultChromeOptions());
    }

    public void setWebDriver(ChromeOptions options) {

        try {
            testProperties = configLoader.getTestConfigProperties();
            LOGGER.info("Setting chrome driver...");
            Path path = Paths.get(testProperties.getProperty("driver.options.path"), getChromeDriverExecutableByPlatform());
            System.setProperty("webdriver.chrome.driver", path.toString());
            driver = new ChromeDriver(options);
            LOGGER.info("Chrome driver successfully initiated...");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
            throw new WebDriverInitializationError(e.getMessage());
        }
    }

    public void setWebDriver(FirefoxOptions options) {
        driver = new FirefoxDriver(options);
    }

    public ChromeOptions defaultChromeOptions() {
        Map<String, Object> prefs = new HashMap<String, Object>();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--enable-javascript");
        options.addArguments("start-maximized");
        prefs.put("download.default_directory", "/downloads");
        options.setExperimentalOption("prefs", prefs);
        return options;
    }


    public WebDriverHandler getWebDriverHandler() {
        this.setWebDriver();
        return this;
    }

    public void killChromeDriverInstances()  {
        LOGGER.info("Starting killing of existing chromedriver instances");
        String [] commandArray = new String[]{"", ""};
		switch (getPlatform()) {
			case Windows:
				commandArray[0] = "taskkill /F /IM chromedriver.exe";
				commandArray[1] = "taskkill /F /IM chrome.exe";
				break;
			case MacOS:
				commandArray[0] = "pkill Google Chrome";
				commandArray[1] = "pkill chromedriver_mac_intel";
				break;
			case Linux:
				commandArray[0] = "pkill Google Chrome";
				commandArray[1] = "pkill chromedriver_linux";
				break;
			case Other:
				commandArray[0] = "pkill Google Chrome";
				commandArray[1] = "pkill chromedriver_mac_m1";
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + getPlatform());
		}
		Arrays.asList(commandArray).forEach(this::executeCommand);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void executeCommand(String command){
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    public WebDriver getDriver() {
        return driver;
    }

    public static String getChromeDriverExecutableByPlatform() {
        String executable = "";
        switch (getPlatform()) {
            case Windows:
                executable = "chromedriver.exe";
                break;
            case MacOS:
                executable = "chromedriver_mac_intel";
                break;
            case Linux:
                executable = "chromedriver_linux";
                break;
            case Other:
                executable = "chromedriver_mac_m1";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getPlatform());
        }
        return executable;
    }
}
