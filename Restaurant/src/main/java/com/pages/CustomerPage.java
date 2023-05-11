package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class CustomerPage {

	WebDriver driver;
	WebElementUtils elementUtils = new WebElementUtils();
	WaitUtils waitutil = new WaitUtils();
	@FindBy(xpath = "//input[@id='CustomerName']")
	public WebElement customerName;
	@FindBy(xpath = "//input[@id='CustomerPhone']")
	public WebElement customerPhoneNumber;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement customerEmailId;
	@FindBy(xpath = "//input[@id='CustomerDiscount']")
	public WebElement customerDiscount;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addCustomerBtn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeCustomerButn;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement submitCustomerDetail;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement SearchBtn;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement cutomername_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement customerphonenum_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement customeremail_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement customerdiscount_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement customerDeleteBtn;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	public WebElement yesDeleteWaiter;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement customrEditBtn;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement submitEditBtn;

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isCustomerNameDisplayed() {
		return elementUtils.isElementDisplayed(driver, customerName);
	}
	public boolean isCustomerEmailDisplayed() {
		return elementUtils.isElementDisplayed(driver, customerEmailId);
	}
	public boolean isCustomerPhoneDisplayed() {
		return elementUtils.isElementDisplayed(driver, customerPhoneNumber);
	}
	public boolean isCustomerDiscountDisplayed() {
		return elementUtils.isElementDisplayed(driver, customerDiscount);
	}
	public void clickOnCustomername() {
		elementUtils.clickonTheElement(driver, customerName);
	}
	public void clickOnPhoneNumber() {
		elementUtils.clickonTheElement(driver, customerPhoneNumber);
	}
	public void enterValueForCustomerName(String custmNameVal) {
		elementUtils.cleartheFieldd(driver, customerName);
		elementUtils.enteringValuetoElements(driver, customerName, custmNameVal);
	}
	public void enterValueForCustomerPhoneNumber(String custmPhoneVal) {
		elementUtils.cleartheFieldd(driver, customerPhoneNumber);
		elementUtils.enteringValuetoElements(driver, customerPhoneNumber, custmPhoneVal);
	}
	public void enterValueForCustomerMail(String custmMailVal) {
		elementUtils.cleartheFieldd(driver, customerEmailId);
		elementUtils.enteringValuetoElements(driver, customerEmailId, custmMailVal);
	}
	public void enterValueForCustomerDiscount(String custmDisctVal) {
		elementUtils.cleartheFieldd(driver, customerDiscount);
		elementUtils.enteringValuetoElements(driver, customerDiscount, custmDisctVal);
	}
	public void ClickSubmitCustomerDetails() {
		elementUtils.clickonTheElement(driver, submitCustomerDetail);
	}
	public String getCustomerNameFromSearchResult() {
		return elementUtils.getingtheText(driver, cutomername_searchresult);
	}
	public String getCustomerPhoneNumberFromSearchResult() {
		return elementUtils.getingtheText(driver, customerphonenum_searchresult);
	}
	public String getCustomerEmailidFromSearchResult() {
		return elementUtils.getingtheText(driver, customeremail_searchresult);
	}
	public String getCustomerDiscountFromSearchResult() {
		return elementUtils.getingtheText(driver, customerdiscount_searchresult);
	}
	public void clickDeleteCustomerDataButton() {
		elementUtils.clickonTheElement(driver, customerDeleteBtn);
		elementUtils.clickonTheElement(driver, yesDeleteWaiter);
	}
	public void clickEditCustomerDataButton() {
		elementUtils.clickonTheElement(driver, customrEditBtn);
	}
	public void clickSubmitEditCustmrDetails() {
		elementUtils.clickonTheElement(driver, submitEditBtn);
	}
	public void ClickOnAddButton() {
		elementUtils.clickonTheElement(driver, addCustomerBtn);
	}
	public void clickOnCloseCustomerButton() {
		elementUtils.clickonTheElement(driver, closeCustomerButn);
	}
	public void ClickOnSubmitDatas() {
		elementUtils.clickonTheElement(driver, submitCustomerDetail);
	}
	public void SearchDetails(String value) {
		elementUtils.enteringValuetoElements(driver, SearchBtn, value);
	}
	public void WaitCustomer() {
		waitutil.waitForElementToBeClickable(driver, customerName, 20);
	}

}
