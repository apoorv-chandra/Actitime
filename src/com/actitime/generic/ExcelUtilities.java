package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * 
 * @author Diganta
 *
 */
public class ExcelUtilities {
	
	static final String filePath=".\\testdata\\testData.xlsx"; 
	/**
	 * @description readData method read the data from testdata.xlsx based on sheet, row and cell.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String readData
	(String sheetName, int rowNum, int cellNum) 
	{
		String value="";
		try{
		Workbook wb = WorkbookFactory.create
				(new FileInputStream(new File(filePath)));
		value = wb.getSheet(sheetName).getRow
				(rowNum).getCell(cellNum).getStringCellValue();
		}
		catch(EncryptedDocumentException | 
				InvalidFormatException | IOException e){
			e.printStackTrace();
		}
		
		return value;
	}
}







