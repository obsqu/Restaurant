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
import com.pages.CommonDatas;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.WaiterPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class WaiterPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	WaiterPage watrpg;
	BrowserUtils brwsrUtil = new BrowserUtils();
	WebElementUtils elementutil = new WebElementUtils();
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	WaitUtils waitutil = new WaitUtils();
	ExcelUtils excelutil;

	@BeforeMethod
	public void preRun() throws IOException {
		excelutil = new ExcelUtils();
		driver = getDriver();
     	Properties allProp = property.getAllProperties("config.properties");
		String site = allProp.getProperty("url");
		brwsrUtil.launchUrl(driver, site);
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		watrpg = homepg.navigateToWaiterPage();
	}

	@Test(priority = 1, enabled = true)
	public void validateElementsonAddProduct() {
		watrpg.ClickOnAddWaiterButton();
		waitutil.waitForElementToBeClickable(driver, watrpg.waiterName, 20);
		soft.assertTrue(watrpg.isWaiterNameDisplayed(), "Failure Message: WaiterName is not displayed");
		soft.assertTrue(watrpg.isWaiterPhoneDisplayed(), "Failure Message: WaiterPhone is not displayed");
		soft.assertTrue(watrpg.isWaiterEmailDisplayed(), "Failure Message: WaiterEmail is not displayed");
		soft.assertTrue(watrpg.isWaiterStoreDisplayed(), "Failure Message: WaiterStore is not displayed");
		watrpg.ClickOnCloseWaiterButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true, dataProvider = "waiterdatas")
	public void validateAddWaiterDatas(String name, String phone, String mail, String store) throws Exception {
		watrpg.ClickOnAddWaiterButton();
		watrpg.clickOnWaitername();
		waitutil.waitForAnElement(driver, watrpg.waiterName, 10);
		watrpg.enterValueForWaiterName(name);
		waitutil.waitForAnElement(driver, watrpg.waiterPhoneNo, 10);
		watrpg.enterValueForWaiterPhone(phone);
		watrpg.enterValueForWaiterEmailId(mail);
		watrpg.selectValueForWaiterStore(store);
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink("Naseera");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(), "Naseera",
				"Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(), "34636379873",
				"Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(), "naseera@gmail.com",
				"Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(), "MCDS", "Failure message : Waiter name not matched");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = false)
	public void validateDeleteWaiterData() {

		watrpg.searchWaiterLink("shibina");
		watrpg.clickDeleteWaiterDataButton();
		watrpg.searchWaiterLink("shibina");
		Assert.assertEquals(watrpg.getWaiterNameFromSearchResult(), "No matching records found",
				"Failure message : Waiter name not matched");
	}

	@Test(priority = 3, enabled = false)
	public void validateEditButtonForWaiterDetails() {
		watrpg.searchWaiterLink("Miraj");
		watrpg.clickEditWaiterDataButton();
		watrpg.enterValueForWaiterName("shibi");
		watrpg.enterValueForWaiterPhone("84574635");
		watrpg.enterValueForWaiterEmailId("shibi@gmail.com");
		watrpg.selectValueForWaiterStore("MNC");
		watrpg.submitWaiterValues();
		watrpg.searchWaiterLink("shibi");
		soft.assertEquals(watrpg.getWaiterNameFromSearchResult(), "shibi", "Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterPhoneNumberFromSearchResult(), "84574635",
				"Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterEmailidFromSearchResult(), "shibi@gmail.com",
				"Failure message : Waiter name not matched");
		soft.assertEquals(watrpg.getWaiterStoreFromSearchResult(), "MNC", "Failure message : Waiter name not matched");
		soft.assertAll();
	}
	@DataProvider(name = "waiterdatas")
	public Object[][] testdata() {

		Object[][] data = new Object[3][4];
		data[0][0] = "Anas";
		data[0][1] = "9876524256";
		data[0][2] = "anas@gmail.com";
		data[0][3] = "MNC";

		data[1][0] = "naseera";
		data[1][1] = "8326524256";
		data[1][2] = "naseera@gmail.com";
		data[1][3] = "MNC";

		data[2][0] = "shahina";
		data[2][1] = "7624524256";
		data[2][2] = "shahina@gmail.com";
		data[2][3] = "MNC";

		return data;

	}

}
