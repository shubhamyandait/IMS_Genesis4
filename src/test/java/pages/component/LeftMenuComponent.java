package pages.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import pages.customer.CustomerPage;

public class LeftMenuComponent extends BasePage{

	//constructor
	public LeftMenuComponent(WebDriver driver){
		
		super(driver);
		
	}
	
	//pageObjects
	
	@FindBy(xpath="")
	private WebElement menuPeople;
	
	@FindBy(xpath="")
	private WebElement menuCustomer;
	
	@FindBy(xpath="")
	private WebElement menuSupplier;
	
	@FindBy(xpath="")
	private WebElement menuUser;
	
	
	//helper methods
	private void expandPeople() {
		
		if(!isDisplayed(menuCustomer)) {
			
			click(menuPeople);
			
		}
		
	}
	
	
	//nevigation methods
	public CustomerPage openCustomer() {
		
		expandPeople();
		
		click(menuCustomer);
		
		wait.waitForPageLoad();
		
		return new CustomerPage(driver);
		
	}
	
	
}
