package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebElementUtils {

	/**
	 * This method is to send key value to input field
	 * 
	 * @param driver
	 */
	public void enteringValuetoElements(WebDriver driver, WebElement element, String value) {
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method is to clear the field
	 * 
	 * @param driver
	 */
	public void cleartheFieldd(WebDriver driver, WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method is to click the button field
	 * 
	 * @param driver
	 */
	public void clickonTheElement(WebDriver driver, WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method is to perform submit action
	 * 
	 * @param driver
	 */
	public void submittheElement(WebDriver driver, WebElement element) {
		try {
			element.submit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	/**
	 * This method is to check the field is selected or not
	 * 
	 * @param driver
	 * @return
	 */
	public boolean isElementSelected(WebDriver driver, WebElement element) {
		boolean flag = false;
		try {
			flag = element.isSelected();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flag;
	}
	/**
	 * This method is to check if the field is enabled or not
	 * 
	 * @param driver
	 */
	public boolean isElementEnabled(WebDriver driver, WebElement element) {
		boolean flaglst = false;
		try {
			flaglst = element.isEnabled();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flaglst;
	}
	/**
	 * This method is to check if the field is displayed or not
	 * 
	 * @param driver
	 * @return
	 */
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		boolean flagfst = false;
		try {
			flagfst = element.isDisplayed();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return flagfst;
	}
	/**
	 * This method is to get the text in the field
	 * 
	 * @param driver
	 */
	public String getingtheText(WebDriver driver, WebElement element) {
		String text = null;
		try {
			text = element.getText();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return text;
	}
	/**
	 * This method is to get the tag name
	 * 
	 * 
	 * @param driver
	 */
	public String gettingtheTagname(WebDriver driver, WebElement element) {
		String tagnm = null;
		try {
			tagnm = element.getTagName();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return tagnm;
	}
	/**
	 * This is for getting the attribute of the field
	 * 
	 * @param driver
	 */
	public String getAttributeValue(WebDriver driver, WebElement element, String attribute) {
		String atribute = null;
		try {
			atribute = element.getAttribute(attribute);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return atribute;
	}
	/**
	 * This for get the css value
	 * 
	 * @param driver
	 */
	public String gettingCssVlue(WebDriver driver, WebElement element, String cssvalue) {
		String cssval = null;
		try {
			cssval = element.getCssValue(cssvalue);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cssval;
	}
	/**
	 * This for get the size of the field
	 * 
	 * @param driver
	 */
	public Dimension getSizeofElement(WebDriver driver, WebElement element) {
		Dimension size = null;
		try {
			size = element.getSize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return size;
	}
	/**
	 * This for getting the location of the field
	 * 
	 * @param driver
	 */
	public Point getLocationofElement(WebDriver driver, WebElement element) {
		Point locat = null;
		try {
			locat = element.getLocation();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return locat;
	}
}
