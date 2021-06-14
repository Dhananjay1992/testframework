package com.jsl.qa.automation.djframework.tests;

import com.jsl.qa.automation.djframework.core.config.ConfigLoader;
import com.jsl.qa.automation.djframework.core.driver.WebDriverFactory;
import com.jsl.qa.automation.djframework.core.driver.WebDriverHandler;
import com.jsl.qa.automation.djframework.pom.BasePomImpl;

import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class  BaseTests extends AbstractTestNGSpringContextTests {
	@Autowired
	protected ConfigLoader configLoader;
	@Autowired
	protected WebDriverHandler webDriverHandler;
	@Autowired
	protected WebDriverFactory webDriverFactory;
	@Autowired
	protected BasePomImpl basePomImpl;

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseTests.class);


	@BeforeSuite
	@Override
	protected void springTestContextPrepareTestInstance() throws Exception {
		super.springTestContextPrepareTestInstance();
		basePomImpl.getWebDriver();
		LOGGER.info("Before Suite...");
	}


	@AfterSuite
	public void afterSuite() {
		webDriverHandler.killChromeDriverInstances();
		LOGGER.info("After Suite...");
	}

	@Test
	public void testConfigLoader() {
		Assertions.assertNotNull(configLoader);
		Assertions.assertEquals("chrome", configLoader.getTestConfigProperties().getProperty("driver.variant"));
	}

//	@Test
//	public void testDefaultWebDriver() throws InterruptedException {
//		Assertions.assertNotNull(webDriverHandler);
//		webDriverHandler.setWebDriver();
//		Thread.sleep(5000);
//	}

//	@Test
//	public void testWebDriverFactory() throws Exception {
//		WebDriver driver = webDriverFactory.getWebDriverInstance("chrome");
//		driver.get("https://jsoftwarelabs.com");
//		Assertions.assertEquals("Welcome to JSoftwareLabs", driver.getTitle());
//	}

}
