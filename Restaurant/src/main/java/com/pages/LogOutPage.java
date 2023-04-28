package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class LogOutPage {

	WebElementUtils elementutil = new WebElementUtils();
	WebDriver driver;
	@FindBy(xpath = "//i[@class='fa fa-sign-out fa-lg']")
	public WebElement logoutBtn;
	@FindBy(xpath = "//input[@class='login loginmodal-submit']")
	public WebElement loginBtn;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnLogOutButton() {
		elementutil.clickonTheElement(driver, logoutBtn);
	}
	public boolean isLoginButtonDisplayed() {
		return elementutil.isElementDisplayed(driver, loginBtn);
	}
}
