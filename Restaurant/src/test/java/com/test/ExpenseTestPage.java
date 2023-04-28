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
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ExpensePage expnspg;
	BrowserUtils brwsrUtil = new BrowserUtils();
	WebElementUtils elementutil = new WebElementUtils();
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	WaitUtils waitutil = new WaitUtils();
	CommonDatas comon = new CommonDatas();
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
		expnspg = homepg.navigateToExpensesPage();

	}

	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedAddExpensePage() {
		expnspg.ClickOnAddExpenseButton();
		waitutil.waitForElementToBeClickable(driver, expnspg.expenseDate, 20);
		soft.assertTrue(expnspg.isExpensedateDisplayed(), "Fail: ExpenseDate field is not displayed");
		soft.assertTrue(expnspg.isExpenseRefernseDisplayed(), "Fail: ExpenseReference field is not displayed");
		soft.assertTrue(expnspg.isExpenseCategoryDisplayed(), "Fail: ExpenseCategory field is not displayed");
		soft.assertTrue(expnspg.isExpenseStoreDisplayed(), "Fail: ExpenseStore field is not displayed");
		soft.assertTrue(expnspg.isExpenseAmountDisplayed(), "Fail: ExpenseAmount field is not displayed");
		soft.assertTrue(expnspg.isExpenseNoteDisplayed(), "Fail: ExpenseNote field is not displayed");
		soft.assertAll();
		expnspg.ClickOnCloseButton();

	}

	@Test(priority = 2, enabled = true)
	public void validateAddExpenseDetails() throws Exception {
		expnspg.ClickOnAddExpenseButton();
		waitutil.waitForAnElement(driver, expnspg.expenseDate, 10);
		expnspg.enterValueForExpenseDate("03/23/2023");
		expnspg.enterValueForExpenseReference("Miraj");
		expnspg.selectValueForExpenseCategory("Pasta");
		expnspg.selectValueForExpenseStore("MNC");
		expnspg.enterValueForExpenseAmount("5600");
		expnspg.enterValueForExpenseNote("Hai All");
		expnspg.ClickOnSubmitExpenseValues();
		expnspg.ClickOnSearchExpenseLink("Miraj");
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), "03/23/2023",
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), "Miraj",
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(), "5600",
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), "Pasta",
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), "MNC",
				"Failure message : expense store not matched");
		soft.assertAll();
	}

	@Test(priority=3,enabled=true)
	public void validateEditButtonForExpenseDetails() {

		expnspg.ClickOnSearchExpenseLink("Shibina");
		expnspg.ClickOnExpenseEditButton();
		expnspg.enterValueForExpenseDate("05/04/2023");
		expnspg.enterValueForExpenseReference("Mirus");
		expnspg.selectValueForExpenseCategory("cutlet");
		expnspg.selectValueForExpenseStore("MCDS");
		expnspg.enterValueForExpenseAmount("500");
		expnspg.enterValueForExpenseNote("Taste");

		expnspg.ClickOnSubmitEditButton();
		expnspg.ClickOnSearchExpenseLink("Mirus");

		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), "05/04/2023",
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), "Mirus",
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(), "500",
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), "cutlet",
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), "MCDS",
				"Failure message : expense store not matched");

		soft.assertAll();
	}

	// @Test(priority=4,enabled=true)
	public void validateDeleteWaiterData() {

		expnspg.ClickOnSearchExpenseLink("Arun");
		expnspg.ClickOnDeleteButton();
		expnspg.ClickOnSearchExpenseLink("Arun");
		Assert.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), "No matching records found",
				"Failure message : Refernse value not matched");

	}

}
