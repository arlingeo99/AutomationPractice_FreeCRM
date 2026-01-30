package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import base.BaseTest;


public class TestUtils extends BaseTest{
	
	public static long pageLoadTimeout = 30;
	public static long implicitWait = 20;
	
	public static String TestData_FilePath = System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\FreeCRMTestData.xlsx";
	
	 static Workbook book;
	 static Sheet sheet;
	
	
	public static Object[][] getContacts(String sheetname) throws FileNotFoundException
	{
		FileInputStream fis = null;
		try { fis = new FileInputStream(TestData_FilePath); }
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block e.printStackTrace(); }
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		int totalRows = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		
		//to format the data taken from the excel sheet
		DataFormatter format = new  DataFormatter();
		
		Object testData[][] = new Object[totalRows][totalCols];
		
		for(int i =1; i <= totalRows ;i++)
		{
			for(int j= 0; j < totalCols; j++)
			{
				testData[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		
		return testData;
	}
	
	public static Object[][] getDeals(String sheetname)
	{
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(TestData_FilePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		int totalRows = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		
		DataFormatter format = new DataFormatter();
		
		Object testdata[][] = new Object[totalRows][totalCols];
		
		for(int i =1; i <= totalRows ;i++)
		{
			for(int j= 0; j < totalCols; j++)
			{
				testdata[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		 return testdata;
	}

	public static Object[][] getTasks(String sheetname) throws FileNotFoundException
	{
		FileInputStream fis = null;
		try { fis = new FileInputStream(TestData_FilePath); }
		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block e.printStackTrace(); }
		}
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetname);
		
		int totalRows = sheet.getLastRowNum();
		Row rowCells = sheet.getRow(0);
		int totalCols = rowCells.getLastCellNum();
		
		//to format the data taken from the excel sheet
		DataFormatter format = new  DataFormatter();
		
		Object testData[][] = new Object[totalRows][totalCols];
		
		for(int i =1; i <= totalRows ;i++)
		{
			for(int j= 0; j < totalCols; j++)
			{
				testData[i-1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				
			}
		}
		
		return testData;
	}
	
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//screenshots/" + System.currentTimeMillis()+".png"));		
	}

	
	
}
