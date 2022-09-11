package org.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base { // extended in integration class
	static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\driver\\chromedriver.exe");

		driver = new ChromeDriver();
		return driver;

	}

	public static void getUrl(String url) {
		driver.get(url);

	}

	public static void type(WebElement element, String value) {
		element.sendKeys(value);

	}

	public static void btnClick(WebElement element) {
		element.click();

	}

    public static String getData(int row,int cell) throws IOException {
		
		File loc =  new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\Test Excel.xlsx");
		
		
		FileInputStream f = new FileInputStream(loc);
		
		
		@SuppressWarnings("resource")
		Workbook w = new XSSFWorkbook(f);
		
		Sheet s =  w.getSheet("Sheet1");
		Row r= s.getRow(row);
		Cell c=r.getCell(cell);
		System.out.println(c);
		String value=null;
		int type=c.getCellType();
							
		if(type==1) {
			value=c.getStringCellValue();
		}    
	
		else if(type==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date getDate=c.getDateCellValue();
				SimpleDateFormat sim=new SimpleDateFormat("dd/MM/yyyy");
				value=sim.format(getDate);
				
			}
			
			else {
			double getNum=c.getNumericCellValue();
			long l=(long) getNum;
			 value=String.valueOf(l);	
		    }
	    }   
	return value;
			
    }

}