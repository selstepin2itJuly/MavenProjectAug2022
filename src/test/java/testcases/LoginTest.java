package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest {
	
	private WebDriver dr;
	private LoginPage loginPage;
	private DashboardPage dash;
	private ForgotPasswordPage fgp;
	private TestBase tb;
	
  @Test(description="Login Successfylly", priority=1, groups={"Sanity", "Regression"})
  public void LoginSuccess_001() throws IOException {
	  loginPage.loginToApplication("Admin", "admin123");
	  //dash.isWelcomeDisplayed();
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(dash.isWelcomeDisplayed(),true);
	  dash.logout();
  }
  
  @Test(description="Login Failure - Negative", priority=2, groups="Regression")
  public void LoginUnsuccessful_002() throws IOException {
	  loginPage.loginToApplication("Admin123", "admin123");
	  //dash.isWelcomeDisplayed();
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(loginPage.isErrorDisplayed(),true);
	  Assert.assertEquals(loginPage.getErrorText(), "Invalid credentials");
  }
  
  @Test(description= "Forgot Password Link", priority=3, groups="Regression")
  public void ForgotPassword_003() throws IOException {
	  TestUtility.attachScreenshot(dr);
	  loginPage.clickOnForgotPassword();
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(fgp.isForgotPasswordHeaderDisplayed(),true);
	  
  }
  
  @BeforeMethod(alwaysRun=true)
  public void beforeMethod() throws IOException {
	  tb = new TestBase();
	  dr = tb.getInstanceObject();
	  //dr = TestBase.getInstance();
	  loginPage = new LoginPage(dr);
	  dash = new DashboardPage(dr);
	  fgp = new ForgotPasswordPage(dr);
  }

  @AfterMethod(alwaysRun=true)
  public void afterMethod() {
	  
	  dr.quit();
  }

}
