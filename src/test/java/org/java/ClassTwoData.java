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

public class ClassTwoData {
	
	// How to read the particular value from the excel
	public static void main(String[] args) throws IOException {
		
		// location
		File loc = new File("C:\\Users\\Aastha\\eclipse-workspace\\DataDrivenProject\\Excel\\Test Excel.xlsx");

		// read the input
		FileInputStream fis = new FileInputStream(loc);

		// set the workbook
		Workbook wk = new XSSFWorkbook(fis);

		// sheet
		Sheet sheet = wk.getSheet("Sheet1");

		for(int i=0; i< sheet.getPhysicalNumberOfRows(); i++) {
			
			Row row = sheet.getRow(i);
			for(int j=0; j< row.getPhysicalNumberOfCells(); j++) {
				Cell cell = row.getCell(j);
				System.out.println("Cell is: " +cell);
				
				// 1- string, 0 - number/ date
				int type = cell.getCellType();
				System.out.println("Cell type is: " +type);
				
				if(type == 1) {
					String sv = cell.getStringCellValue();
					System.out.println("string cell value is: " +sv);
				}
				
				else if(type==0) {
					
					if(DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy");
						String format = sim.format(date);
						System.out.println("Formatted sheet is: " +format);
					}
					
					else {
						double numCV = cell.getNumericCellValue();
						long l = (long)numCV;
						String val = String.valueOf(1);
						System.out.println("String value is: " +val);
					}
					
				}
	
			}
			
		}	
		
	}

}
