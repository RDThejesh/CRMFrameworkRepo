package com.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName, int rownum, int celnum)throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
String data =wb.getSheet(sheetName).getRow(rownum).getCell(celnum).getStringCellValue();
		wb.close();
		return data;
	}


	public int getRowCount(String SheetName) throws Throwable
	{
	FileInputStream fis2 = new FileInputStream("./testData/testScriptData.xlxs");
	Workbook wb = WorkbookFactory.create(fis2);
	int rowCount = wb.getSheet(SheetName).getLastRowNum();
	wb.close();
	return rowCount;
	}
	
	public void setDataIntoExcel(String sheetName, int rownum, int celnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/testScriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rownum).createCell(celnum);
		
		FileOutputStream fos = new FileOutputStream("./testData/testScriptData.xlxs");
		wb.write(fos);
		wb.close();
	}
}
