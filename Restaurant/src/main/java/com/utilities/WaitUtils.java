package com.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

	public WebDriverWait wait;

	/**
	 * This method is to implement implicit wait
	 * 
	 * @param driver
	 * @param value
	 */

	public void implicitWait(WebDriver driver, int timeOut) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	/**
	 * This method is to implement explicit wait for presence of element
	 * 
	 * @param driver
	 * @param elementLocator
	 * @return
	 * @throws Exception
	 */
	public void waitForAnElement(WebDriver driver, WebElement element, int timeOut) throws Exception {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	/**
	 * This method is to provide explicit wait for visibility of an element
	 * 
	 * @param driver
	 * @param element
	 * @param timeOut
	 */
	public void explicitWait(WebDriver driver, WebElement element, int timeOut) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	/**
	 * This method is to provide explicit wait for visiblity of particulator locator
	 * 
	 * @param driver
	 * @param locator
	 * @param timeOut
	 */
	public void waitForVisibilityOfElement(WebDriver driver, WebElement element, int timeOut) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			 wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	/**
	 * This method is to provide wait for page load time out
	 * 
	 * @param driver
	 * @param timeOut
	 */
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		try {
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
	/**
	 * This method is to provide wait for element to clickable
	 * 
	 * @param driver
	 * @param element
	 * @param timeOut
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element, int timeOut) {
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
			 wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}
}
