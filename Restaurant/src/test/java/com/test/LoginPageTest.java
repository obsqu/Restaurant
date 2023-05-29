package com.test;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.PropertyUtil;

public class LoginPageTest extends AutomationBase {

	LoginPage loginpg;
	HomePage homepg;
	Properties prop;
	PropertyUtil property = new PropertyUtil();

	@Test(priority = 1, enabled = true)
	public void validateLogin() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		prop = property.getAllProperties("config.properties");
		loginpg.performlogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertTrue(homepg.isPosDisplayed(), "Failure : Login failed");
	}

}
