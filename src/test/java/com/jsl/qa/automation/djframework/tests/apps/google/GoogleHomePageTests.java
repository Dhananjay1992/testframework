package com.jsl.qa.automation.djframework.tests.apps.google;

import com.jsl.qa.automation.djframework.pom.ip.GoogleHomePage;
import com.jsl.qa.automation.djframework.tests.BaseTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
@SpringBootTest
public class GoogleHomePageTests extends BaseTests {
	private static final Logger LOGGER = LoggerFactory.getLogger(GoogleHomePageTests.class);
	@BeforeClass
	public void beforeClass(){
		LOGGER.info("Before TestGoogleHomePage class ");
	}
	@AfterClass
	public void afterClass(){
		LOGGER.info("After TestGoogleHomePage class ");
	}
	@Autowired
	GoogleHomePage googleHomePage;
	@Test
	public void testHomePage() throws Exception {
		googleHomePage.setDriver(basePomImpl.driver);
		googleHomePage.navigateToHomePage();
		System.out.println(googleHomePage.getTitle());
	}

}
