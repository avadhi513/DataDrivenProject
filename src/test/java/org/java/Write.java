package org.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write {
	
	public static void main(String[] args) throws IOException {
		
		// location
		File loc = new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\Test Excel.xlsx");

		Workbook w=new XSSFWorkbook();

		Sheet s=w.createSheet("Sheet 3");

		 Row r=s.createRow(6);
		 
		 Cell c=r.createCell(1);
		 
		 c.setCellValue("Selenium");
		 
		 FileOutputStream o= new FileOutputStream(loc);
		 
		 w.write(o);
		 
		 System.out.println("Completed");		
	}

}
