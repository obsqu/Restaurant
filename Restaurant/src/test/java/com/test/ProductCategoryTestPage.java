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
import com.constants.AutomationConstants;
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
	SoftAssert soft = new SoftAssert();
	PropertyUtil property = new PropertyUtil();
	ExcelUtils excelutil;
	Properties allProp;
	@BeforeMethod
	public void preRun() throws IOException {
		excelutil = new ExcelUtils();
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtctgry = homepg.navigateToProductCategoryPage();

	}
	@Test(priority = 1, enabled = true)
	public void ValidateTheMenuItemsDisplayedAddProductPage() {
		pdtctgry.ClickOnAddCategoryButton();
		pdtctgry.waitForCategory();
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
		pdtctgry.ClickOnSearchCategoryLink(catgrynm);
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), catgrynm,
				"Failure message : category name not matched");
	}
	@Test(priority = 3, enabled = true)
	public void validateEditButtonForCategoryDetails() {
		String pdtctryEdit = excelutil.readStringData("ProductCategory", 2, 1);
		String pdtctgrynm = excelutil.readStringData("ProductCategory", 3,1);
		pdtctgry.ClickOnSearchCategoryLink(pdtctryEdit);
		pdtctgry.ClickOnCategoryEditButton();
		pdtctgry.enterValueForCategryName(pdtctgrynm);
		pdtctgry.ClickOnSubmitEditButton();
		pdtctgry.ClickOnSearchCategoryLink(pdtctgrynm);
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), pdtctgrynm,
				"Failure message : category name not matched");
	}
	@Test(priority = 4, enabled = true)
	public void validateDeleteWaiterData() {
		String pdtctgryDlt = excelutil.readStringData("ProductCategory", 3,1);
		pdtctgry.ClickOnSearchCategoryLink(pdtctgryDlt);
		pdtctgry.ClickOnDeleteButton();
		pdtctgry.ClickOnSearchCategoryLink(pdtctgryDlt);
		Assert.assertEquals(pdtctgry.getCategryNameFromSearchResult(), AutomationConstants.ErrorMessage,
				"Failure message : category name not matched");
	}
}