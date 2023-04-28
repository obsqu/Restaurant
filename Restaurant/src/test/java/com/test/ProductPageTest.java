package com.test;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.base.AutomationBase;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.ProductPage;
import com.utilities.BrowserUtils;
import com.utilities.ExcelUtils;
import com.utilities.PropertyUtil;
import com.utilities.WaitUtils;
import com.utilities.WebElementUtils;

public class ProductPageTest extends AutomationBase {

	WebDriver driver;
	LoginPage loginpg;
	HomePage homepg;
	BrowserUtils brwsrUtil;
	ProductPage pdtpage;
	SoftAssert soft = new SoftAssert();
	PropertyUtil property;
	Properties allProp;
	WaitUtils waitutil = new WaitUtils();
	ExcelUtils excelutil;

	@BeforeMethod
	public void preRun() throws IOException {
		driver = getDriver();
		loginpg = new LoginPage(driver);
		homepg = new HomePage(driver);
		property = new PropertyUtil();
		allProp = property.getAllProperties("config.properties");
		loginpg.performlogin(allProp.getProperty("username"), allProp.getProperty("password"));
		pdtpage = homepg.navigateToPdtPage();
		excelutil = new ExcelUtils();
	}
	@Test(priority = 1, enabled = true)
	public void validateElementsonAddProduct() throws Exception {
		pdtpage.clickOnAddProductButton();
		soft.assertTrue(pdtpage.isAddProductDisplayed(), "Failure Message: addProduct is not displayed");
		waitutil.waitForElementToBeClickable(driver, pdtpage.pdtype, 20);
		soft.assertTrue(pdtpage.isProductTypeDisplayed(), "Failure Message: ProductType is not displayed");
		waitutil.waitForElementToBeClickable(driver, pdtpage.pdtcode, 20);
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
	@Test(priority = 2, enabled = true)
	public void validateAddProductDetialsWithStockValue() throws InterruptedException, IOException {
		String pdtType = excelutil.readStringData("Products", 2, 1);
		String pdtCode = excelutil.readStringData("Products", 2, 2);
		String pdtName = excelutil.readStringData("Products", 2, 3);
		String pdtCategry = excelutil.readStringData("Products", 2, 4);
		String pdtSuplier = excelutil.readStringData("Products", 2, 5);
		String pdtPurchPrice = excelutil.readStringData("Products", 2, 6);
		String pdtTax = excelutil.readStringData("Products", 2, 7);
		String pdtTaxMethd = excelutil.readStringData("Products", 2, 8);
		String pdtPrice = excelutil.readStringData("Products", 2, 9);
		String pdtUnit = excelutil.readStringData("Products", 2, 10);
		String pdtAlrtQty = excelutil.readStringData("Products", 2, 11);
		String pdtOptn = excelutil.readStringData("Products", 2, 12);
		String pdtDescptn = excelutil.readStringData("Products", 2, 13);
		String mncqtity = excelutil.readStringData("Products", 2, 14);
		String mncprice = excelutil.readStringData("Products", 2, 15);
		pdtpage.clickOnAddProductButton();
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
		waitutil.waitForElementToBeClickable(driver, pdtpage.addpdt, 20);
		pdtpage.submitProductDetails();
		waitutil.waitForElementToBeClickable(driver, pdtpage.MNCstoreQuantity, 20);
		pdtpage.enterMNCStoreQuantity(mncqtity);
		waitutil.waitForElementToBeClickable(driver, pdtpage.MNCstorePrice, 20);
		pdtpage.enterMNCStorePrice(mncprice);
		waitutil.waitForElementToBeClickable(driver, pdtpage.storeSubmitonProduct, 20);
		pdtpage.StoreSubmit();
		brwsrUtil.refreshPage(driver);
		pdtpage.ProductSearch(pdtCode);
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(), pdtCode,
				"Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(), pdtName,
				"Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(),pdtCategry,
				"Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(), pdtDescptn,
				"Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(),pdtTax,
				"Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(), "30000.000 abc",
				"Failure Message: Product Price is not matched");
		soft.assertAll();
	}
	@Test(priority = 3, enabled = true)
	public void validateAddProductDetialsWithOutStockValues() throws IOException {
		String pdtType = excelutil.readStringData("Products", 3, 1);
		String pdtCode = excelutil.readStringData("Products", 3, 2);
		String pdtName = excelutil.readStringData("Products", 3, 3);
		String pdtCategry = excelutil.readStringData("Products",3, 4);
		String pdtSuplier = excelutil.readStringData("Products", 3, 5);
		String pdtPurchPrice = excelutil.readStringData("Products", 3, 6);
		String pdtTax = excelutil.readStringData("Products", 3, 7);
		String pdtTaxMethd = excelutil.readStringData("Products",3, 8);
		String pdtPrice = excelutil.readStringData("Products", 3, 9);
		String pdtUnit = excelutil.readStringData("Products", 3, 10);
		String pdtAlrtQty = excelutil.readStringData("Products", 3, 11);
		String pdtOptn = excelutil.readStringData("Products", 3, 12);
		String pdtDescptn = excelutil.readStringData("Products", 3, 13);
		pdtpage.clickOnAddProductButton();
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
		waitutil.waitForElementToBeClickable(driver, pdtpage.addpdt, 20);
		pdtpage.StoreSubmit();
		waitutil.waitForElementToBeClickable(driver, pdtpage.storeSubmitonProduct, 20);
		brwsrUtil.refreshPage(driver);
		pdtpage.ProductSearch(pdtCode);
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(), "1987",
				"Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(), "BBQQSSS",
				"Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(), "Pizza",
				"Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(), "Good Quality",
				"Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(), "10",
				"Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(), "110.000 abc",
				"Failure Message: Product Price is not matched");
		soft.assertAll();
	}
	@Test(priority = 4, enabled = true)
	public void ValidateEditProductDetails() {
		pdtpage.ProductSearch("786");
		pdtpage.editButtonClick();
		pdtpage.selectProductType("Service");
		pdtpage.addProductCode("1675");
		pdtpage.addProductName("Broasted");
		pdtpage.selectProductCategory("Pizza");
		pdtpage.addProductTax("30");
		pdtpage.selectProductTaxMethod("exclusive");
		pdtpage.addProductPrice("70");
		pdtpage.addProductOption("Supertaste");
		pdtpage.addProductDescription("Good,Quality");
		pdtpage.submitProdutEditDetails();
		pdtpage.ProductSearch("1675");
		soft.assertEquals(pdtpage.getProductCodeFromSearchResults(), "1675",
				"Failure Message: Product Code is not matched");
		soft.assertEquals(pdtpage.getProductNameFromSearchResults(), "Broasted",
				"Failure Message: Product Name is not matched");
		soft.assertEquals(pdtpage.getProductCategoryFromSearchResults(), "Pizza",
				"Failure Message: Product Category is not matched");
		soft.assertEquals(pdtpage.getProductDescriptionFromSearchResults(), "Good,Quality",
				"Failure Message: Product Description is not matched");
		soft.assertEquals(pdtpage.getProductTaxFromSearchResults(), "30",
				"Failure Message: Product Tax is not matched");
		soft.assertEquals(pdtpage.getProductPriceFromSearchResults(), "70.000 abc",
				"Failure Message: Product Price is not matched");
		soft.assertAll();
	}
	@Test(priority = 6, enabled = true)
	public void validateDeleteProductAction() {
		pdtpage.ProductSearch("1987");
		pdtpage.deleteProductDetails();
		pdtpage.ProductSearch("1987");
		Assert.assertEquals(pdtpage.getProductCodeFromSearchResults(), "No matching records found",
				"Failure Message: Product Code is not matched");
	}

}
