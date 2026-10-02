package pages.component;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;
import pages.EditProfilePage;
import pages.LoginPage;

public class TopMenuComponent extends BasePage{

	public TopMenuComponent(WebDriver driver) {
		
		super(driver);
		
	}
	
	//pageObjects
	@FindBy(xpath = "")
	private WebElement iconProfile;
	
	@FindBy(xpath = "")
	private WebElement lnkEditProfile;
	
	@FindBy(xpath = "")
	private WebElement lnkLogout;
	
	
	//field level methods
	public EditProfilePage clickEditProfile() {
		
		click(lnkEditProfile);
		
		wait.waitForPageLoad();
		
		return new EditProfilePage(driver);
		
	}
	
	public LoginPage clickLogout() {
		
		click(lnkLogout);
		
		wait.waitForPageLoad();
		
		return new LoginPage(driver);
		
	}
	
	
	
}
