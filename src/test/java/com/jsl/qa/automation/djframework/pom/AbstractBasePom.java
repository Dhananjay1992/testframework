package com.jsl.qa.automation.djframework.pom;

import com.jsl.qa.automation.djframework.core.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractBasePom {
	/* Abstract methods should be implemented by each POM class
	 *
	 * */
	public abstract String getTitle();

	public abstract void switchToThis();

	public abstract void close();

	public abstract void maximise();

}
