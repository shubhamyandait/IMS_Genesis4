package utilities;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name="LoginData")
	public Object[][] getLoginData() throws EncryptedDocumentException, IOException{
		
		String sheetName = "";
		
		ExcelUtility excel=new ExcelUtility();
		
		return excel.getSheetData(sheetName);
		
	}
	
	
}
