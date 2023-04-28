package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.StorePage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class StoreTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	StorePage storepg;
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
		storepg = homepg.navigateToStorePage();
	}

	@Test(priority = 1, enabled = true)

	public void validateElementsonAddProduct() {
		storepg.clickOnAddStoreButton();
		waitutil.waitForElementToBeClickable(driver, storepg.storeName, 20);
		soft.assertTrue(storepg.isStoreNameDisplayed(), "Failure Message: StoreName is not displayed");
		soft.assertTrue(storepg.isStoreEmailDisplayed(), "Failure Message: StoreEmail is not displayed");
		soft.assertTrue(storepg.isStorePhoneDisplayed(), "Failure Message: Storephone is not displayed");
		soft.assertTrue(storepg.isStoreCountryDisplayed(), "Failure Message: StoreCountry is not displayed");
		soft.assertTrue(storepg.isStoreCityDisplayed(), "Failure Message: StoreCity is not displayed");
		soft.assertTrue(storepg.isStoreAddressDisplayed(), "Failure Message: StoreAddress is not displayed");
		soft.assertTrue(storepg.isStoreCustomFooterDisplayed(), "Failure Message: StoreCustomFoote is not displayed");
		storepg.clickOnCloseStoreButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void validateAddDatasToStore() throws IOException {
		String storenm = excelutil.readStringData("Stores", 2, 1);
		String storeemail = excelutil.readStringData("Stores", 2, 2);
		String storephone = excelutil.readStringData("Stores", 2, 3);
		String storecountry = excelutil.readStringData("Stores", 2, 4);
		String storecity = excelutil.readStringData("Stores", 2, 5);
		String storeaddress = excelutil.readStringData("Stores", 2, 6);
		String storecustom = excelutil.readStringData("Stores", 2, 7);
		storepg.clickOnAddStoreButton();
		storepg.clickOnStoreName();
		storepg.enterValueToStoreName(storenm);
		storepg.enterValueToStoreEmailID(storeemail);
		storepg.enterValueToStorePhoneNumber(storephone);
		storepg.enterValueToStoreCountryr(storecountry);
		storepg.enterValueToStoreCity(storecity);
		storepg.enterValueToStoreAddress(storeaddress);
		storepg.enterValueToStoreCustom(storecustom);
		storepg.submitStoreValues();
		storepg.searchStoreLink(storephone);
		soft.assertEquals(storepg.getStoreNameFromSearchResults(), "SNStores",
				"Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(), "miraj@gmail.com",
				"Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(), "345487643",
				"Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(), "India",
				"Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(), "TVM", "Failure Message: Store City is not matched");
		soft.assertAll();
	}
	@Test(priority = 4, enabled = true)
	public void validateDeleteStoreDatas() {
		storepg.searchStoreLink("booster");
		storepg.deleteStoreDetails();
		storepg.searchStoreLink("booste");
		Assert.assertEquals(storepg.getStoreNameFromSearchResults(), "No matching records found",
				"Failure Message: Store Name is not matched");
	}
	@Test(priority = 3, enabled = true)
	public void validateEditStoreDetails() {
		storepg.searchStoreLink("BCD");
		storepg.editStoreDetails();
		storepg.enterValueToStoreName("ANSStores");
		storepg.enterValueToStoreEmailID("shibis@gmail.com");
		storepg.enterValueToStorePhoneNumber("8876552872");
		storepg.enterValueToStoreCountryr("INDIA");
		storepg.enterValueToStoreCity("Kollam");
		storepg.enterValueToStoreAddress("SN manzil");
		storepg.enterValueToStoreCustom("HiaAll");
		storepg.submitEditDetails();
		storepg.searchStoreLink("8876552872");
		soft.assertEquals(storepg.getStoreNameFromSearchResults(), "ANSStores",
				"Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(), "shibis@gmail.com",
				"Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(), "8876552872",
				"Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(), "INDIA",
				"Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(), "Kollam",
				"Failure Message: Store City is not matched");
		soft.assertAll();
	}

}
