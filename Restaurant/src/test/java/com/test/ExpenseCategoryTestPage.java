package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CommonDatas;
import com.pages.ExpenseCategoryPage;
import com.pages.HomePage;
import com.pages.LoginPage;

import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseCategoryTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ExpenseCategoryPage expnsctgry;
	BrowserUtils brwsrUtil = new BrowserUtils();
	WebElementUtils elementutil = new WebElementUtils();
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	WaitUtils waitutil = new WaitUtils();
	ExcelUtils excelutil;

	@BeforeMethod
	public void preRun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		excelutil = new ExcelUtils();
	}
	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedAddExpensePage() {
		expnsctgry.ClickOnAddCategoryButton();
		boolean flagdt = expnsctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt, "Fail: CategoryName field is not displayed");
		expnsctgry.ClickOnCloseButton();
	}
	@Test(priority = 2, enabled = true)
	public void validateAddExpenseCategoryDetails() throws Exception {
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.ClickOnCategoryName();
		String expctgry = excelutil.readStringData("ExpenseCategory", 2, 1);
		expnsctgry.enterValueForCategryName(expctgry);
		expnsctgry.ClickOnSubmitCategoryValues();
		brwsrUtil.refreshPage(driver);
		expnsctgry.ClickOnSearchCategoryLink(expctgry);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), expctgry,
				"Failure message : category name not matched");
	}
	@Test(priority = 3, enabled = true)
	public void validateEditButtonForCategoryDetails() throws IOException {
		String expctgry = excelutil.readStringData("ExpenseCategory", 2, 1);
		String expctgrynm2 = excelutil.readStringData("ExpenseCategory", 3,1);
		expnsctgry.ClickOnSearchCategoryLink(expctgry);
		expnsctgry.ClickOnCategoryEditButton();
		expnsctgry.enterValueForCategryName(expctgrynm2);
		expnsctgry.ClickOnSubmitEditButton();
		brwsrUtil.refreshPage(driver);
		expnsctgry.ClickOnSearchCategoryLink(expctgrynm2);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), expctgrynm2,
				"Failure message : category name not matched");
	}
	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		expnsctgry.ClickOnSearchCategoryLink("Broasted");
		expnsctgry.ClickOnDeleteButton();
		expnsctgry.ClickOnSearchCategoryLink("Broasted");
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), "No matching records found",
				"Failure message : category name not matched");
	}
}
