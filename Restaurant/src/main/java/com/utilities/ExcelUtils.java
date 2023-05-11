package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	final static String currentDir = System.getProperty("user.dir");
	static String filePath = currentDir + "\\src\\test\\resources\\RestaurantDatas.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file = new File(filePath);
	
	public ExcelUtils() {
		try {
			workbook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			throw new RuntimeException("Error During reading filepath");
		}
		sheet=workbook.getSheetAt(0);
	}

	/**
	 * This method to get count row
	 * 
	 * @throws IOException
	 * 
	 */
	public void getNumberOfRows()  {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error During reading file");
		}
		
		sheet = workbook.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println(rowCount);
	}

	/**
	 * This method is to count the column
	 * 
	 * @return
	 */
	public int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getLastCellNum();
		} catch (Exception e) {
			throw new RuntimeException("Error During reading file");
		}
		return colCount;
	}

	/**
	 * This method is to read string datas from excel sheet
	 * 
	 * @param fileName
	 * @param sheetname
	 * @param rowNum
	 * @param colNum
	 * @return
	 * @throws IOException
	 */
	public String readStringData(String sheetName, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error During reading file");
		}		
		sheet = workbook.getSheet(sheetName);
		String cellValue = sheet.getRow(rowNum-1).getCell(colNum-1).getStringCellValue();
		return cellValue;
	}

	/**
	 * This method is to read integer datas from excel sheet
	 * 
	 * @param fileName
	 * @param rowNum
	 * @param colNum
	 * @param sheetname
	 * @return
	 * @throws IOException
	 */
	public int readIntegerData(String sheetName, int rowNum, int colNum) {
		try {
			fs = new FileInputStream(file);
			workbook = new XSSFWorkbook(fs);
		} catch (IOException e) {
			throw new RuntimeException("Error During reading file");
		}		
		sheet = workbook.getSheet(sheetName);
		int cellValue = (int) sheet.getRow(rowNum-1).getCell(colNum-1).getNumericCellValue();
		return cellValue;
	}
}
