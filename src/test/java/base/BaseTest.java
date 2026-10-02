package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import drivers.DriverFactory;
import utilities.ConfigReader;

public class BaseTest {

	protected WebDriver driver;
	public Logger logger;
	
    /**
     * Launch Browser
     */
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		
		logger = LogManager.getLogger(this.getClass());

		driver = DriverFactory.initDriver();
		
		driver.get(ConfigReader.getApplicationUrl());
		 
	}

	
    /**
     * Close Browser
     */
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		
		DriverFactory.quitDriver();
		
	}
	
	
}
