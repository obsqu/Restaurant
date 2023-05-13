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
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
public class ExpenseTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ExpensePage expnspg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	Properties allProp;
	ExcelUtils excelutil;
	@BeforeMethod
	public void preRun()  {
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
		expnspg = homepg.navigateToExpensesPage();
	}
	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedOnAddExpensePage() {
		expnspg.ClickOnAddExpenseButton();
		expnspg.waitForExpense();
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
	public void validateAddExpenseDetails() {
		String expnsDate = excelutil.readStringData("Expense", 2, 1);
		String expnsRefrnc = excelutil.readStringData("Expense", 2, 2);
		String expnsCatgry = excelutil.readStringData("Expense", 2, 3);
		String expnsStr = excelutil.readStringData("Expense",2,4);
		String expnsAmnt = excelutil.readStringData("Expense", 2,5);
		String expnsNote = excelutil.readStringData("Expense", 2,6);
		expnspg.ClickOnAddExpenseButton();
		expnspg.waitForExpense();
		expnspg.enterValueForExpenseDate(expnsDate);
		expnspg.enterValueForExpenseReference(expnsRefrnc);
		expnspg.selectValueForExpenseCategory(expnsCatgry);
		expnspg.selectValueForExpenseStore(expnsStr);
		expnspg.enterValueForExpenseAmount(expnsAmnt);
		expnspg.enterValueForExpenseNote(expnsNote);
		expnspg.ClickOnSubmitExpenseValues();
		expnspg.ClickOnSearchExpenseLink(expnsRefrnc);
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), 2023-10-05,
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), expnsRefrnc,
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),20000.000,
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), expnsCatgry,
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), expnsStr,
				"Failure message : expense store not matched");
		soft.assertAll();
	}
	@Test(priority=3,enabled=true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateEditButtonForExpenseDetails() {
		String expnsEdt = excelutil.readStringData("Expense", 2, 2);
		String expnsDate = excelutil.readStringData("Expense", 3, 1);
		String expnsRefrnc = excelutil.readStringData("Expense",3, 2);
		String expnsCatgry = excelutil.readStringData("Expense", 3, 3);
		String expnsStr = excelutil.readStringData("Expense",3,4);
		String expnsAmnt = excelutil.readStringData("Expense",3,5);
		String expnsNote = excelutil.readStringData("Expense", 3,6);
		expnspg.ClickOnSearchExpenseLink(expnsEdt);
		expnspg.ClickOnExpenseEditButton();
		expnspg.enterValueForExpenseDate(expnsDate);
		expnspg.enterValueForExpenseReference(expnsRefrnc);
		expnspg.selectValueForExpenseCategory(expnsCatgry);
		expnspg.selectValueForExpenseStore(expnsStr);
		expnspg.enterValueForExpenseAmount(expnsAmnt);
		expnspg.enterValueForExpenseNote(expnsNote);
		expnspg.ClickOnSubmitEditButton();
		expnspg.ClickOnSearchExpenseLink(expnsRefrnc);
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), expnsDate,
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), expnsRefrnc,
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),expnsAmnt,
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), expnsCatgry,
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), expnsStr,
				"Failure message : expense store not matched");
		soft.assertAll();
	}
	@Test(priority=4,enabled=true)
	public void validateDeleteExpenseData() {
		String expnsDlt = excelutil.readStringData("Expense", 3, 2);
		expnspg.ClickOnSearchExpenseLink(expnsDlt);
		expnspg.ClickOnDeleteButton();
		expnspg.ClickOnSearchExpenseLink(expnsDlt);
		Assert.assertEquals(expnspg.getExpenseReferenseFromSearchResult(),AutomationConstants.ErrorMessage,
				"Failure message : Refernse value not matched");
	}
}
