package com.test;

import org.testng.annotations.DataProvider;

import com.utilities.ExcelUtils;

public class DataWaiter {
	ExcelUtils excelutil= new ExcelUtils();
	@DataProvider
	public Object[][] dataWaitersAdd() {
		Object[][] data = new Object[3][4];
		data[0][0] = excelutil.readStringData("Waiter", 2, 1);
		data[0][1] = excelutil.readStringData("Waiter", 2, 2);
		data[0][2] = excelutil.readStringData("Waiter", 2, 3);
		data[0][3] = excelutil.readStringData("Waiter", 2, 4);
		data[1][0] = excelutil.readStringData("Waiter", 3, 1);
		data[1][1] = excelutil.readStringData("Waiter", 3, 2);
		data[1][2] = excelutil.readStringData("Waiter", 3, 3);
		data[1][3] = excelutil.readStringData("Waiter", 3, 4);		
		return data;
	}
	@DataProvider
	public Object[][] dataWaitersEdit() {
		Object[][] edit = new Object[2][1];		
		Object[][] data = new Object[2][4];
		edit[0][0] = excelutil.readStringData("Waiter", 2, 1);
		data[0][0] = excelutil.readStringData("Waiter", 4, 1);
		data[0][1] = excelutil.readStringData("Waiter", 4, 2);
		data[0][2] = excelutil.readStringData("Waiter", 4, 3);
		data[0][3] = excelutil.readStringData("Waiter", 4, 4);
		edit[0][0] =excelutil.readStringData("Waiter", 3, 1);
		data[1][0] = excelutil.readStringData("Waiter", 5, 1);
		data[1][1] = excelutil.readStringData("Waiter", 5, 2);
		data[1][2] = excelutil.readStringData("Waiter", 5, 3);
		data[1][3] = excelutil.readStringData("Waiter", 5, 4);
		
		return data;
	}
	@DataProvider
	public Object[][] dataWaiterDelete(){
		Object[][] delete= new Object[3][1];
		delete[0][0]=excelutil.readStringData("Waiter", 2, 1);
		delete[1][0]=excelutil.readStringData("Waiter", 3, 1);
		return delete;
		
	}
	
}
