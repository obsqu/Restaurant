package com.test;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.AutomationBase;
import com.pages.CommonDatas;
import com.pages.ExpensePage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductCategoryPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ProductCategoryTestPage extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	ProductCategoryPage pdtctgry;
	BrowserUtils brwsrUtil = new BrowserUtils();
	WebElementUtils elementutil = new WebElementUtils();
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	WaitUtils waitutil = new WaitUtils();
	CommonDatas comon = new CommonDatas();
	ExcelUtils excelutil;

	@BeforeMethod
	public void preRun() throws IOException {
		excelutil = new ExcelUtils();
		driver = getDriver();
		Properties allProp = property.getAllProperties("config.properties");
		String site = allProp.getProperty("url");
		brwsrUtil.launchUrl(driver, site);loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		pdtctgry = homepg.navigateToProductCategoryPage();

	}

	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedAddProductPage() {
		pdtctgry.ClickOnAddCategoryButton();
		boolean flagdt = pdtctgry.isCategoryNameDisplayed();
		Assert.assertTrue(flagdt, "Fail: CategoryName field is not displayed");
		pdtctgry.ClickOnCloseButton();
	}

	@Test(priority = 2, enabled = true)
	public void validateAddProductCategoryDetails() throws Exception {
		String catgrynm = excelutil.readStringData("ProductCategory", 2, 1);
		pdtctgry.ClickOnAddCategoryButton();
		pdtctgry.ClickOnCategoryName();
		pdtctgry.enterValueForCategryName(catgrynm);
		pdtctgry.ClickOnSubmitCategoryValues();
		brwsrUtil.refreshPage(driver);
		pdtctgry.ClickOnSearchCategoryLink("Broasted");
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), "Broasted",
				"Failure message : category name not matched");
	}

	@Test(priority = 3, enabled = true)
	public void validateEditButtonForCategoryDetails() {

		pdtctgry.ClickOnSearchCategoryLink("Pizza");
		pdtctgry.ClickOnCategoryEditButton();
		pdtctgry.enterValueForCategryName("Munch");
		pdtctgry.ClickOnSubmitEditButton();
		brwsrUtil.refreshPage(driver);
		pdtctgry.ClickOnSearchCategoryLink("Munch");
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), "Munch",
				"Failure message : category name not matched");
	}

	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		pdtctgry.ClickOnSearchCategoryLink("lemon");
		pdtctgry.ClickOnDeleteButton();
		pdtctgry.ClickOnSearchCategoryLink("lemon");
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), "No matching records found",
				"Failure message : category name not matched");

	}

}