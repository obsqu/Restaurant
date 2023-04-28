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
		splrpg = homepg.navigateToSupplierPage();
	}
	@Test(priority = 1, enabled = true)
	public void validateElementsonAddProduct() {
		splrpg.ClickOnAddButton();
		waitutil.waitForElementToBeClickable(driver, splrpg.suplierName, 20);
		soft.assertTrue(splrpg.isSupplierNameDisplayed(), "Failure Message: SupplierName is not displayed");
		soft.assertTrue(splrpg.isSupplierEmailDisplayed(), "Failure Message: SupplierEmail is not displayed");
		soft.assertTrue(splrpg.isSupplierPhoneDisplayed(), "Failure Message: Supplierphone is not displayed");
		soft.assertTrue(splrpg.isSupplierNoteDisplayed(), "Failure Message: SupplierNote is not displayed");
		splrpg.clickOnCloseSupplierButton();
		soft.assertAll();
	}

	@Test(priority = 2, enabled = true)
	public void validateAddSupplierDetails() throws Exception {
		String suplrnm = excelutil.readStringData("Supplier", 2, 1);
		String suplrphone = excelutil.readStringData("Supplier", 2, 2);
		String suplremail = excelutil.readStringData("Supplier", 2, 3);
		String suplrnote = excelutil.readStringData("Supplier", 2, 4);
		splrpg.ClickOnAddButton();
		splrpg.clickOnSupplierName();
		waitutil.waitForElementToBeClickable(driver, splrpg.suplierName, 20);
		splrpg.enterSupplierName(suplrnm);
		waitutil.waitForVisibilityOfElement(driver, splrpg.suplierPhone, 20);
		splrpg.enterSupplierPhone(suplrphone);
		splrpg.enterSupplierMail(suplremail);
		splrpg.enterSupplierNote(suplrnote);
		splrpg.ClickOnSubmitDatas();
		splrpg.ClickOnSearchDetails("Bilal");
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(), "Bilal",
				"Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(), "65830489",
				"Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(), "bilal@gmail.com",
				"Failure message : suplier mail not matched");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		splrpg.ClickOnSearchDetails("Shibina");
		splrpg.clickDeleteSuplirDataButton();
		splrpg.ClickOnSearchDetails("Shibina");
		Assert.assertEquals(splrpg.getSuplierNameFromSearchResult(), "No matching records found",
				"Failure message : Supplier name not matched");
	}

	@Test(priority = 3, enabled = true)
	public void validateEditButtonForWaiter() {
		splrpg.ClickOnSearchDetails("Miraj");
		splrpg.clickEditSuplirDataButton();
		splrpg.enterSupplierName("Shibina");
		splrpg.enterSupplierPhone("9857463523");
		splrpg.enterSupplierMail("shibi@gmail.com");
		splrpg.enterSupplierNote("WEHDYDGCI");
		splrpg.clickEditSubmitBtn();
		splrpg.ClickOnSearchDetails("Shibina");
		soft.assertEquals(splrpg.getSuplierNameFromSearchResult(), "Shibina",
				"Failure message : suplier name not matched");
		soft.assertEquals(splrpg.getSuplierPhoneNumberFromSearchResult(), "9857463523",
				"Failure message : suplier phone not matched");
		soft.assertEquals(splrpg.getSuplierEmailidFromSearchResult(), "shibi@gmail.com",
				"Failure message : suplier mail not matched");
		soft.assertAll();
	}

}
