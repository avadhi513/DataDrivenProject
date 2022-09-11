package org.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadUpdate {
	
	public static void main(String[] args) throws IOException {
		
		File loc = new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\Test Excel.xlsx");
		
		FileInputStream f = new FileInputStream(loc);
		
		Workbook w = new XSSFWorkbook(f);
		
		Sheet s = w.getSheet("Sheet 3");
		
		Row r = s.getRow(6);
		
		Cell c = r.getCell(1);
		
		String sv = c.getStringCellValue();
		
		if(sv.equals("Selenium")) {
			c.setCellValue("Java");
		}
				
		FileOutputStream o = new FileOutputStream(loc);
		
		w.write(o);
		System.out.println("Completed");
		
	}

}
