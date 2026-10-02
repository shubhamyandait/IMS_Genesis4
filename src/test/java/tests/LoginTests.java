package tests;

import org.apache.logging.log4j.LogManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import utilities.ConfigReader;

public class LoginTests extends BaseTest{

	LoginPage loginPage;
	DashboardPage dashboardPage;
	ForgotPasswordPage forgotPasswordPage;
	
	@BeforeMethod
	private void pageSetup() {

		loginPage = new LoginPage(driver);
		dashboardPage = new DashboardPage(driver);
		forgotPasswordPage = new ForgotPasswordPage(driver);
		
	}
	
	
	@Test(	priority=0,
			description="verify login with valid credentials",
			groups= {"smoke"},
			enabled = true
		)
	public void TC001_verify_login_with_valid_credentials() {
		
		logger.info("*******Login Start******");
		
		dashboardPage = loginPage.Login(ConfigReader.getUsername(), ConfigReader.getPassword());
		logger.info("****enter username****");
		logger.info("****enter password****");
		
		Assert.assertTrue(dashboardPage.isDashboardPageDisplayed(),"login failed");
		logger.info("****login successfull****");
		
	}
	
	@Test(	priority=1,
			description="verify login with Invalid username",
			groups= {"smoke"},
			enabled = true
		)
	public void TC002_verify_login_with_invalid_username() {
		
		loginPage.Login("invalidusername", ConfigReader.getPassword());
		
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"Incorrect username / password");
	}
	
	@Test(	priority=2,
			description="verify login with Invalid password",
			groups= {"smoke"},
			enabled = true
		)
	public void TC003_verify_login_with_invalid_password() {
		
		loginPage.Login(ConfigReader.getUsername(), "invalidpassword");
		
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"Incorrect username / password");
	}
	
	@Test(	priority=3,
			description="verify login with Invalid credentials",
			groups= {"smoke"},
			enabled = true
		)
	public void TC004_verify_login_with_invalid_password() {
		
		loginPage.Login("invalidusername", "invalidpassword");
		
		Assert.assertEquals(loginPage.getLoginErrorMessage(),"Incorrect username / password");
	}

	@Test(	priority=4,
			description="verify login with blank username",
			groups= {"smoke"},
			enabled = true
		)
	public void TC005_verify_login_with_blank_username() {
		
		loginPage.Login("", ConfigReader.getPassword());
		
		Assert.assertEquals(loginPage.getUsernameValidationMessage(),"Please enter your username");
	}

	@Test(	priority=5,
			description="verify login with blank password",
			groups= {"smoke"},
			enabled = true
		)
	public void TC006_verify_login_with_blank_password() {
		
		loginPage.Login(ConfigReader.getUsername(), "");
		
		Assert.assertEquals(loginPage.getPasswordValidationMessage(),"Please enter your password");
	}

	@Test(	priority=6,
			description="verify login with both blank",
			groups= {"smoke"},
			enabled = true
		)
	public void TC007_verify_login_with_both_blank() {
		
		loginPage.Login("", "");
		
		Assert.assertEquals(loginPage.getUsernameValidationMessage(),"Please enter your username");
		Assert.assertEquals(loginPage.getPasswordValidationMessage(),"Please enter your password");
	}
	
	@Test(	priority=7,
			description="verify forgot password link",
			groups= {"smoke"},
			enabled = true
		)
	public void TC008_verify_forgot_Password_link() {
		
		forgotPasswordPage = loginPage.clickForgotPassword();
		
		Assert.assertTrue(forgotPasswordPage.isForgotPasswordPageDisplayed(),"link failed");
			
	}


	@Test(	priority=8,
			description="verify forgot password link",
			groups= {"smoke"},
			enabled = true
		)
	public void TC009_verify_password_is_mask() {
		
		Assert.assertEquals(loginPage.getPasswordFieldType(),"password");
			
	}
	
}
