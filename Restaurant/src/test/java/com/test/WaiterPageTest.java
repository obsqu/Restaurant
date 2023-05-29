package com.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.PropertyUtil;

public class WaiterPageTest extends AutomationBase {

	LoginPage loginpg;
	HomePage homepg;
	WaiterPage watrpg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	Properties allProp;

	@Test(priority = 1, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsonAddWaiter() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		watrpg = homepg.navigateToWaiterPage();
		watrpg.ClickOnAddWaiterButton();
		watrpg.WaitForWaiter();
		soft.assertTrue(watrpg.isWaiterNameDisplayed(), "Failure Message: WaiterName is not displayed");
		soft.assertTrue(watrpg.isWaiterPhoneDisplayed(), "Failure Message: WaiterPhone is not displayed");
		soft.assertTrue(watrpg.isWaiterEmailDisplayed(), "Failure Message: WaiterEmail is not displayed");
		soft.assertTrue(watrpg.isWaiterStoreDisplayed(), "Failure Message: WaiterStore is not displayed");
		watrpg.ClickOnCloseWaiterButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true, dataProvider = "dataWaitersAdd", dataProviderClass = DataWaiter.class,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddWaiterDatas(String name, String phone, String mail, String store) {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		watrpg = homepg.navigateToWaiterPage();
		watrpg.ClickOnAddWaiterButton();
		watrpg.clickOnWaitername();
		watrpg.enterValueForWaiterName(name);
		watrpg.enterValueForWaiterPhone(phone);
		watrpg.enterValueForWaiterEmailId(mail);
		watrpg.selectValueForWaiterStore(store);
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink(name);
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(), name, "Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(), phone,
				"Failure message : Waiter phone not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(), mail, "Failure message : Waiter mail not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(), store, "Failure message : Waiter store not matched");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true,dataProvider = "dataWaiterDelete",dataProviderClass = DataWaiter.class,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteWaiterData(String dltnm) {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		watrpg = homepg.navigateToWaiterPage();
		watrpg.searchWaiterLink(dltnm);
		watrpg.clickDeleteWaiterDataButton();
		watrpg.searchWaiterLink(dltnm);
		Assert.assertEquals(watrpg.getWaiterNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : Waiter name not matched");
	}

	@Test(priority = 3, enabled = true, dataProvider = "dataWaitersEdit", dataProviderClass = DataWaiter.class,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditButtonForWaiterDetails(String name, String phone, String mail,String store) {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		watrpg = homepg.navigateToWaiterPage();
		watrpg.searchWaiterLink(name);
		watrpg.clickEditWaiterDataButton();
		watrpg.enterValueForWaiterPhone(phone);
		watrpg.enterValueForWaiterEmailId(mail);
		watrpg.selectValueForWaiterStore(store);
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink(name);
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(), name, "Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(), phone,
				"Failure message : Waiter phone not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(), mail, "Failure message : Waiter mail not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(), store, "Failure message : Waiter store not matched");
		soft.assertAll();
	}

}
