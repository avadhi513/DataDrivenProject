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

public class ReadData {

	// How to read the particular value from the excel
	public static void main(String[] args) throws IOException {

		// location
		File loc = new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\Test Excel.xlsx");

		// read the input
		FileInputStream fis = new FileInputStream(loc);

		// set the workbook
		Workbook wk = new XSSFWorkbook(fis);

		// sheet
		Sheet s = wk.getSheet("Sheet1");

		// rows
		Row r = s.getRow(1);
		
		// cells
		Cell c = r.getCell(1);
		System.out.println(c);

		
		// To find available rows and available columns in specific row
		int rows = s.getPhysicalNumberOfRows();
		System.out.println("Available rows: "+ rows);
		
		Row r1 = s.getRow(0);
		int cells = r1.getPhysicalNumberOfCells();
		System.out.println("Available cells: "+ cells);
		
		
		// How to print the data from specific row alone
		for(int i =0; i< s.getPhysicalNumberOfRows(); i++) {
			Cell cell = r.getCell(i);
			System.out.println("Get specific cell data: "+cell);
		}
		
		// To print the complete data in the rows
		for(int i=0; i< s.getPhysicalNumberOfRows(); i++) {
			Row r2 = s.getRow(i);
			for(int j=0; j< r2.getPhysicalNumberOfCells(); j++) {
				Cell c2 = r2.getCell(j);
				System.out.println(c2);
			}
			
		}
		
	}

}
