package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpensePage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	GenericUtils droputil = new GenericUtils();
	WaitUtils waitutil=new WaitUtils();
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addExpenseButn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement SearchBtn;
	@FindBy(xpath = "//input[@id='Date']")
	public WebElement expenseDate;
	@FindBy(xpath = "//input[@id='Reference']")
	public WebElement expenseReference;
	@FindBy(xpath = "//select[@id='Category']")
	public WebElement expenseCatgry;
	@FindBy(xpath = "//select[@id='store_id']")
	public WebElement expenseStr;
	@FindBy(xpath = "//input[@id='Amount']")
	public WebElement expenseAmount;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement expenseNote;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement expenseSubmitBtn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement expenseClosBtn;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[1]")
	public WebElement expensedate_searchresult;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[2]")
	public WebElement expensereferense_searchresult;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[3]")
	public WebElement expensestore_searchresult;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[4]")
	public WebElement expensecategry_searchresult;
	@FindBy(xpath = "(//table[@id='table']//tr//td)[5]")
	public WebElement expenseamount_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement expenseDeleteBtn;
	@FindBy(xpath = "//button[text()='Yes, delete it!']")
	public WebElement yesDltBtn;
	@FindBy(xpath = "//button[text()='OK']")
	public WebElement OkBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement expenseEditBtn;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement expenseSubmitEditBtn;

	public ExpensePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isExpensedateDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseDate);
	}
	public boolean isExpenseRefernseDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseReference);
	}
	public boolean isExpenseCategoryDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseCatgry);
	}
	public boolean isExpenseStoreDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseStr);
	}
	public boolean isExpenseAmountDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseAmount);
	}
	public boolean isExpenseNoteDisplayed() {
		return elementutil.isElementDisplayed(driver, expenseNote);
	}
	public void ClickOnCloseButton() {
		elementutil.clickonTheElement(driver, expenseClosBtn);
	}
	public void ClickOnAddExpenseButton() {
		elementutil.clickonTheElement(driver, addExpenseButn);
	}
	public void enterValueForExpenseDate(String dateVal) {
		elementutil.cleartheFieldd(driver, expenseDate);
		elementutil.enteringValuetoElements(driver, expenseDate, dateVal);
	}
	public void enterValueForExpenseReference(String expnsRefrVal) {
		elementutil.cleartheFieldd(driver, expenseReference);
		elementutil.enteringValuetoElements(driver, expenseReference, expnsRefrVal);
	}
	public void selectValueForExpenseCategory(String catgryValue) {
		elementutil.cleartheFieldd(driver, expenseCatgry);
		droputil.elememtSelectbyVisibleText(driver, expenseCatgry, catgryValue);
	}
	public void selectValueForExpenseStore(String storeValue) {
		elementutil.cleartheFieldd(driver, expenseStr);
		droputil.elememtSelectbyVisibleText(driver, expenseStr, storeValue);
	}
	public void enterValueForExpenseAmount(String amntVal) {
		elementutil.cleartheFieldd(driver, expenseAmount);
		elementutil.enteringValuetoElements(driver, expenseAmount, amntVal);
	}
	public void enterValueForExpenseNote(String noteVal) {
		elementutil.cleartheFieldd(driver, expenseNote);
		elementutil.enteringValuetoElements(driver, expenseNote, noteVal);
	}
	public void ClickOnSubmitExpenseValues() {
		elementutil.clickonTheElement(driver, expenseSubmitBtn);
	}
	public void ClickOnSearchExpenseLink(String searchVal) {
		elementutil.cleartheFieldd(driver, SearchBtn);
		elementutil.enteringValuetoElements(driver, SearchBtn, searchVal);
	}
	public String getExpenseDateFromSearchResult() {
		return elementutil.getingtheText(driver, expensedate_searchresult);
	}
	public String getExpenseReferenseFromSearchResult() {
		return elementutil.getingtheText(driver, expensereferense_searchresult);
	}
	public String getExpenseAmountFromSearchResult() {
		return elementutil.getingtheText(driver, expenseamount_searchresult);
	}
	public String getExpenseCategoryFromSearchResult() {
		return elementutil.getingtheText(driver, expensecategry_searchresult);
	}
	public String getExpenseStoreFromSearchResult() {
		return elementutil.getingtheText(driver, expensestore_searchresult);
	}
	public void ClickOnExpenseEditButton() {
		elementutil.clickonTheElement(driver, expenseEditBtn);
	}
	public void ClickOnSubmitEditButton() {
		elementutil.clickonTheElement(driver, expenseSubmitEditBtn);
	}
	public void ClickOnDeleteButton() {
		elementutil.clickonTheElement(driver, expenseDeleteBtn);
		elementutil.clickonTheElement(driver, yesDltBtn);
		elementutil.clickonTheElement(driver, OkBtn);
	}
	public void waitForExpense() {
		waitutil.waitForElementToBeClickable(driver,expenseDate,20);
	}
}
