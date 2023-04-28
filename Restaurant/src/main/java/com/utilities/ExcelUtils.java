package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	final static String currentDir = System.getProperty("user.dir");
	static String filePath = currentDir + ".//src/test//resources//RestaurantDatas.xlsx";
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static FileInputStream fs;
	File file = new File(filePath);

	/**
	 * This method to get count row
	 * 
	 * @throws IOException
	 * 
	 */
	public void getNumberOfRows() throws IOException {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
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
			System.out.println(e.getMessage());
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
	public String readStringData(String sheetName, int rowNum, int colNum) throws IOException {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		String cellValue = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
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
	public int readIntegerData(String sheetName, int rowNum, int colNum) throws IOException {
		fs = new FileInputStream(file);
		workbook = new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);
		int cellValue = (int) sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
		return cellValue;
	}

}
