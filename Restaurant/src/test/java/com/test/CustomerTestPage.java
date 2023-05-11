package com.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.CustomerPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ExcelRead;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
public class CustomerTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	CustomerPage custmpg;
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
		excelutil= new ExcelUtils();
		custmpg = homepg.navigateToCustomerPage();
	}
	@Test(priority = 1, enabled = true)
	public void validateElementsonAddCustomer() {
		custmpg.ClickOnAddButton();
		custmpg.WaitCustomer();
		soft.assertTrue(custmpg.isCustomerNameDisplayed(), "Failure Message: CustomerName is not displayed");
		soft.assertTrue(custmpg.isCustomerEmailDisplayed(), "Failure Message: CustomerEmail is not displayed");
		soft.assertTrue(custmpg.isCustomerPhoneDisplayed(), "Failure Message: Customerphone is not displayed");
		soft.assertTrue(custmpg.isCustomerDiscountDisplayed(), "Failure Message: CustomerDiscount is not displayed");
		custmpg.clickOnCloseCustomerButton();
		soft.assertAll();
	}
	@Test(priority=2,enabled=true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddCustomerDetails() throws Exception {
		String custmrenm=excelutil.readStringData("Customer",2,1);
		String custmrphone=excelutil.readStringData("Customer",2,2);
		String custmremail=excelutil.readStringData("Customer",2,3);
		String custmrdiscnt=excelutil.readStringData("Customer",2,4);
		custmpg.ClickOnAddButton();
		custmpg.clickOnCustomername();
		custmpg.enterValueForCustomerName(custmrenm);
		custmpg.enterValueForCustomerPhoneNumber(custmrphone);
		custmpg.enterValueForCustomerMail(custmremail);
		custmpg.enterValueForCustomerDiscount(custmrdiscnt);
		custmpg.ClickSubmitCustomerDetails();
		custmpg.SearchDetails(custmrenm);
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(), custmrenm,
				"Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(), custmrphone,
				"Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(), custmremail,
				"Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(),custmrdiscnt,
				"Failure message : Customer discount not matched");
		soft.assertAll();
	}
	@Test(priority=4,enabled=true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteCustomerData() throws IOException {
		String custDlt= excelutil.readStringData("Customer",3,1);
		custmpg.SearchDetails(custDlt);
		custmpg.clickDeleteCustomerDataButton();
		custmpg.SearchDetails(custDlt);
		Assert.assertEquals(custmpg.getCustomerNameFromSearchResult(),AutomationConstants.ErrorMessage,
				"Failure message : custmer name not matched");
	}
	@Test(priority=3,enabled=true)
	public void validateEditButtonForCustomer() {
		String custEdit=excelutil.readStringData("Customer",2,1);
		String custmrenm=excelutil.readStringData("Customer",3,1);
		String custmrphone=excelutil.readStringData("Customer",3,2);
		String custmremail=excelutil.readStringData("Customer",3,3);
		String custmrdiscnt=excelutil.readStringData("Customer",3,4);
		custmpg.SearchDetails(custEdit);
		custmpg.clickEditCustomerDataButton();
		custmpg.enterValueForCustomerName(custmrenm);
		custmpg.enterValueForCustomerPhoneNumber(custmrphone);
		custmpg.enterValueForCustomerMail(custmremail);
		custmpg.enterValueForCustomerDiscount(custmrdiscnt);
		custmpg.clickSubmitEditCustmrDetails();
		custmpg.SearchDetails(custmrenm);
		soft.assertEquals(custmpg.getCustomerNameFromSearchResult(), custmrenm,
				"Failure message : Customer name not matched");
		soft.assertEquals(custmpg.getCustomerPhoneNumberFromSearchResult(),custmrphone,
				"Failure message : Customer phone not matched");
		soft.assertEquals(custmpg.getCustomerEmailidFromSearchResult(), custmremail,
				"Failure message : Customer mail not matched");
		soft.assertEquals(custmpg.getCustomerDiscountFromSearchResult(), custmrdiscnt,
				"Failure message : Customer discount not matched");
		soft.assertAll();
	}
}
