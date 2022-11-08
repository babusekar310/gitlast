package com.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	public static WebDriver driver;
	
	public static void browserInteract() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}
	public static void openUrl(String url) {
		driver.get(url);
	}
	public static void toMaximize() {
		driver.manage().window().maximize();
	}
	public static String excelData(int r,int c) throws IOException {
		File file = new File("C:\\Users\\Babu\\eclipse-workspace\\DataDrivenProject\\data\\worksheet_sample.xlsx");
		
		FileInputStream fis = new FileInputStream(file);
		
		Workbook w = new XSSFWorkbook(fis);
		
		Sheet sheet = w.getSheet("Sheet1");
		
		Row row = sheet.getRow(r);
		
		Cell cell = row.getCell(c);
		
		int cellType = cell.getCellType();
		
		String value;
		
		if (cellType == 1) {
			value = cell.getStringCellValue();
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			
			SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
			value = sim.format(dateCellValue);
		}
		else {
			double numericCellValue = cell.getNumericCellValue();
			
			long l = (long)numericCellValue;
			
			value = String.valueOf(l);

		}
		
		return value;
		
		
	}

}
