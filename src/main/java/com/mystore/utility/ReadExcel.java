/**
 * 
 */
package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */
public class ReadExcel {
	public void readExcel() throws Exception{
		String ExcelPath="C:\\Workspace\\projects\\Dissertation_2020wa15946\\TestData.xlsx";
		String fileNameString="TestData";
		String sheetName ="AccountCreationData";
		
		File file=new File(ExcelPath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		
		XSSFSheet sheet=wb.getSheet(sheetName);
		
		int totalRowCount = sheet.getLastRowNum();
		
		System.out.println("total rows"+totalRowCount);
		
	}

}
