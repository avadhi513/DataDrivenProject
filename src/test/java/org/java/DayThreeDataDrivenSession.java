package org.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DayThreeDataDrivenSession {
	
	public static void main(String[] args) throws IOException {
		
		//locate file
		File locn = new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\test.xlsx");
		
		//read the input
		FileInputStream fis = new FileInputStream(locn);
		
		//set the workbook
		Workbook wk = new XSSFWorkbook(fis);
		
		//set sheet
		Sheet s = wk.getSheet("sample");
		
		//set rows
		Row r = s.getRow(2);
		
		//set cells
		Cell c = r.getCell(2);
		System.out.println(c);
		
		//to find available rows and columns in a specific cell
		int rows = s.getPhysicalNumberOfRows();
		System.out.println("Available rows: "+rows);
		
		Row r1 = s.getRow(0);
		int cells = r1.getPhysicalNumberOfCells();
		System.out.println("Available cells: "+ cells);
		
		// print data from a specific row alone
		for(int i=0; i<s.getPhysicalNumberOfRows(); i++) {
			Cell c1 = r.getCell(i);
			System.out.println(c1);
		}
		
		//complete data in a row
		for(int i=0; i< s.getPhysicalNumberOfRows(); i++) {
			
			Row r2 = s.getRow(i);
			for(int j=0; j< r2.getPhysicalNumberOfCells(); j++) {
				Cell c2 = r2.getCell(j);
				System.out.println(c2);
				
				int type = c2.getCellType();
				System.out.println(type);
			}
			
		}
		
	}

}
