package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import pages.component.LeftMenuComponent;

public class DashboardPage extends BasePage{

	private LeftMenuComponent leftMenuComponent;
	
	//constructor
	
	public DashboardPage(WebDriver driver) {
		
		super(driver);
	
		leftMenuComponent = new LeftMenuComponent(driver);
		
	}
	
	
	//PageObjects
	
	@FindBy(css="div .user-panel .info a")
	private WebElement lblLoggedInUser;
	
	@FindBy(xpath="//h1[text()='Dashboard']")
	private WebElement lblDashboard;
	
	
	//verification methods
	
	public boolean isDashboardPageDisplayed() {
		
		return isDisplayed(lblDashboard);
		
	}
	
	
	public String getLoggedInUser() {
		
		return getText(lblLoggedInUser);
		
	}
	
	
	//navigation methods
	public void openCustomer() {
		
		leftMenuComponent.openCustomer();
		
	}
	
	public void openSupplier() {
		
		
		
	}
	
	public void openUser() {
		
		
		
	}
}
