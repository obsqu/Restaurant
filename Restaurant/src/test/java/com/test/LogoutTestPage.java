package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CommonDatas;

import com.pages.HomePage;
import com.pages.LogOutPage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class LogoutTestPage extends AutomationBase{

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	LogOutPage logoutpg;
	BrowserUtils brwsrUtil=new BrowserUtils();
	WebElementUtils elementutil=new WebElementUtils();
	PropertyUtil property=new PropertyUtil();
	
	
	@BeforeMethod
	public void preRun() throws IOException
	{
		
       driver=getDriver();
		
		Properties allProp=property.getAllProperties("config.properties");
		String site=allProp.getProperty("url");
		brwsrUtil.launchUrl(driver,site);
		//waitutil.implicitWait(driver,30);
		
		loginpg=new LoginPage(driver);
		homepg=new HomePage(driver);
		logoutpg=homepg.navigateToLogoutPage();
		
			
	}
	@Test(priority=1,enabled=true)
	public void validateLogOutPage() {
		logoutpg.clickOnLogOutButton();
		Assert.assertTrue(logoutpg.isLoginButtonDisplayed(),"Failure Message: Logout failed");
	}
}
