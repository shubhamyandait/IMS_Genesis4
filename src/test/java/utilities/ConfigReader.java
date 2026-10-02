package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private static Properties properties;
	
	static {
		
		try {
			
			FileInputStream file=new FileInputStream("./src/test/resources/config/config.properties");
			
			properties=new Properties();
			
			properties.load(file);
			
			file.close();
			
			
		}catch(IOException e) {
			
			throw new RuntimeException("unable to load Properties file" + e);
			
		}
		
	}
	
	
	private static String getProperty(String key) {
		
		return properties.getProperty(key).trim();
		
	}
	
	public static String getBrowser() {
		
		return getProperty("browser");
		
	}
	
	public static String getApplicationUrl() {
		
		return getProperty("app.url");
		
	}
	
	public static String getUsername() {
		
		return getProperty("app.username");
		
	}
	
	public static String getPassword() {
		
		return getProperty("app.password");
		
	}
	
	public static String getExecutionEnvironment() {
		
		return getProperty("execution_env");
		
	}
	
	public static String getGridUrl() {
		
		return getProperty("grid.url");
		
	}
	
	public static String getExcelPath() {
		
		return getProperty("excel.path");
		
	}
	
	public static String getScreenshotPath() {
		
		return getProperty("screenshot.path");
		
	}
	
	public static String getReportPath() {
		
		return getProperty("report.path");
		
	}
	
	public static long getImplicitWait() {
		
		return Long.parseLong(getProperty("implicit.wait"));
		
	}
	
	public static long getExplicitWait() {
		
		return Long.parseLong(getProperty("explicit.wait"));
		
	}
	
	public static long getPageLoadTimeout() {
		
		return Long.parseLong(getProperty("page.load.timeout"));
		
	}
}
