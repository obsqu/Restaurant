package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.StorePage;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;

public class StoreTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	StorePage storepg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	ExcelUtils excelutil;
	@BeforeMethod
	public void preRun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		storepg = homepg.navigateToStorePage();
		excelutil= new ExcelUtils();
	}
	@Test(priority = 1, enabled = true)
	public void validateElementsonAddStore() {
		storepg.clickOnAddStoreButton();
		storepg.WaitStoreName();
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
		String storenm=excelutil.readStringData("Stores",2,1);
		String storemail=excelutil.readStringData("Stores",2,2);
		String storephone=excelutil.readStringData("Stores",2,3);
		String storecountry=excelutil.readStringData("Stores",2,4);
		String storecity=excelutil.readStringData("Stores",2,5);
		String storeaddress=excelutil.readStringData("Stores",2,6);
		String storecustom=excelutil.readStringData("Stores",2,7);
		storepg.clickOnAddStoreButton();
		storepg.WaitStoreName();
		storepg.enterValueToStoreName(storenm);
		storepg.enterValueToStoreEmailID(storemail);
		storepg.enterValueToStorePhoneNumber(storephone);
		storepg.enterValueToStoreCountryr(storecountry);
		storepg.enterValueToStoreCity(storecity);
		storepg.enterValueToStoreAddress(storeaddress);
		storepg.enterValueToStoreCustom(storecustom);
		storepg.submitStoreValues();
		storepg.searchStoreLink(storephone);
		soft.assertEquals(storepg.getStoreNameFromSearchResults(), storenm,
				"Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(),storemail,
				"Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(),storephone,
				"Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(),storecountry,
				"Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(), storecity, "Failure Message: Store City is not matched");
		soft.assertAll();
	}
	@Test(priority = 4, enabled = true)
	public void validateDeleteStoreDatas() {
		String storeDlt=excelutil.readStringData("Stores",3,1);
		storepg.searchStoreLink(storeDlt);
		storepg.deleteStoreDetails();
		storepg.searchStoreLink(storeDlt);
		Assert.assertEquals(storepg.getStoreNameFromSearchResults(), AutomationConstants.ErrorMessage,
				"Failure Message: Store Name is not matched");
	}
	@Test(priority = 3, enabled = true)
	public void validateEditStoreDetails() {
		String storenmEdt=excelutil.readStringData("Stores",2,1);
		String storenm=excelutil.readStringData("Stores",3,1);
		String storemail=excelutil.readStringData("Stores",3,2);
		String storephone=excelutil.readStringData("Stores",3,3);
		String storecountry=excelutil.readStringData("Stores",3,4);
		String storecity=excelutil.readStringData("Stores",3,5);
		String storeaddress=excelutil.readStringData("Stores",3,6);
		String storecustom=excelutil.readStringData("Stores",3,7);
		storepg.searchStoreLink(storenmEdt);
		storepg.editStoreDetails();
		storepg.enterValueToStoreName(storenm);
		storepg.enterValueToStoreEmailID(storemail);
		storepg.enterValueToStorePhoneNumber(storephone);
		storepg.enterValueToStoreCountryr(storecountry);
		storepg.enterValueToStoreCity(storecity);
		storepg.enterValueToStoreAddress(storeaddress);
		storepg.enterValueToStoreCustom(storecustom);
		storepg.submitEditDetails();
		storepg.searchStoreLink(storephone);
		soft.assertEquals(storepg.getStoreNameFromSearchResults(),storenm,
				"Failure Message: Store Name is not matched");
		soft.assertEquals(storepg.getStoreEmailidFromSearchResults(),storemail,
				"Failure Message: Store emailid is not matched");
		soft.assertEquals(storepg.getStorePhoneNoFromSearchResults(), storephone,
				"Failure Message: Store Phoneno is not matched");
		soft.assertEquals(storepg.getStoreCountryFromSearchResults(),storecountry,
				"Failure Message: Store Country is not matched");
		soft.assertEquals(storepg.getStoreCityFromSearchResults(),storecity,
				"Failure Message: Store City is not matched");
		soft.assertAll();
	}

}
