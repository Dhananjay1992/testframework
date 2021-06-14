package com.jsl.qa.automation.djframework.pom.ip;

import com.jsl.qa.automation.djframework.core.driver.WebDriverFactory;
import com.jsl.qa.automation.djframework.pom.AbstractBasePom;
import com.jsl.qa.automation.djframework.pom.BasePomImpl;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.annotations.BeforeClass;

@Component
public class GoogleHomePage extends BasePomImpl {

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public GoogleHomePage() throws Exception {

	}
	public void navigateToHomePage(){
		driver.get("https://www.google.com");
	}
	@Override
	public String getTitle() {
		return driver.getTitle();
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
}
