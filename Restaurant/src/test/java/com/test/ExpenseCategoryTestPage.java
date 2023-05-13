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
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	ExcelUtils excelutil;
	@BeforeMethod
	public void preRun() {
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
		expnsctgry = homepg.navigateToExpenseCategoryPage();
		excelutil = new ExcelUtils();
	}
	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedAddExpensePage() {
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.waitForCategory();
		boolean flagdt = expnsctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt, "Fail: CategoryName field is not displayed");
		expnsctgry.ClickOnCloseButton();
	}
	@Test(priority = 2, enabled = true)
	public void validateAddExpenseCategoryDetails() {
		expnsctgry.ClickOnAddCategoryButton();
		expnsctgry.ClickOnCategoryName();
		String expctgry = excelutil.readStringData("ExpenseCategory", 2, 1);
		expnsctgry.enterValueForCategryName(expctgry);
		expnsctgry.ClickOnSubmitCategoryValues();
		expnsctgry.ClickOnSearchCategoryLink(expctgry);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), expctgry,
				"Failure message : category name not matched");
	}
	@Test(priority = 3, enabled = true)
	public void validateEditButtonForCategoryDetails()  {
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
	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		String expctgryDlt = excelutil.readStringData("ExpenseCategory", 3,1);
		expnsctgry.ClickOnSearchCategoryLink(expctgryDlt);
		expnsctgry.ClickOnDeleteButton();
		expnsctgry.ClickOnSearchCategoryLink(expctgryDlt);
		Assert.assertEquals(expnsctgry.getCategryNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : category name not matched");
	}
}
