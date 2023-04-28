package com.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class BrowserUtils {

	/**
	 * This method is to launch the given URL
	 * 
	 * @param driver
	 * @param url
	 */
	public void launchUrl(WebDriver driver, String url) {

		try {
			driver.get(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());

		}
	}

	/**
	 * This method is to get the title of the given URL
	 * 
	 * @param driver
	 * @return
	 */
	public String getTitl(WebDriver driver) {
		String titl = null;
		try {
			titl = driver.getTitle();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return titl;
	}

	/**
	 * This method is to get curent url of web page
	 * 
	 * @param driver
	 * @return
	 */
	public String getCurrentURLofWebpage(WebDriver driver) {
		String url = null;
		try {
			url = driver.getCurrentUrl();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return url;
	}

	/**
	 * This method is to get pagesource
	 * 
	 * @param driver
	 * @return
	 */
	public String getpageSourceofWebpage(WebDriver driver) {
		String pagesrc = null;
		try {
			pagesrc = driver.getPageSource();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return pagesrc;
	}

	/**
	 * This method is to navigate to a particular webpage
	 * 
	 * @param driver
	 * @param url
	 */
	public void navigateToWebPage(WebDriver driver, String url) {
		try {
			driver.navigate().to(url);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to to navigate back to the previous page
	 * 
	 * @param driver
	 */

	public void navigateBacktoPreviousPage(WebDriver driver) {
		try {
			driver.navigate().back();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to navigate to webpage
	 * 
	 * @param driver
	 */

	public void navigateForwardtoWebPage(WebDriver driver) {
		try {
			driver.navigate().forward();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to refresh the page
	 * 
	 * @param driver
	 */

	public void refreshPage(WebDriver driver) {
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to maximize the page window
	 * 
	 * @param driver
	 */

	public void maximizeWindow(WebDriver driver) {
		try {
			driver.manage().window().maximize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to minimize the page window
	 * 
	 * @param driver
	 */

	public void minimizeWindow(WebDriver driver) {
		try {
			driver.manage().window().minimize();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to fullscreen the page window
	 * 
	 * @param driver
	 */
	public void fullScreenWindow(WebDriver driver) {
		try {
			driver.manage().window().fullscreen();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to close the current running page
	 * 
	 * @param driver
	 */

	public void closeWindows(WebDriver driver) {
		try {
			driver.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * This method is to close all the opened windows
	 * 
	 * @param driver
	 */

	public void quiteWindow(WebDriver driver) {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}