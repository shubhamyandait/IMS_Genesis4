package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage{

	//constructor for initialize the driver
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
    // =====================================================
    // Page Objects
    // =====================================================
	@FindBy(css="#identity")
	private WebElement txtUsername;
	
	@FindBy(css="#password")
	private WebElement txtPassword;
	
	@FindBy(css="#login")
	private WebElement btnLogin;
	
	@FindBy(css=".login-title")
	private WebElement lblLogin;
	
	@FindBy(css=".forgot-password-link")
	private WebElement lnkForgotPassword;
	
	@FindBy(css="div .error_message p")
	private WebElement msgLoginError;
	
	@FindBy(xpath="//p[text()='Please enter your username']")
	private WebElement msgUsernameValidation;
	
	@FindBy(xpath="//p[text()='Please enter your password']")
	private WebElement msgPasswordValidation;
	
	
	
    // =====================================================
    // Page Objects
    // =====================================================
	public boolean isUsernameDisplayed() {
		
		return isDisplayed(txtUsername);
		
	}
	
	public boolean isLoginPageDisplayed() {
		
		return isDisplayed(txtUsername);
		
	}
	
	public boolean isForgotPasswordLinkDisplayed() {
		
		return isDisplayed(lnkForgotPassword);
		
	}
	
	public String getPageTitle() {
		
		return super.getPageTitle();
		
	}
	
	public String getLoginErrorMessage() {
		
		return getText(msgLoginError);
		
	}
	
	public String getUsernameValidationMessage() {
		
		return getText(msgUsernameValidation);
		
	}
	
	public String getPasswordValidationMessage() {
		
		return getText(msgPasswordValidation);
		
	}
	
	public String getPasswordFieldType() {
		
		return getAttribute(txtPassword, "type");
		
	}
	
    // =====================================================
    // Field Level Methods
    // =====================================================
	public void enterUsername(String username) {
		
		type(txtUsername,username);
		
	}
	
	public void enterPassword(String password) {
		
		type(txtPassword,password);
		
	}
	
	public void clickLogin() {
		
		click(btnLogin);
		
	}
	
	public ForgotPasswordPage clickForgotPassword() {
		
		  click(lnkForgotPassword);
		  
		  return new ForgotPasswordPage(driver);
		
	}
	
    // =====================================================
    // Business Level Methods
    // =====================================================
	
    /**
     * Login to Application
     */
	public DashboardPage Login(String username, String password) {
		
		enterUsername(username);
		
		enterPassword(password);
		
		clickLogin();
		
		wait.waitForPageLoad();
		
		return new DashboardPage(driver);
		
	}
	
	

}
