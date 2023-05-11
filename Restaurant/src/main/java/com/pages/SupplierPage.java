package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.GenericUtils;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class SupplierPage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	GenericUtils droputil = new GenericUtils();
	WaitUtils waitutil = new WaitUtils();
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addSupplierrBtn;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement submitSupplierDetail;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement SearchBtn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement closeSupplierButn;
	@FindBy(xpath = "//input[@name='name']")
	public WebElement suplierName;
	@FindBy(xpath = "//input[@id='SupplierPhone']")
	public WebElement suplierPhone;
	@FindBy(xpath = "//input[@id='SupplierEmail']")
	public WebElement suplierEmail;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement suplierNote;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement suplrname_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement suplrphonenum_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement suplremail_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement suplircreateddate_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement suplirDeleteBtn;
	@FindBy(xpath = "//a[text()='Yes, delete it!']")
	public WebElement yesDeleteSuplr;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement suplirEditBtn;
	@FindBy(xpath = "//button[@class='btn btn-add']")
	public WebElement submitEditBtn;

	public SupplierPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isSupplierNameDisplayed() {
		return elementutil.isElementDisplayed(driver, suplierName);
	}
	public boolean isSupplierPhoneDisplayed() {
		return elementutil.isElementDisplayed(driver, suplierPhone);
	}
	public boolean isSupplierEmailDisplayed() {
		return elementutil.isElementDisplayed(driver, suplierEmail);
	}
	public boolean isSupplierNoteDisplayed() {
		return elementutil.isElementDisplayed(driver, suplierNote);
	}
	public void clickOnSupplierName() {
		elementutil.clickonTheElement(driver, suplierName);
	}
	public void enterSupplierName(String supliernmValue) {
		elementutil.cleartheFieldd(driver, suplierName);
		elementutil.enteringValuetoElements(driver, suplierName, supliernmValue);
	}
	public void enterSupplierPhone(String suplirPhonValue) {
		elementutil.cleartheFieldd(driver, suplierPhone);
		elementutil.enteringValuetoElements(driver, suplierPhone, suplirPhonValue);
	}
	public void enterSupplierMail(String suplierMailValue) {
		elementutil.cleartheFieldd(driver, suplierEmail);
		elementutil.enteringValuetoElements(driver, suplierEmail, suplierMailValue);
	}
	public void enterSupplierNote(String suplirNotValue) {
		elementutil.cleartheFieldd(driver, suplierNote);
		elementutil.enteringValuetoElements(driver, suplierNote, suplirNotValue);
	}
	public String getSuplierNameFromSearchResult() {
		return elementutil.getingtheText(driver, suplrname_searchresult);
	}
	public String getSuplierPhoneNumberFromSearchResult() {
		return elementutil.getingtheText(driver, suplrphonenum_searchresult);
	}
	public String getSuplierEmailidFromSearchResult() {
		return elementutil.getingtheText(driver, suplremail_searchresult);
	}
	public void clickDeleteSuplirDataButton() {
		elementutil.clickonTheElement(driver, suplirDeleteBtn);
		elementutil.clickonTheElement(driver, yesDeleteSuplr);
	}
	public void clickEditSuplirDataButton() {
		elementutil.clickonTheElement(driver, suplirEditBtn);
	}
	public void clickEditSubmitBtn() {
		elementutil.clickonTheElement(driver, submitEditBtn);
	}
	public void clickOnCloseSupplierButton() {
		elementutil.clickonTheElement(driver, closeSupplierButn);
	}
	public void ClickOnAddButton() {
		elementutil.clickonTheElement(driver, addSupplierrBtn);
	}
	public void ClickOnSubmitDatas() {
		elementutil.clickonTheElement(driver, submitSupplierDetail);
	}
	public void ClickOnSearchDetails(String value) {
		elementutil.enteringValuetoElements(driver, SearchBtn, value);
	}
	public void waitSupplier() {
		waitutil.waitForElementToBeClickable(driver, suplierName, 20);
	}
}
