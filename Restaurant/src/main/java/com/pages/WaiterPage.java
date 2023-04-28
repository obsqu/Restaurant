package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WebElementUtils;

public class WaiterPage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	GenericUtils droputil = new GenericUtils();
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addWaiterButn;
	@FindBy(xpath = "//input[@id='WaiterName']")
	public WebElement waiterName;
	@FindBy(xpath = "//input[@id='WaiterPhone']")
	public WebElement waiterPhoneNo;
	@FindBy(xpath = "//input[@id='WaiterEmail']")
	public WebElement waiterEmail;
	@FindBy(xpath = "//select[@name='store_id']")
	public WebElement waiterStore;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement waiterSubmitBtn;
	@FindBy(xpath = "//button[@class='btn btn-default']")
	public WebElement waiterCloseBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement waiterDeleteBtn;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	public WebElement yesDeleteWaiter;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement waiterEditBtn;
	@FindBy(xpath = "//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	public WebElement submitEditBtn;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement waitername_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement waiterphonenum_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement waiteremail_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement waiterstore_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement waitercreateddate_searchresult;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement waiterSearch;

	public WaiterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void ClickOnAddWaiterButton() {
		elementutil.clickonTheElement(driver, addWaiterButn);
	}
	public void ClickOnCloseWaiterButton() {
		elementutil.clickonTheElement(driver, waiterCloseBtn);
	}
	public boolean isWaiterNameDisplayed() {
		return elementutil.isElementDisplayed(driver, waiterName);
	}
	public boolean isWaiterEmailDisplayed() {
		return elementutil.isElementDisplayed(driver, waiterEmail);
	}
	public boolean isWaiterPhoneDisplayed() {
		return elementutil.isElementDisplayed(driver, waiterPhoneNo);
	}
	public boolean isWaiterStoreDisplayed() {
		return elementutil.isElementDisplayed(driver, waiterStore);
	}
	public void clickOnWaitername() {
		elementutil.clickonTheElement(driver, waiterName);
	}
	public void enterValueForWaiterName(String waiterNamevl) {
		elementutil.cleartheFieldd(driver, waiterName);
		elementutil.enteringValuetoElements(driver, waiterName, waiterNamevl);
	}
	public void enterValueForWaiterPhone(String waiterPhonevl) {
		elementutil.cleartheFieldd(driver, waiterPhoneNo);
		elementutil.enteringValuetoElements(driver, waiterPhoneNo, waiterPhonevl);
	}
	public void enterValueForWaiterEmailId(String waiteremailvl) {
		elementutil.cleartheFieldd(driver, waiterEmail);
		elementutil.enteringValuetoElements(driver, waiterEmail, waiteremailvl);
	}
	public void selectValueForWaiterStore(String storeValue) {
		elementutil.cleartheFieldd(driver, waiterStore);
		droputil.elememtSelectbyVisibleText(driver, waiterStore, storeValue);
	}
	public void submitWaiterValues() {
		elementutil.clickonTheElement(driver, waiterSubmitBtn);
	}
	public void searchWaiterLink(String searchVal) {
		elementutil.enteringValuetoElements(driver, waiterSearch, searchVal);
	}
	public String getWaiterNameFromSearchResult() {
		return elementutil.getingtheText(driver, waitername_searchresult);
	}
	public String getWaiterPhoneNumberFromSearchResult() {
		return elementutil.getingtheText(driver, waiterphonenum_searchresult);
	}
	public String getWaiterEmailidFromSearchResult() {
		return elementutil.getingtheText(driver, waiteremail_searchresult);
	}
	public String getWaiterStoreFromSearchResult() {
		return elementutil.getingtheText(driver, waiterstore_searchresult);
	}
	public String getWaiterCreatedDateandTimeFromSearchResult() {
		return elementutil.getingtheText(driver, waitercreateddate_searchresult);
	}
	public void clickDeleteWaiterDataButton() {
		elementutil.clickonTheElement(driver, waiterDeleteBtn);
		elementutil.clickonTheElement(driver, yesDeleteWaiter);
	}
	public void clickEditWaiterDataButton() {
		elementutil.clickonTheElement(driver, waiterEditBtn);
	}
}
