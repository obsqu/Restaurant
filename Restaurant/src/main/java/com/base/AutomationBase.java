package com.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.constants.AutomationConstants;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.PropertyUtil;

public class AutomationBase {
	static WebDriver driver;
	BrowserUtils brwsrUtil= new BrowserUtils();
	LoginPage loginpg;
	PropertyUtil property;
	Properties allProp;

	@BeforeTest
	@Parameters("browserName")
	public void preLaunch(@Optional("chrome")String browserName)  {
		launchBrowser(browserName);
		loginpg = new LoginPage(driver); 
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		brwsrUtil.launchUrl(driver, allProp.getProperty("url"));
	}
	public void launchBrowser(String browserName) {
		switch (browserName) {
		case "chrome":
			launchChromeBrowser();
			break;
		case "edge":
			launchEdgeBrowser();
			break;
		case "firefox":
			launchFireFoxBrowser();
			break;
		default:
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}
	private void launchChromeBrowser() {
		try {
			driver = new ChromeDriver();
			brwsrUtil.maximizeWindow(driver);
		} catch (Exception e) {
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}
	private void launchEdgeBrowser() {
		try {
			driver = new EdgeDriver();
			brwsrUtil.maximizeWindow(driver);
		} catch (Exception e) {
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}
	private void launchFireFoxBrowser() {
		try {
			driver = new FirefoxDriver();
			brwsrUtil.maximizeWindow(driver);
		} catch (Exception e) {
			throw new RuntimeException(AutomationConstants.browserNameCheck);
		}
	}
	public static WebDriver getDriver() {

		return driver;
	}
}
