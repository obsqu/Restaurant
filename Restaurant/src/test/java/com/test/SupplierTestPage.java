package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.CommonDatas;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.pages.SupplierPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.RandomNumbers;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class SupplierTestPage extends AutomationBase {

	LoginPage loginpg;
	HomePage homepg;
	SupplierPage splrpg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	Properties allProp;
	ExcelUtils excelutil = new ExcelUtils();
	RandomNumbers random = new RandomNumbers();
	
	@Test(priority = 1, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsonAddSupplier() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		splrpg = homepg.navigateToSupplierPage();
		splrpg.ClickOnAddButton();
		splrpg.waitSupplier();
		soft.assertTrue(splrpg.isSupplierNameDisplayed(), "Failure Message: SupplierName is not displayed");
		soft.assertTrue(splrpg.isSupplierEmailDisplayed(), "Failure Message: SupplierEmail is not displayed");
		soft.assertTrue(splrpg.isSupplierPhoneDisplayed(), "Failure Message: Supplierphone is not displayed");
		soft.assertTrue(splrpg.isSupplierNoteDisplayed(), "Failure Message: SupplierNote is not displayed");
		splrpg.clickOnCloseSupplierButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddSupplierDetails() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		splrpg = homepg.navigateToSupplierPage();
		String suplrnm = random.generateAlphabeticData(8);
		String suplrphone = random.generateNumericData(10);
		String suplremail = excelutil.readStringData("Supplier", 2, 3);
		String suplrnote = random.generateAlphabeticData(15);
		splrpg.ClickOnAddButton();
		splrpg.clickOnSupplierName();
		splrpg.waitSupplier();
		splrpg.enterSupplierName(suplrnm);
		splrpg.enterSupplierPhone(suplrphone);
		splrpg.enterSupplierMail(suplremail);
		splrpg.enterSupplierNote(suplrnote);
		splrpg.ClickOnSubmitDatas();
		splrpg.ClickOnSearchDetails(suplrnm);
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(), suplrnm,
				"Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(), suplrphone,
				"Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(), suplremail,
				"Failure message : suplier mail not matched");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteSupplierData() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		splrpg = homepg.navigateToSupplierPage();
		String suplrDlt = excelutil.readStringData("Supplier", 5, 1);
		splrpg.ClickOnSearchDetails(suplrDlt);
		splrpg.clickDeleteSuplirDataButton();
		splrpg.ClickOnSearchDetails(suplrDlt);
		Assert.assertEquals(splrpg.getSuplierNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : Supplier name not matched");
	}

	@Test(priority = 3, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditButtonForSuppplier() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		splrpg = homepg.navigateToSupplierPage();
		String suplrEdt = excelutil.readStringData("Supplier", 4, 1);
		String suplrnm = random.generateAlphabeticData(8);
		String suplrphone = random.generateNumericData(10);
		String suplremail = excelutil.readStringData("Supplier", 3, 3);
		String suplrnote = random.generateAlphabeticData(15);
		splrpg.ClickOnSearchDetails(suplrEdt);
		splrpg.clickEditSuplirDataButton();
		splrpg.enterSupplierName(suplrnm);
		splrpg.enterSupplierPhone(suplrphone);
		splrpg.enterSupplierMail(suplremail);
		splrpg.enterSupplierNote(suplrnote);
		splrpg.clickEditSubmitBtn();
		splrpg.ClickOnSearchDetails(suplrnm);
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(), suplrnm,
				"Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(), suplrphone,
				"Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(), suplremail,
				"Failure message : suplier mail not matched");
		soft.assertAll();
	}

}
