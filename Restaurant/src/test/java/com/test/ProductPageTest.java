package com.test;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.constants.AutomationConstants;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;

public class ProductPageTest extends AutomationBase {

	LoginPage loginpg;
	HomePage homepg;
	BrowserUtils brwsrUtil = new BrowserUtils();
	ProductPage pdtpage;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	ExcelUtils excelutil = new ExcelUtils();
	
	@Test(priority = 1, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateElementsOnAddProduct() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtpage = homepg.navigateToPdtPage();
		pdtpage.clickOnAddProductButton();
		soft.assertTrue(pdtpage.isAddProductDisplayed(), "Failure Message: addProduct is not displayed");
		pdtpage.WaitProductpage();
		soft.assertTrue(pdtpage.isProductTypeDisplayed(), "Failure Message: ProductType is not displayed");
		soft.assertTrue(pdtpage.isProductCodeDisplayed(), "Failure Message: ProductCode is not displayed");
		soft.assertTrue(pdtpage.isProductNameDisplayed(), "Failure Message: ProductName is not displayed");
		soft.assertTrue(pdtpage.isProductCategoryDisplayed(), "Failure Message: ProductCategory is not displayed");
		soft.assertTrue(pdtpage.isProductSupplierDisplayed(), "Failure Message: ProductSupplier is not displayed");
		soft.assertTrue(pdtpage.isProductPriceDisplayed(), "Failure Message: ProductPrice is not displayed");
		soft.assertTrue(pdtpage.isProductPurchasePriceDisplayed(),
				"Failure Message: ProductPurchasePrice is not displayed");
		soft.assertTrue(pdtpage.isProductTaxDisplayed(), "Failure Message: ProductTax is not displayed");
		soft.assertTrue(pdtpage.isProductTaxMethodDisplayed(), "Failure Message: ProductTaxMethod is not displayed");
		soft.assertTrue(pdtpage.isProductUnitDisplayed(), "Failure Message: ProductUnit is not displayed");
		soft.assertTrue(pdtpage.isProductOptionsDisplayed(), "Failure Message: ProductOption is not displayed");
		soft.assertTrue(pdtpage.isProductAlertqtyDisplayed(), "Failure Message: ProductAlertQuantity is not displayed");
		soft.assertTrue(pdtpage.isProductDescriptionDisplayed(),
				"Failure Message: ProductDescription is not displayed");
		pdtpage.closeProductDetails();
		soft.assertAll();
	}
	@Test(priority = 2, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateAddProductDetialsWithStockValue() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtpage = homepg.navigateToPdtPage();
		pdtpage.clickOnAddProductButton();
		String pdtType = excelutil.readStringData("Products", 2, 1);
		String pdtCode = excelutil.readStringData("Products", 2, 2);
		String pdtName = excelutil.readStringData("Products", 2, 3);
		String pdtCategry = excelutil.readStringData("Products",2,4);
		String pdtSuplier = excelutil.readStringData("Products", 2,5);
		String pdtPurchPrice = excelutil.readStringData("Products", 2,6);
		String pdtTax = excelutil.readStringData("Products", 2, 7);
		String pdtTaxMethd = excelutil.readStringData("Products", 2,8);
		String pdtPrice = excelutil.readStringData("Products", 2, 9);
		String pdtUnit = excelutil.readStringData("Products", 2, 10);
		String pdtAlrtQty = excelutil.readStringData("Products",2, 11);
		String pdtOptn = excelutil.readStringData("Products", 2, 12);
		String pdtDescptn = excelutil.readStringData("Products",2, 13);
		String mncqtity = excelutil.readStringData("Products", 2, 14);
		String mncprice = excelutil.readStringData("Products", 2, 15);
		pdtpage.selectProductType(pdtType);
		pdtpage.addProductCode(pdtCode);
		pdtpage.addProductName(pdtName);
		pdtpage.selectProductCategory(pdtCategry);
		pdtpage.selectProductSupplier(pdtSuplier);
		pdtpage.enterProductPurchasePrice(pdtPurchPrice);
		pdtpage.addProductTax(pdtTax);
		pdtpage.selectProductTaxMethod(pdtTaxMethd);
		pdtpage.addProductPrice(pdtPrice);
		pdtpage.enterProductUnit(pdtUnit);
		pdtpage.enterAlertQuantity(pdtAlrtQty);
		pdtpage.addProductOption(pdtOptn);
		pdtpage.addProductDescription(pdtDescptn);
		pdtpage.submitProductDetails();
		pdtpage.enterMNCStoreQuantity(mncqtity);
		pdtpage.enterMNCStorePrice(mncprice);
		pdtpage.StoreSubmit();
		brwsrUtil.refreshPage(driver);
		pdtpage.ProductSearch(pdtCode);
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(), pdtCode,
				"Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(), pdtName,
				"Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(), pdtCategry,
				"Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(), pdtDescptn,
				"Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(), pdtTax,
				"Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(), "50.000 x8fmv",
				"Failure Message: Product Price is not matched");
		soft.assertAll();
	}

	@Test(priority = 3, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void ValidateEditProductDetails() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtpage = homepg.navigateToPdtPage();
		String pdtCodeEdit = excelutil.readStringData("Products", 2, 2);
		String pdtType = excelutil.readStringData("Products", 3, 1);
		String pdtCode = excelutil.readStringData("Products", 3, 2);
		String pdtName = excelutil.readStringData("Products", 3, 3);
		String pdtCategry = excelutil.readStringData("Products",3,4);
		String pdtSuplier = excelutil.readStringData("Products", 3,5);
		String pdtPurchPrice = excelutil.readStringData("Products", 3,6);
		String pdtTax = excelutil.readStringData("Products", 3, 7);
		String pdtTaxMethd = excelutil.readStringData("Products",3,8);
		String pdtPrice = excelutil.readStringData("Products", 3, 9);
		String pdtUnit = excelutil.readStringData("Products", 3, 10);
		String pdtAlrtQty = excelutil.readStringData("Products",3, 11);
		String pdtOptn = excelutil.readStringData("Products", 3, 12);
		String pdtDescptn = excelutil.readStringData("Products",3, 13);
		pdtpage.ProductSearch(pdtCodeEdit);
		pdtpage.editButtonClick();
		pdtpage.selectProductType(pdtType);
		pdtpage.addProductCode(pdtCode);
		pdtpage.addProductName(pdtName);
		pdtpage.selectProductCategory(pdtCategry);
		pdtpage.selectProductSupplier(pdtSuplier);
		pdtpage.enterProductPurchasePrice(pdtPurchPrice);
		pdtpage.addProductTax(pdtTax);
		pdtpage.selectProductTaxMethod(pdtTaxMethd);
		pdtpage.addProductPrice(pdtPrice);
		pdtpage.addProductOption(pdtOptn);
		pdtpage.addProductDescription(pdtDescptn);
		pdtpage.submitProdutEditDetails();
		pdtpage.ProductSearch(pdtCode);
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(), pdtCode,
				"Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(), pdtName,
				"Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(), pdtCategry,
				"Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(), pdtDescptn,
				"Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(), pdtTax,
				"Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(), "150.000 x8fmv",
				"Failure Message: Product Price is not matched");
		soft.assertAll();
	}

	@Test(priority = 4, enabled = true,retryAnalyzer = com.analyzer.RetryAnalyzer.class)
	public void validateDeleteProductDatas() {
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtpage = homepg.navigateToPdtPage();
		String pdtCodeDlt = excelutil.readStringData("Products", 3, 2);	
		pdtpage.ProductSearch(pdtCodeDlt);
		pdtpage.deleteProductDetails();
		pdtpage.ProductSearch(pdtCodeDlt);
		Assert.assertEquals(pdtpage.getProductCodeFromSearchResults(), AutomationConstants.ErrorMessage,
				"Failure Message: Product Code is not matched");
	}
}
