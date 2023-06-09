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

	LoginPage loginpg;
	HomePage homepg;
	ExpensePage expnspg;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	Properties allProp;
	ExcelUtils excelutil = new ExcelUtils();
	
	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedOnAddExpensePage() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnspg = homepg.navigateToExpensesPage();
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
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnspg = homepg.navigateToExpensesPage();
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
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), "2023-05-22",
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), expnsRefrnc,
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),"600.000",
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), expnsCatgry,
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), expnsStr,
				"Failure message : expense store not matched");
		soft.assertAll();
	}
	@Test(priority=3,enabled=true)
	public void validateEditButtonForExpenseDetails() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnspg = homepg.navigateToExpensesPage();
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
		soft.assertEquals(expnspg.getExpenseDateFromSearchResult(), "2023-06-08",
				"Failure message : expense date not matched");
		soft.assertEquals(expnspg.getExpenseReferenseFromSearchResult(), expnsRefrnc,
				"Failure message : expense refernse not matched");
		soft.assertEquals(expnspg.getExpenseAmountFromSearchResult(),"400.000",
				"Failure message : expense amount not matched");
		soft.assertEquals(expnspg.getExpenseCategoryFromSearchResult(), expnsCatgry,
				"Failure message : expense category not matched");
		soft.assertEquals(expnspg.getExpenseStoreFromSearchResult(), expnsStr,
				"Failure message : expense store not matched");
		soft.assertAll();
	}
	@Test(priority=4,enabled=true)
	public void validateDeleteExpenseData() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		expnspg = homepg.navigateToExpensesPage();
		expnspg.ClickOnSearchExpenseLink("ambc");
		expnspg.ClickOnDeleteButton();
		expnspg.YesDeleteButton();
		expnspg.ClickOnSearchExpenseLink("ambc");
		Assert.assertEquals(expnspg.getExpenseReferenseFromSearchResult(),AutomationConstants.ErrorMessage,
				"Failure message : Referense value not matched");
	}
}
