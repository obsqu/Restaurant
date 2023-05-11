package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ExpenseCategoryPage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	WaitUtils waituti= new WaitUtils();
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addCategoryButn;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement SearchBtn;
	@FindBy(xpath = "//input[@id='CategoryName']")
	public WebElement categryName;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement catgrySubmitBtn;
	@FindBy(xpath = "//button[text()='Close']")
	public WebElement catgryClosBtn;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement catgryname_searchresult;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[1]")
	public WebElement catgryDeleteBtn;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement yesDltBtn;
	@FindBy(xpath = "(//a[@class='btn btn-default'])[2]")
	public WebElement catgryEditBtn;
	@FindBy(xpath = "//button[text()='Submit']")
	public WebElement catgrySubmitEditBtn;

	public ExpenseCategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isCategoryNameDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, categryName);
		return flag;
	}
	public void ClickOnAddCategoryButton() {
		elementutil.clickonTheElement(driver, addCategoryButn);
	}
	public void ClickOnCloseButton() {
		elementutil.clickonTheElement(driver, catgryClosBtn);
	}
	public void ClickOnSubmitCategoryValues() {
		elementutil.clickonTheElement(driver, catgrySubmitBtn);
	}
	public void ClickOnCategoryName() {
		elementutil.clickonTheElement(driver, categryName);
	}
	public void enterValueForCategryName(String ctgrynmVal) {
		elementutil.cleartheFieldd(driver, categryName);
		elementutil.enteringValuetoElements(driver, categryName, ctgrynmVal);
	}
	public String getCategryNameFromSearchResult() {
		return elementutil.getingtheText(driver, catgryname_searchresult);
	}
	public void ClickOnSearchCategoryLink(String searchVal) {
		elementutil.cleartheFieldd(driver, SearchBtn);
		elementutil.enteringValuetoElements(driver, SearchBtn, searchVal);
	}
	public void ClickOnCategoryEditButton() {
		elementutil.clickonTheElement(driver, catgryEditBtn);
	}
	public void ClickOnSubmitEditButton() {
		elementutil.clickonTheElement(driver, catgrySubmitEditBtn);
	}
	public void ClickOnDeleteButton() {
		elementutil.clickonTheElement(driver, catgryDeleteBtn);
		elementutil.clickonTheElement(driver, yesDltBtn);
	}
	public  void  waitForCategory() {
		waituti.waitForElementToBeClickable(driver,categryName,20);
	}

}
