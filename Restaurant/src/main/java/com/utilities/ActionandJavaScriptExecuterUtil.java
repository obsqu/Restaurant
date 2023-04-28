package com.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionandJavaScriptExecuterUtil {

	WebDriver driver;
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;

	/**
	 * Perform click action on the webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickMethodOnWebElement(WebDriver driver, WebElement element) {
		try {
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * Method to double click on an element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		try {
			action.doubleClick(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * Right click on webelement
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickMethodOnWebElement(WebDriver driver, WebElement element) {
		try {
			action.contextClick(element).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * drag and drop the webelement
	 * 
	 * @param driver
	 * @param dragElement
	 * @param dropElement
	 */
	public void dragAndDropMethodOnWebElement(WebDriver driver, WebElement dragElement, WebElement dropElement) {
		try {
			action.dragAndDrop(dragElement, dropElement).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * Method to move cursor according to x and y coordinate
	 * 
	 * @param driver
	 * @param cordinateX
	 * @param cordinateY
	 */
	public void moveByOffsetMethodByXandYCordinate(WebDriver driver, int cordinateX, int cordinateY) {
		try {
			action.moveByOffset(cordinateX, cordinateY).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * Method to click and send value to the element
	 * 
	 * @param element
	 * @param value
	 */
	public void clickAndSendKeys(WebElement element, String value) {
		try {
			action.click(element).sendKeys(value).build().perform();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}
	}

	/**
	 * Method to scroll down the page
	 * 
	 */
	public void scrollDownmethod() {
		js.executeScript("window.scrollBy(0,600)");
	}

}
