package com.jsl.qa.automation.djframework.pom;

import com.jsl.qa.automation.djframework.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeSuite;

@Component
public class BasePomImpl extends AbstractBasePom {
	@Autowired
	public WebDriverFactory webDriverFactory;
	public WebDriver driver;

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public void switchToThis() {

	}

	@Override
	public void close() {

	}

	@Override
	public void maximise() {

	}

	public WebDriver getWebDriver() throws Exception {
		this.driver= webDriverFactory.getWebDriverInstance();
		return this.driver;
	}
}
