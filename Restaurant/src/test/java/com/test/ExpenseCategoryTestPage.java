package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.constants.AutomationConstants;import com.pages.ExpenseCategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseCategoryTestPage extends AutomationBase {

	LoginPage loginpg;
	HomePage homepg;
	ExpenseCategoryPage expnsctgry;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	ExcelUtils excelutil = new ExcelUtils();

	@Test(priority = 1, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void ValidateTheMenuItemsDisplayedAddExpensePage() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.waitForCategory();
		boolean flagdt = expnsctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt, "Fail: CategoryName field is not displayed");
		expnsctgry.ClickOnCloseButton();
	}
	@Test(priority = 2, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddExpenseCategoryDetails() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.ClickOnCategoryName();
		String expctgry = excelutil.readStringData("ExpenseCategory", 2, 1);
		expnsctgry.enterValueForCategryName(expctgry);
		expnsctgry.ClickOnSubmitCategoryValues();
		expnsctgry.ClickOnSearchCategoryLink(expctgry);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), expctgry,
				"Failure message : category name not matched");
	}
	@Test(priority = 3, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditButtonForCategoryDetails()  {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		String expctryEdit = excelutil.readStringData("ExpenseCategory", 2, 1);
		String expctgry = excelutil.readStringData("ExpenseCategory", 3,1);
		expnsctgry.ClickOnSearchCategoryLink(expctryEdit);
		expnsctgry.ClickOnCategoryEditButton();
		expnsctgry.enterValueForCategryName(expctgry);
		expnsctgry.ClickOnSubmitEditButton();
		expnsctgry.ClickOnSearchCategoryLink(expctgry);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), expctgry,
				"Failure message : category name not matched");
	}
	@Test(priority = 4, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteWaiterData() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		String expctgryDlt = excelutil.readStringData("ExpenseCategory", 3,1);
		expnsctgry.ClickOnSearchCategoryLink(expctgryDlt);
		expnsctgry.ClickOnDeleteButton();
		expnsctgry.ClickOnSearchCategoryLink(expctgryDlt);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : category name not matched");
	}
}
