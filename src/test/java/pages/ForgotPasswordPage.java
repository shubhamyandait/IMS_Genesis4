package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class ForgotPasswordPage extends BasePage{

	//constructor
	public ForgotPasswordPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	//pageObjects
	
	@FindBy(css=".login-title")
	private WebElement lblForgotPassword;

	@FindBy(xpath="")
	private WebElement txtEmail;
	
	@FindBy(xpath="")
	private WebElement btnRecoveryPassword;
	
	@FindBy(xpath="")
	private WebElement msgEmailValidation;
	
	@FindBy(xpath="")
	private WebElement msgForgotPasswordError;
	
	@FindBy(xpath="")
	private WebElement msgSuccess;
	
	
	//verification methods
	
	public boolean isForgotPasswordPageDisplayed() {
		
		return isDisplayed(lblForgotPassword);
		
	}
	
	
	public String getForgotPasswordErrorMessage() {
		
		return getText(msgForgotPasswordError);
		
	}
	
	public String getEmailValidationMessage() {
		
		return getText(msgEmailValidation);
	}
	
	public String getSuccessMessage() {
		
		return getText(msgSuccess);
		
	}
	
	//fields level methods
	
	public void enterEmail(String email) {
		
		type(txtEmail,email);
		
	}
	
	public void clickRecoveryPassword() {
		
		click(btnRecoveryPassword);
		
	}
	
	//business level methods
	
	public String RecoveryPassword(String email) {
		
		enterEmail(email);
		
		clickRecoveryPassword();
		
		return getSuccessMessage();
		
	}
	
	
}
