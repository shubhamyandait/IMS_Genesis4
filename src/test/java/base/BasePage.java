package base;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

//here we set up all the webelement common action along with waiting statergies

public class BasePage {

	protected WebDriver driver;
	protected WaitUtility wait;
	
	public BasePage(WebDriver driver) {
		
		this.driver = driver;
		wait = new WaitUtility(driver);
		
		PageFactory.initElements(driver,this);
		
	}
	
	/*
	 WebElement methods
	 */
	
	public void type(WebElement element, String value) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		element.clear();
		element.sendKeys(value);
		
	}
	
	public void click(WebElement element) {
		
		wait.waitForClickable(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		element.click();
		
	}
	
	public String getText(WebElement element) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		return element.getText();
		
	}
	
	public String getAttribute(WebElement element, String Attribute) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		return element.getAttribute(Attribute);
		
	}
	
	/*
	 verification methods
	 */
	
	public boolean isDisplayed(WebElement element) {
		
		try {
			
			wait.waitForVisibility(element);
			scrollToElement(element);
			highlightElement(element);
			
			return element.isDisplayed();
			
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean isEnabled(WebElement element) {
		
		try {
			wait.waitForVisibility(element);
			scrollToElement(element);
			highlightElement(element);
			
			return element.isEnabled();
		}catch(Exception e) {
			return false;
		}
		
	}
	
	public boolean isSelected(WebElement element) {
		
		try {
			wait.waitForVisibility(element);
			scrollToElement(element);
			highlightElement(element);
			
			return element.isSelected();
		}catch(Exception e) {
			return false;
		}		
		
	}
	
	
	/*
	 * select class methods
	 */
	public void selectByVisibleText(WebElement element, String text) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		new Select(element).selectByVisibleText(text);
		
	}

	public void selectByValue(WebElement element, String value) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		new Select(element).selectByValue(value);
		
	}
	
	public void selectByIndex(WebElement element, int index) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		new Select(element).selectByIndex(index);
		
	}
	
	public List<WebElement> getOptions(WebElement element){
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		return new Select(element).getOptions();
		
	}
	
	/*
	 * Alert methods
	 */
	public void acceptAlert() {
		
		wait.waitForAlert();
		
		driver.switchTo().alert().accept();
		
	}

	public void dismissAlert() {
		
		wait.waitForAlert();
		
		driver.switchTo().alert().dismiss();
		
	}
	
	public String getAlertText() {
		
		wait.waitForAlert();
		
		return driver.switchTo().alert().getText();
	}
	
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e) {
			return false;
		}
		
	}
	
	/*
	 Webdriver methods
	 */
	
	public String getPageTitle() {
		
		wait.waitForPageLoad();
		
		return driver.getTitle();
	}
	
	public String getPageUrl() {
		
		wait.waitForPageLoad();
		
		return driver.getCurrentUrl();
	}
	
	public String getPageSource() {
		
		wait.waitForPageLoad();
		
		return driver.getPageSource();
		
	}
	
	/*
	 * navigation methods
	 */
	public void nevigateForward() {
		
		driver.navigate().forward();
		
	}

	public void nevigateBack() {
		
		driver.navigate().back();
		
	}
	
	public void refreshPage() {
		
		driver.navigate().refresh();
		
	}

	
	/*
	 * frame methods
	 */
	public void switchToFrame(WebElement frame) {
		
		wait.waitForFrame(frame);
		
	}
	
	public void switchToParentFrame() {
		
		driver.switchTo().parentFrame();
		
	}
	
	public void switchToDefaultContent() {
		
		driver.switchTo().defaultContent();
		
	}
	
	
	/*
	 * window methods
	 */
	public void switchToWindow(String title) {
		
		for(String window : driver.getWindowHandles()) {
			
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title)) {
				break;
			}
			
		}
		
	}
	

	/*
	 * mouse methods
	 */
	public void moveToElement(WebElement element) {
		
		wait.waitForVisibility(element);
		scrollToElement(element);
		highlightElement(element);
		
		new Actions(driver).moveToElement(element).perform();
		
	}
	
	public void mouseClick(WebElement element) {
		
		wait.waitForVisibility(element);
		scrollToElement(element);
		highlightElement(element);
		
		new Actions(driver).click(element).perform();
		
	}
	
	public void rightClick(WebElement element) {
		
		wait.waitForVisibility(element);
		scrollToElement(element);
		highlightElement(element);
		
		new Actions(driver).contextClick(element).perform();
		
	}
	
	public void dragAndDrop(WebElement source, WebElement target) {
		
		wait.waitForVisibility(source);
		wait.waitForVisibility(target);
		new Actions(driver).dragAndDrop(source, target).perform();
		
	}
	
	public void pressEnter(WebElement element) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		element.sendKeys(Keys.ENTER);
		
	}
	
	public void pressTab(WebElement element) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		element.sendKeys(Keys.TAB);
		
	}
	
	/*
	 * JS Methods
	 */
	
	//JS Click
	public void jsClick(WebElement element) {
			
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		((JavascriptExecutor)driver)
					.executeScript("arguments[0].click();", element);
		
	}
	
	//scroll To element
	public void scrollToElement(WebElement element) {
		
		((JavascriptExecutor)driver)
					.executeScript("arguments[0].scrollIntoView({block:'center', inline:'nearest'});", element);
		
	}
	
	//highlight element
	public void highlightElement(WebElement element) {
												   
		((JavascriptExecutor)driver)
					.executeScript("arguments[0].style.border='2px solid red'", element);
		
	}
	
	
	public void retryClick(WebElement element) {
		
		wait.waitForVisibility(element);
		
		scrollToElement(element);
		highlightElement(element);
		
		int attempt = 0;
		
		while(attempt<3) {
			
			try {
				
				element.click();
				break;
				
			}catch(StaleElementReferenceException e) {
				attempt++;
			}
			
		}
		
	}
	

}
