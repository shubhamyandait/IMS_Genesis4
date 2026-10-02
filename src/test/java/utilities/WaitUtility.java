package utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

	private WebDriver driver;
	private WebDriverWait wait;
	
	public WaitUtility(WebDriver driver) {
		
		this.driver = driver;
		wait = new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getExplicitWait()));
		
	}
	
	public void waitForVisibility(WebElement element) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public void waitForInvisibility(WebElement element) {
		
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	public void waitForClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public void waitForAlert() {
		
		wait.until(ExpectedConditions.alertIsPresent());
		
	}
	
	public void waitForFrame(WebElement frame) {
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
		
	}
	
	public void waitForPageLoad() {
		
		WebDriverWait pageWait=new WebDriverWait(driver,Duration.ofSeconds(ConfigReader.getPageLoadTimeout()));
		
		pageWait.until(driver -> ((JavascriptExecutor)driver)
				.executeScript("return document.readyState")
				.equals("complete"));
		
	}
	
	public void fluentWait(WebElement element) {
		
		FluentWait<WebDriver> fluent=new FluentWait(driver)
		
		.withTimeout(Duration.ofSeconds(30))
		.pollingEvery(Duration.ofSeconds(2))
		.ignoring(StaleElementReferenceException.class);
		
		fluent.until(ExpectedConditions.visibilityOf(element));
		
		
	}
	
	
	
	
	
	
}
