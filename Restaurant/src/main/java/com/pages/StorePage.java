package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class StorePage {

	WebDriver driver;
	WebElementUtils elementutils = new WebElementUtils();
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addStoreButn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeStoreButn;
	@FindBy(xpath = "//input[@name='name']")
	public WebElement storeName;
	@FindBy(xpath = "//input[@id='email']")
	public WebElement storeEmailid;
	@FindBy(xpath = "//input[@id='StorePhone']")
	public WebElement storePhoneNumbr;
	@FindBy(xpath = "//input[@id='Country']")
	public WebElement storeCountry;
	@FindBy(xpath = "//input[@id='City']")
	public WebElement storeCity;
	@FindBy(xpath = "//input[@id='Adresse']")
	public WebElement storeAddress;
	@FindBy(xpath = "//input[@id='CustomeFooter']")
	public WebElement storeCustomFootr;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement storeSubmitBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement storeDeleteBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement storeEditBtn;
	@FindBy(xpath = "//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	public WebElement submitEditBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[3]")
	public WebElement storeManageTblButn;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement storename_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement storeemailid_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement storephoneno_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement storecountry_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement storecity_searchresult;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement storeSearch;

	public StorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isStoreNameDisplayed() {
		return elementutils.isElementDisplayed(driver, storeName);
	}
	public boolean isStoreEmailDisplayed() {
		return elementutils.isElementDisplayed(driver, storeEmailid);
	}
	public boolean isStorePhoneDisplayed() {
		return elementutils.isElementDisplayed(driver, storePhoneNumbr);
	}
	public boolean isStoreCountryDisplayed() {
		return elementutils.isElementDisplayed(driver, storeCountry);
	}
	public boolean isStoreCityDisplayed() {
		return elementutils.isElementDisplayed(driver, storeCity);
	}
	public boolean isStoreAddressDisplayed() {
		return elementutils.isElementDisplayed(driver, storeAddress);
	}
	public boolean isStoreCustomFooterDisplayed() {
		return elementutils.isElementDisplayed(driver, storeCustomFootr);
	}
	public void clickOnAddStoreButton() {
		elementutils.clickonTheElement(driver, addStoreButn);
	}
	public void clickOnCloseStoreButton() {
		elementutils.clickonTheElement(driver, closeStoreButn);
	}
	public void clickOnStoreName() {
		elementutils.clickonTheElement(driver, storeName);
	}
	public void enterValueToStoreName(String storeNamevl) {
		elementutils.cleartheFieldd(driver, storeName);
		elementutils.enteringValuetoElements(driver, storeName, storeNamevl);
	}
	public void enterValueToStoreEmailID(String storeEmailvl) {
		elementutils.cleartheFieldd(driver, storeEmailid);
		elementutils.enteringValuetoElements(driver, storeEmailid, storeEmailvl);
	}
	public void enterValueToStorePhoneNumber(String storePhonevl) {
		elementutils.cleartheFieldd(driver, storePhoneNumbr);
		elementutils.enteringValuetoElements(driver, storePhoneNumbr, storePhonevl);
	}
	public void enterValueToStoreCountryr(String storeCountryvl) {
		elementutils.cleartheFieldd(driver, storeCountry);
		elementutils.enteringValuetoElements(driver, storeCountry, storeCountryvl);
	}
	public void enterValueToStoreCity(String storeCityvl) {
		elementutils.cleartheFieldd(driver, storeCity);
		elementutils.enteringValuetoElements(driver, storeCity, storeCityvl);
	}
	public void enterValueToStoreAddress(String storeAddresvl) {
		elementutils.cleartheFieldd(driver, storeAddress);
		elementutils.enteringValuetoElements(driver, storeAddress, storeAddresvl);
	}
	public void enterValueToStoreCustom(String storeCustmFutvl) {
		elementutils.cleartheFieldd(driver, storeCustomFootr);
		elementutils.enteringValuetoElements(driver, storeCustomFootr, storeCustmFutvl);
	}
	public void submitStoreValues() {
		elementutils.clickonTheElement(driver, storeSubmitBtn);
	}
	public void searchStoreLink(String searchVal) {
		elementutils.enteringValuetoElements(driver, storeSearch, searchVal);
	}
	public String getStoreNameFromSearchResults() {
		return elementutils.getingtheText(driver, storename_searchresult);
	}
	public String getStoreEmailidFromSearchResults() {
		return elementutils.getingtheText(driver, storeemailid_searchresult);
	}
	public String getStorePhoneNoFromSearchResults() {
		return elementutils.getingtheText(driver, storephoneno_searchresult);
	}
	public String getStoreCountryFromSearchResults() {
		return elementutils.getingtheText(driver, storecountry_searchresult);
	}
	public String getStoreCityFromSearchResults() {
		return elementutils.getingtheText(driver, storecity_searchresult);
	}
	public void deleteStoreDetails() {
		elementutils.clickonTheElement(driver, storeDeleteBtn);
	}
	public void editStoreDetails() {
		elementutils.clickonTheElement(driver, storeEditBtn);
	}
	public void submitEditDetails() {
		elementutils.clickonTheElement(driver, submitEditBtn);
	}
	public void ManageStoreTables() {
		elementutils.clickonTheElement(driver, storeManageTblButn);
	}
}
