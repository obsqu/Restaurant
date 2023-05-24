package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;
import com.utilities.WebElementUtils;

public class LoginPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	Properties prop;
	PropertyUtil property;

	@Test(priority = 1, enabled = true, retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateLogin() {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		prop = property.getAllProperties("config.properties");
		loginpg.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.isPosDisplayed(), "Failure : Login failed");
	}

}
