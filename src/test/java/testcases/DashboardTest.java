package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class DashboardTest {
	
	private WebDriver dr;
	private LoginPage loginpage;
	private DashboardPage dp;
	private TestBase tb;
  @Test(description="Verify Quick Launch Items are available", priority=1, 
		  enabled=true, groups= "Regression")
  public void GetDashboardQuickLaunchItems_004() throws IOException {
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	  Assert.assertEquals(dp.getWelcomeMsg().contains("Welcome"), true);
	  List<String> act = dp.getQuickLaungeItems();
	  
	  List<String> exp = new ArrayList<String>();
	  exp.add("Assign Leave");
	  exp.add("Leave List");
	  exp.add("Timesheets");
	  exp.add("Apply Leave");
	  exp.add("My Leave");
	  exp.add("My Timesheet");
	  TestUtility.attachScreenshot(dr);
	  Reporter.log("Exp: "+exp);
	  Reporter.log("Act: "+act);
	  
	  Assert.assertEquals(act, exp);
	  
  }
  
  @Test(description="Verify Quick Launch Item Counts", priority=2, 
		  dependsOnMethods="GetDashboardQuickLaunchItems_004", enabled=true, 
		  groups={"Sanity","Regression"})
  public void GetDashboardQuickLaunchItemsCount_006() throws IOException {
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(dp.isWelcomeDisplayed(), true);
	  Assert.assertEquals(dp.getWelcomeMsg().contains("Welcome"), true);
	  TestUtility.attachScreenshot(dr);
	  int act = dp.getQuickLaungeItemCount();
	  Reporter.log("Exp: "+ 6);
	  Reporter.log("Act: "+act);
	  
	  Assert.assertEquals(act, 6);
	  
  }
  @Parameters({ "user","pass"})
  @BeforeClass(alwaysRun=true)
  public void beforeClass(String u, String p) throws IOException {
	  tb = new TestBase();
	  dr = tb.getInstanceObject();
	  //dr = TestBase.getInstance();
	  loginpage = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  //loginpage.loginToApplication("Admin", "admin123");
	  loginpage.loginToApplication(u, p);
	  
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  dp.logout();
	  dr.quit();
  }

}
