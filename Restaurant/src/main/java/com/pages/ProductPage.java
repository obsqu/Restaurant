package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.WebElementUtils;
import com.utilities.GenericUtils;

public class ProductPage {

	WebDriver driver;
	WebElementUtils elementutil = new WebElementUtils();
	GenericUtils droputil = new GenericUtils();
	@FindBy(xpath = "//span[text()='Product']")
	public WebElement productlink;
	@FindBy(xpath = "//input[@class='form-control input-sm']")
	public WebElement pdtSearch;
	@FindBy(xpath = "//button[@class='btn btn-add btn-lg']")
	public WebElement addpdt;
	@FindBy(xpath = "//select[@id='Type']")
	public WebElement pdtype;
	@FindBy(xpath = "//input[@id='ProductCode']")
	public WebElement pdtcode;
	@FindBy(xpath = "//input[@id='ProductName']")
	public WebElement pdtname;
	@FindBy(xpath = "//select[@id='Category']")
	public WebElement pdtcategory;
	@FindBy(xpath = "//select[@name='supplier']")
	public WebElement pdtsupplier;
	@FindBy(xpath = "//input[@id='PurchasePrice']")
	public WebElement pdtpurchsprice;
	@FindBy(xpath = "//input[@id='Tax']")
	public WebElement pdttax;
	@FindBy(xpath = "//select[@id='taxType']")
	public WebElement pdttaxmethod;
	@FindBy(xpath = "//input[@id='Price']")
	public WebElement pdtprice;
	@FindBy(xpath = "//input[@id='Unit']")
	public WebElement pdtunit;
	@FindBy(xpath = "//input[@id='AlertQt']")
	public WebElement pdtalertqty;
	@FindBy(xpath = "//textarea[@id='ProductOptions']")
	public WebElement pdtoptin;
	@FindBy(xpath = "//input[@name='userfile']")
	public WebElement pdtimage;
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	public WebElement pdtDescription;
	@FindBy(xpath = "//label[@class='btn color02 active']")
	public WebElement pdtColor;
	@FindBy(xpath = "(//button[@class='btn btn-add'])[1]")
	public WebElement pdtsubmit;
	@FindBy(xpath = "(//button[@class='btn btn-default'])[3]")
	public WebElement pdtclose;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[1]")
	public WebElement productcode_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[2]")
	public WebElement productname_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[3]")
	public WebElement productcategory_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[4]")
	public WebElement productdescription_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[5]")
	public WebElement producttax_searchresult;
	@FindBy(xpath = "(//table[@id='Table']//tr//td)[6]")
	public WebElement productprice_searchresult;
	@FindBy(xpath = "(//input[@id='quantity'])[1]")
	public WebElement MNCstoreQuantity;
	@FindBy(xpath = "(//input[@id='pricestr'])[1]")
	public WebElement MNCstorePrice;
	@FindBy(xpath = "(//button[@class='btn btn-add hiddenpr'])[2]")
	public WebElement storeSubmitonProduct;
	@FindBy(xpath = "(//button[@class='btn btn-default hiddenpr'])[2]")
	public WebElement storeCloseonProduct;
	@FindBy(xpath = "//a[@class='btn btn-default'][1]")
	public WebElement crossButn;
	@FindBy(xpath = "//a[@class='btn btn-danger']")
	public WebElement deleteButn;
	@FindBy(xpath = "//a[@class='btn btn-default'][2]")
	public WebElement viewButn;
	@FindBy(xpath = "(//button[@class='btn btn-default hiddenpr'])[3]")
	public WebElement closeOnView;
	@FindBy(xpath = "//a[@class='btn btn-default'][3]")
	public WebElement editButn;
	@FindBy(xpath = "//button[@class='btn btn-default float-right']")
	public WebElement backOnEdit;
	@FindBy(xpath = "//button[@class='btn btn-green col-md-6 flat-box-btn waves-effect waves-button']")
	public WebElement submitOnEdit;
	@FindBy(xpath = "//a[@class='btn btn-default'][4]")
	public WebElement modifyButn;
	@FindBy(xpath = "//a[@class='btn btn-default'][5]")
	public WebElement barcodePrintBtn;
	@FindBy(xpath = "//select[@id='Brrows']")
	public WebElement colmnNumberOnBarcod;
	@FindBy(xpath = "//input[@id='Brnum']")
	public WebElement NumberOnBarcod;
	@FindBy(xpath = "(//button[@class='btn btn-add hiddenpr'])[3]")
	public WebElement submitOnBarcode;
	@FindBy(xpath = "(//button[@class='btn btn-add hiddenpr'])[4]")
	public WebElement printOnBarcode;
	@FindBy(xpath = "//span[text()='Print']")
	public WebElement printData;
	@FindBy(xpath = "//span[text()='Cancel']")
	public WebElement cancelPrintData;
	@FindBy(xpath = "(//a[@class='btn btn-add btn-xs'])[1]")
	public WebElement downloadCSv;
	@FindBy(xpath = "(//a[@class='btn btn-add btn-xs'])[2]")
	public WebElement uploadCSv;
	@FindBy(xpath = "//a[@class='btn btn-red btn-xs']")
	public WebElement printMenu;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean isProductLinkisDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, productlink);
		return flag;
	}
	public boolean isAddProductDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, addpdt);
		return flag;
	}
	public void clickOnAddProductButton() {
		elementutil.clickonTheElement(driver, addpdt);
	}
	public boolean isProductTypeDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtype);
	}
	public boolean isProductCodeDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtcode);
	}
	public boolean isProductNameDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtname);
	}
	public boolean isProductCategoryDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtcategory);
	}
	public boolean isProductSupplierDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtsupplier);
	}
	public boolean isProductPurchasePriceDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtpurchsprice);
	}
	public boolean isProductTaxDisplayed() {
		return elementutil.isElementDisplayed(driver, pdttax);
	}
	public boolean isProductTaxMethodDisplayed() {
		return elementutil.isElementDisplayed(driver, pdttaxmethod);
	}
	public boolean isProductPriceDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtprice);
	}
	public boolean isProductUnitDisplayed() {
		return elementutil.isElementDisplayed(driver, pdtunit);
	}
	public boolean isProductAlertqtyDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, pdtalertqty);
		return flag;
	}
	public boolean isProductOptionsDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, pdtoptin);
		return flag;
	}
	public boolean isProductImageinputDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, pdtimage);
		return flag;
	}
	public boolean isProductDescriptionDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, pdtDescription);
		return flag;
	}
	public boolean isProductSubmitDisplayed() {
		boolean flag = elementutil.isElementDisplayed(driver, pdtsubmit);
		return flag;
	}
	public void selectProductType(String pdtTypeValue) {
		elementutil.cleartheFieldd(driver, pdtype);
		droputil.elememtSelectbyVisibleText(driver, pdtype, pdtTypeValue);
	}
	public void addProductCode(String pdtCodeValue) {
		elementutil.cleartheFieldd(driver, pdtcode);
		elementutil.enteringValuetoElements(driver, pdtcode, pdtCodeValue);
	}
	public void addProductName(String pdtNameValue) {
		elementutil.cleartheFieldd(driver, pdtname);
		elementutil.enteringValuetoElements(driver, pdtname, pdtNameValue);
	}
	public void selectProductCategory(String pdtCatgryValue) {
		elementutil.cleartheFieldd(driver, pdtcategory);
		droputil.elememtSelectbyVisibleText(driver, pdtcategory, pdtCatgryValue);
	}
	public void selectProductSupplier(String pdSupplierVal) {
		droputil.elememtSelectbyValue(driver, pdtsupplier, pdSupplierVal);
	}
	public void enterProductPurchasePrice(String purchPriceVal) {
		elementutil.cleartheFieldd(driver, pdtpurchsprice);
		elementutil.enteringValuetoElements(driver, pdtpurchsprice, purchPriceVal);
	}
	public void addProductTax(String pdtTaxValue) {
		elementutil.cleartheFieldd(driver, pdttax);
		elementutil.enteringValuetoElements(driver, pdttax, pdtTaxValue);
	}
	public void selectProductTaxMethod(String pdttaxmthdValue) {
		elementutil.cleartheFieldd(driver, pdttaxmethod);
		droputil.elememtSelectbyVisibleText(driver, pdttaxmethod, pdttaxmthdValue);
	}
	public void addProductPrice(String pdtPriceValue) {
		elementutil.cleartheFieldd(driver, pdtprice);
		elementutil.enteringValuetoElements(driver, pdtprice, pdtPriceValue);
	}
	public void enterProductUnit(String pdUnitVal) {
		elementutil.enteringValuetoElements(driver, pdtunit, pdUnitVal);
	}
	public void enterAlertQuantity(String AlertQtyVal) {
		elementutil.cleartheFieldd(driver, pdtalertqty);
		elementutil.enteringValuetoElements(driver, pdtalertqty, AlertQtyVal);
	}
	public void addProductOption(String pdtOptionValue) {
		elementutil.cleartheFieldd(driver, pdtoptin);
		elementutil.enteringValuetoElements(driver, pdtoptin, pdtOptionValue);
	}
	public void addProductDescription(String pdtDescripValue) {
		elementutil.cleartheFieldd(driver, pdtDescription);
		elementutil.enteringValuetoElements(driver, pdtDescription, pdtDescripValue);
	}
	public void submitProductDetails() {
		elementutil.clickonTheElement(driver, pdtsubmit);
	}
	public void closeProductDetails() {
		elementutil.clickonTheElement(driver, pdtclose);
	}
	public void ProductSearch(String value) {
		elementutil.enteringValuetoElements(driver, pdtSearch, value);
	}
	public String getProductCodeFromSearchResults() {
		return elementutil.getingtheText(driver, productcode_searchresult);
	}
	public String getProductNameFromSearchResults() {
		return elementutil.getingtheText(driver, productname_searchresult);
	}
	public String getProductCategoryFromSearchResults() {
		return elementutil.getingtheText(driver, productcategory_searchresult);
	}
	public String getProductDescriptionFromSearchResults() {
		return elementutil.getingtheText(driver, productdescription_searchresult);
	}
	public String getProductTaxFromSearchResults() {
		return elementutil.getingtheText(driver, producttax_searchresult);
	}
	public String getProductPriceFromSearchResults() {
		return elementutil.getingtheText(driver, productprice_searchresult);
	}
	public void enterMNCStoreQuantity(String mncstrqty) {
		elementutil.enteringValuetoElements(driver, MNCstoreQuantity, mncstrqty);
	}
	public void enterMNCStorePrice(String mncstrprice) {
		elementutil.enteringValuetoElements(driver, MNCstorePrice, mncstrprice);
	}
	public void StoreSubmit() {
		elementutil.clickonTheElement(driver, storeSubmitonProduct);
	}
	public void StoreClose() {
		elementutil.clickonTheElement(driver, storeCloseonProduct);
	}
	public void viewProductDetails() {
		elementutil.clickonTheElement(driver, viewButn);
	}
	public void closeProductViewPage() {
		elementutil.clickonTheElement(driver, closeOnView);
	}
	public void editButtonClick() {
		elementutil.clickonTheElement(driver, editButn);
	}
	public void submitProdutEditDetails() {
		elementutil.clickonTheElement(driver, submitOnEdit);
	}
	public void deleteProductDetails() {
		elementutil.clickonTheElement(driver, crossButn);
		elementutil.clickonTheElement(driver, deleteButn);
	}
	public void ClickModifyButon() {
		elementutil.clickonTheElement(driver, modifyButn);
	}
	public void ClickBarCodeReader() {
		elementutil.clickonTheElement(driver, barcodePrintBtn);
	}
	public void enterColumnNumberForBarcode(String colValOnBarcode) {
		droputil.elememtSelectbyVisibleText(driver, colmnNumberOnBarcod, colValOnBarcode);
	}
	public void NumberForBarcode(String numberVal) {
		elementutil.cleartheFieldd(driver, NumberOnBarcod);
		elementutil.enteringValuetoElements(driver, NumberOnBarcod, numberVal);
	}
	public void submitButnOnBarcode() {
		elementutil.clickonTheElement(driver, submitOnBarcode);
	}
	public void printButnOnBarcode() {
		elementutil.clickonTheElement(driver, printOnBarcode);
	}
}
