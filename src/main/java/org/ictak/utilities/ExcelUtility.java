package org.ictak.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static XSSFSheet ExcelWSheet;

	public static void setExcelFile(String path, String sheetName) throws IOException {
		FileInputStream ExcelFile = new FileInputStream(new File(path));
		XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
		ExcelWSheet = ExcelWBook.getSheet(sheetName);
		ExcelWBook.close();
	}

	public static String getCellData(int rowNum, int colNum) {
		if (ExcelWSheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.STRING) {
			return ExcelWSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
		} else if (ExcelWSheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.NUMERIC) {
			// Convert numeric value to string
			return String.valueOf(ExcelWSheet.getRow(rowNum).getCell(colNum).getNumericCellValue());
		} else {
			return null; // Handle other cell types as needed
		}
	}
}