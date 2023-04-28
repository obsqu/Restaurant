package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.utilities.BrowserUtils;
import com.utilities.WebElementUtils;
import com.utilities.GenericUtils;

public class HomePage {

	WebDriver driver;
	WebElementUtils elementutils = new WebElementUtils();
	GenericUtils dropdwn = new GenericUtils();
	BrowserUtils brwsrUtil = new BrowserUtils();
	@FindBy(xpath = "//span[text()='POS']")
	WebElement poslink;
	@FindBy(xpath = "//span[text()='Product']")
	WebElement productlink;
	@FindBy(xpath = "//span[text()='Stores']")
	WebElement storelink;
	@FindBy(xpath = "//span[text()='People']")
	WebElement peoplelink;
	@FindBy(xpath = "//span[text()='Sales']")
	WebElement saleslink;
	@FindBy(xpath = "//span[text()='Expense']")
	WebElement expenselink;
	@FindBy(xpath = "//span[text()='Categories ']")
	WebElement categorylink;
	@FindBy(xpath = "//span[text()='Setting']")
	WebElement settinglink;
	@FindBy(xpath = "//span[text()='Reports']")
	WebElement reportlink;
	@FindBy(xpath = "//li[@class='dropdown language']")
	WebElement language;
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	WebElement logout;
	@FindBy(xpath = "//span[text()='Waiters']")
	WebElement waiterlink;
	@FindBy(xpath = "//span[text()='Customers']")
	WebElement customerlink;
	@FindBy(xpath = "//span[text()='Suppliers']")
	WebElement supplierlink;
	@FindBy(xpath = "(//span[text()='Product'])[2]")
	WebElement prdtCatgrylink;
	@FindBy(xpath = "(//span[text()='Expense'])[2]")
	WebElement expnsCatgrylink;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isPosDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, poslink);
		return flag;
	}
	public boolean isProductDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, productlink);
		return flag;
	}
	public boolean isStoreDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, storelink);
		return flag;
	}
	public boolean isPeopleDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, peoplelink);
		return flag;
	}
	public boolean isSaleDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, saleslink);
		return flag;
	}
	public boolean isExpenseDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, expenselink);
		return flag;
	}
	public boolean isCategoryDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, categorylink);
		return flag;
	}
	public boolean isSettingDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, settinglink);
		return flag;
	}
	public boolean isReportDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, reportlink);
		return flag;
	}
	public boolean isLanguageDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, language);
		return flag;
	}
	public boolean isLogoutDisplayed() {
		boolean flag = elementutils.isElementDisplayed(driver, logout);
		return flag;
	}
	public ProductPage navigateToPdtPage() {
		elementutils.clickonTheElement(driver, productlink);
		return new ProductPage(driver);
	}
	public StorePage navigateToStorePage() {
		elementutils.clickonTheElement(driver, storelink);
		return new StorePage(driver);
	}
	public WaiterPage navigateToWaiterPage() {
		elementutils.clickonTheElement(driver, peoplelink);
		elementutils.clickonTheElement(driver, waiterlink);
		return new WaiterPage(driver);
	}
	public CustomerPage navigateToCustomerPage() {
		elementutils.clickonTheElement(driver, peoplelink);
		elementutils.clickonTheElement(driver, customerlink);
		return new CustomerPage(driver);
	}
	public SupplierPage navigateToSupplierPage() {
		elementutils.clickonTheElement(driver, peoplelink);
		elementutils.clickonTheElement(driver, supplierlink);
		return new SupplierPage(driver);
	}
	public ExpensePage navigateToExpensesPage() {
		elementutils.clickonTheElement(driver, expenselink);
		return new ExpensePage(driver);
	}
	public ProductCategoryPage navigateToProductCategoryPage() {
		elementutils.clickonTheElement(driver, categorylink);
		elementutils.clickonTheElement(driver, prdtCatgrylink);
		return new ProductCategoryPage(driver);
	}
	public ExpenseCategoryPage navigateToExpenseCategoryPage() {
		elementutils.clickonTheElement(driver, categorylink);
		elementutils.clickonTheElement(driver, expnsCatgrylink);
		return new ExpenseCategoryPage(driver);
	}
	public LogOutPage navigateToLogoutPage() {
		return new LogOutPage(driver);
	}
}
