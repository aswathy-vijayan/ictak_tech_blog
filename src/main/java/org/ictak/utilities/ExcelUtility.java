//package org.ictak.utilities;
//
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//public class ExcelUtility {
//
//    private static XSSFWorkbook excelWorkbook;
//    private static XSSFSheet excelSheet;
//
//    public static void setExcelFile(String filePath) throws IOException {
//        FileInputStream inp = new FileInputStream(filePath);
//        excelWorkbook = new XSSFWorkbook(inp);
//    }
//
//    public static String getCellData(int rowNum, int colNum) {
//        excelSheet = excelWorkbook.getSheetAt(0);
//        return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//    }
//}



//---------------------------------------------------------------------------------------------
//package org.ictak.utilities;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//public class ExcelUtility{
//	public static XSSFWorkbook excelWbook;
//	public static XSSFSheet excelSheet;
//	 
//	
//	public static String getData(int rowNum,int colNum) throws IOException {
//	
//	FileInputStream inp=new FileInputStream("C:\\Users\\Nithin Shaji\\eclipse-workspace\\ictproject\\ictak_tech_blog\\src\\main\\resources\\TestData.xlsx");
//		excelWbook=new XSSFWorkbook(inp);
//		excelSheet=excelWbook.getSheetAt(0);
//		
//		return excelSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//	} 
//	
//	
//}

// ----------------------------------------------------------------------------------

//package org.ictak.utilities;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import org.apache.poi.ss.usermodel.CellType;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//
//public class ExcelUtility {
//
//    private static XSSFSheet ExcelWSheet;
//
//    public static void setExcelFile(String path, String sheetName) throws IOException {
//        FileInputStream ExcelFile = new FileInputStream(new File(path));
//        XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
//        ExcelWSheet = ExcelWBook.getSheet(sheetName);
//    }
//
//    public static String getCellData(int rowNum, int colNum) {
//        if (ExcelWSheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.STRING) {
//            return ExcelWSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
//        } else if (ExcelWSheet.getRow(rowNum).getCell(colNum).getCellType() == CellType.NUMERIC) {
//            // Convert numeric value to string
//            return String.valueOf(ExcelWSheet.getRow(rowNum).getCell(colNum).getNumericCellValue());
//        } else {
//            return null; // Handle other cell types as needed
//        }
//    }
//}

//**************************************************************************************


package org.ictak.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private static XSSFSheet ExcelWSheet;

    public static void setExcelFile(String path, String sheetName) throws IOException {
        FileInputStream ExcelFile = new FileInputStream(new File(path));
        XSSFWorkbook ExcelWBook = new XSSFWorkbook(ExcelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
    }

    public static String getCellData(int rowNum, int colNum) {
        try {
            Cell cell = ExcelWSheet.getRow(rowNum).getCell(colNum);

            if (cell != null) {
                if (cell.getCellType() == CellType.STRING) {
                    return cell.getStringCellValue();
                } else if (cell.getCellType() == CellType.NUMERIC) {
                    // Convert numeric value to string
                    return String.valueOf(cell.getNumericCellValue());
                } else {
                    return null; // Handle other cell types as needed
                }
            } else {
                return null; // Cell is null
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Handle exceptions gracefully
        }
    }
}

