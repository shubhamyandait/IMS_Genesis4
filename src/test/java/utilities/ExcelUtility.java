package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	String path;
	
	FileInputStream file;
	Workbook workbook;
	Sheet sheet;
	Row row;
	Cell cell;
	
	
	public ExcelUtility() {
		
		path = ConfigReader.getExcelPath();
		
	}
	
	
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		
		file = new FileInputStream(path);
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
		int rowNum = sheet.getLastRowNum();
		
		workbook.close();
		file.close();
		
		return rowNum;
		
	}

	public int getCellCount(String sheetName, int rowNum) throws EncryptedDocumentException, IOException {
		
		file = new FileInputStream(path);
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		int cellNum = row.getLastCellNum();
		
		workbook.close();
		file.close();
		
		return cellNum;
		
	}
	
	public String getCellData(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		file = new FileInputStream(path);
		workbook = WorkbookFactory.create(file);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		
		String data;
		DataFormatter formatter = new DataFormatter();
		
		try {
			data = formatter.formatCellValue(cell);
		}catch(Exception e){
			data="";
		}
		
		workbook.close();
		file.close();
		
		return data;
		
	}
	
	public Object[][] getSheetData(String sheetName) throws EncryptedDocumentException, IOException {
		
		int totalRows = getRowCount(sheetName);
		int totalCells = getCellCount(sheetName, 0);
		
		Object[][] data = new Object[totalRows][totalCells];
		
		//outer loop for rows and inner loop for the column
		for(int i=1;i<=totalRows;i++) {
			
			for(int j=0;j<totalCells; j++) {
				
				//one by the store the data in data two dimentional array 
				data[i-1][j] = getCellData(sheetName, i, j);
			}
			
		}
		
		
		return data;
	}
	
	
	
	
	
}
