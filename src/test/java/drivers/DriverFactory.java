package drivers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import io.github.bonigarcia.wdm.managers.FirefoxDriverManager;
import utilities.ConfigReader;

public class DriverFactory {

	private static WebDriver driver;
	
	public static WebDriver initDriver() {
		
		String browser = ConfigReader.getBrowser().toLowerCase();
		String executionEnvironment = ConfigReader.getExecutionEnvironment().toLowerCase();
		
		try {
			if(executionEnvironment.equals("local")) {
				
				switch(browser) {
				
					case "chrome":
					
						WebDriverManager.chromedriver().setup();
						
	        			ChromeOptions options=new ChromeOptions();	
	        			// Disable password popup
	        			Map<String, Object> prefs = new HashMap<>();
	        			prefs.put("credentials_enable_service", false);
	        			prefs.put("profile.password_manager_enabled", false);
	        	
	        			options.setExperimentalOption("prefs", prefs);
	        	
	        			options.addArguments("--disable-notifications");
	        			options.addArguments("--incognito");

						
						driver = new ChromeDriver(options);
						
					break;
					
					case"firefox":
						
						WebDriverManager.firefoxdriver().setup();
						
						driver =new FirefoxDriver();
				
					
					break;
					
					case"edge":
						
						WebDriverManager.edgedriver().setup();
						
						driver =new EdgeDriver();
				
					
					break;
				
					default : 
						
						throw new RuntimeException("Invalid browser: "+browser);
					
				}
						
			}
			else if(executionEnvironment.equals("remote"))
			{
				
			}
			else
			{
				throw new RuntimeException("Invalid Execution Environment: "+ executionEnvironment);
			}
			
		}catch(Exception e){
		
			throw new RuntimeException(e);
		
		}
		
		driver.manage().window().maximize();
		
		return driver;
		
	}
	
	public static WebDriver getDriver() {
		
		return driver;
		
	}
	
	
	public static void quitDriver() {
		
		if(driver!=null) {
			
			driver.quit();
			
			driver=null;
			
		}
		
	}
	
}
