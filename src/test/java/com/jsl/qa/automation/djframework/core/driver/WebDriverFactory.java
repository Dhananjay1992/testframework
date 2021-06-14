package com.jsl.qa.automation.djframework.core.driver;

import com.jsl.qa.automation.djframework.core.config.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WebDriverFactory {
	@Autowired
	public ConfigLoader configLoader;
	@Autowired
	public WebDriverHandler webDriverHandler;
	private WebDriver driver;
	private ChromeOptions chromeOptions;
	private FirefoxOptions firefoxOptions;
	private static final Logger LOGGER = LoggerFactory.getLogger(WebDriverFactory.class);


	public WebDriver getWebDriverInstance(String driverVariant) throws Exception {
		if (driver == null) {
			synchronized (this) {
				if (driver == null) {
					switch (driverVariant.toLowerCase()) {
						case "chrome":
							chromeOptions = getChromeOptions();
							webDriverHandler.setWebDriver(chromeOptions);
							driver = webDriverHandler.getDriver();
							break;
						case "firefox":
							firefoxOptions = getFirefoxOptions();
							webDriverHandler.setWebDriver(firefoxOptions);
							driver = webDriverHandler.getDriver();
							break;
						default:
							webDriverHandler.killChromeDriverInstances();
							chromeOptions = getChromeOptions();
							webDriverHandler.setWebDriver(chromeOptions);
							driver = webDriverHandler.getDriver();

							break;
					}
				}
			}
		}

		return driver;
	}

	public WebDriver getWebDriverInstance() throws Exception {
		if (driver == null) {
			synchronized (this) {
				if (driver == null) {
					webDriverHandler.killChromeDriverInstances();
					chromeOptions = getChromeOptions();
					webDriverHandler.setWebDriver(chromeOptions);
					driver = webDriverHandler.getDriver();


				}
			}
		}
		return driver;
	}

	public ChromeOptions getChromeOptions() throws Exception {

		Map<String, Object> prefs = new HashMap<String, Object>();
		chromeOptions = new ChromeOptions();
		try {
			boolean startMaximised = Boolean.getBoolean(configLoader.getTestConfigProperties().getProperty("driver.options.start-maximized", "false"));
			boolean enableJavascript = Boolean.getBoolean(configLoader.getTestConfigProperties().getProperty("driver.options.enable-javascript", "false"));
			String downloadPath = configLoader.getTestConfigProperties().getProperty("driver.options.download.default_directory", "/downloads");
			if (startMaximised) chromeOptions.addArguments("start-maximized");
			if (enableJavascript) chromeOptions.addArguments("--enable-javascript");
			prefs.put("download.default_directory", downloadPath);
			chromeOptions.setExperimentalOption("prefs", prefs);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception("Unable to set Chrome options with given parameters");
		}
		return chromeOptions;
	}

	public FirefoxOptions getFirefoxOptions() throws Exception {

		Map<String, Object> prefs = new HashMap<String, Object>();
		firefoxOptions = new FirefoxOptions();
		try {
			boolean startMaximised = Boolean.getBoolean(this.configLoader.getTestConfigProperties().getProperty("driver.options.start-maximized", "false"));
			boolean enableJavascript = Boolean.getBoolean(configLoader.getTestConfigProperties().getProperty("driver.options.enable-javascript", "false"));
			String downloadPath = configLoader.getTestConfigProperties().getProperty("driver.options.download.default_directory", "/downloads");
			if (startMaximised) firefoxOptions.addArguments("start-maximized");
			if (enableJavascript) firefoxOptions.addArguments("--enable-javascript");
			prefs.put("download.default_directory", downloadPath);
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			throw new Exception("Unable to set Firefox options with given parameters");
		}
		return firefoxOptions;
	}
}
