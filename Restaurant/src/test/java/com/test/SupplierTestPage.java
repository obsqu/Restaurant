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
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class SupplierTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	SupplierPage splrpg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	Properties allProp;
	ExcelUtils excelutil;
	@BeforeMethod
	public void preRun() {
		excelutil = new ExcelUtils();
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		try {
			allProp = property.getAllProperties("config.properties");
		} catch (IOException e) {
			throw new RuntimeException(AutomationConstants.propertyFileCheck);
		}
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		splrpg = homepg.navigateToSupplierPage();
	}
	@Test(priority = 1, enabled = true)
	public void validateElementsonAddSupplier() {
		splrpg.ClickOnAddButton();
		splrpg.waitSupplier();
		soft.assertTrue(splrpg.isSupplierNameDisplayed(), "Failure Message: SupplierName is not displayed");
		soft.assertTrue(splrpg.isSupplierEmailDisplayed(), "Failure Message: SupplierEmail is not displayed");
		soft.assertTrue(splrpg.isSupplierPhoneDisplayed(), "Failure Message: Supplierphone is not displayed");
		soft.assertTrue(splrpg.isSupplierNoteDisplayed(), "Failure Message: SupplierNote is not displayed");
		splrpg.clickOnCloseSupplierButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void validateAddSupplierDetails() {
		String suplrnm = excelutil.readStringData("Supplier", 2, 1);
		String suplrphone = excelutil.readStringData("Supplier", 2, 2);
		String suplremail = excelutil.readStringData("Supplier", 2, 3);
		String suplrnote = excelutil.readStringData("Supplier", 2, 4);
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

	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		String suplrDlt = excelutil.readStringData("Supplier", 3, 1);
		splrpg.ClickOnSearchDetails(suplrDlt);
		splrpg.clickDeleteSuplirDataButton();
		splrpg.ClickOnSearchDetails(suplrDlt);
		Assert.assertEquals(splrpg.getSuplierNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : Supplier name not matched");
	}

	@Test(priority = 3, enabled = true)
	public void validateEditButtonForWaiter() {
		String suplrEdt = excelutil.readStringData("Supplier", 2, 1);
		String suplrnm = excelutil.readStringData("Supplier", 3, 1);
		String suplrphone = excelutil.readStringData("Supplier",3, 2);
		String suplremail = excelutil.readStringData("Supplier", 3, 3);
		String suplrnote = excelutil.readStringData("Supplier", 3, 4);
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
