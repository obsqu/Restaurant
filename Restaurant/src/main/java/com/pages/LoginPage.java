package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;

public class LoginPage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	@FindBy(xpath = "//input[@name='username']")
	WebElement username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement password;
	@FindBy(xpath = "//input[@name='submit']")
	WebElement submit;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void enterValuetoUsername(String usernm) {
		elementutil.enteringValuetoElements(driver, username, usernm);
	}
	public void enterValuetoPassword(String pwsd) {
		elementutil.enteringValuetoElements(driver, password, pwsd);
	}
	public void clickLoginButton() {
		elementutil.clickonTheElement(driver, submit);
	}
	public void performlogin(String username, String password) {
		enterValuetoUsername(username);
		enterValuetoPassword(password);
		clickLoginButton();
	}
	public HomePage login(String usernames, String passwords) {
		enterValuetoUsername(usernames);
		enterValuetoPassword(passwords);
		clickLoginButton();
		return new HomePage(driver);
	}
}
