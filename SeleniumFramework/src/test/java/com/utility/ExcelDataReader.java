package com.utility;

import java.io.*;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {
	
	XSSFWorkbook wb;
	
	public ExcelDataReader()
	{
		try 
		{
			File src=new File("./TestData/TestData.xlsx");
			FileInputStream fis = new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Unable to read excel file "+e.getMessage() );
		}
		
	}
	
	public String getStringData(int sheetIndex, int row, int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public String getStringData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}

}
