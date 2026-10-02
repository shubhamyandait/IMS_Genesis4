package utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {

	public String captureScreenshot(WebDriver driver, String testName) throws IOException {
		
		String screenshotPath = ConfigReader.getScreenshotPath()
								+ testName + "_"
								+ new JavaUtility().currentTimeStamps()
								+ ".png";
		
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		File destination = new File(screenshotPath);
		
		FileHandler.copy(source, destination);
		
		return screenshotPath;
		
	}
	
	
}
