package testcases;

import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;
import testbase.TestBase;
import utilities.TestUtility;

import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class MyInfoTest {
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private MyInfoPage info;
	private TestBase tb;
  @Test(description="Verify MyInfo Side Menu items", priority=1, 
		  groups={"Sanity","Regression"})
  public void getMyInfoSideMenuitems_005() throws IOException {
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(dp.isWelcomeDisplayed(),true);
	  info.clickOnMyInfoTab();
	  TestUtility.attachScreenshot(dr);
	  List<String> act = info.getSideMenuItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Personal Details");
	  exp.add("Contact Details");
	  exp.add("Emergency Contacts");
	  exp.add("Dependents");
	  exp.add("Immigration");
	  exp.add("Job");
	  exp.add("Salary");
	  exp.add("Tax Exemptions");
	  exp.add("Report-to");
	  exp.add("Qualifications");
	  exp.add("Memberships");
	  Reporter.log("Act: "+act);
	  Reporter.log("Exp: "+exp);
	  Assert.assertEquals(act, exp);
	  
	  
  }
  
  @Test(description="Verify My Info Side Menu Item count", priority=2, 
		  dependsOnMethods="getMyInfoSideMenuitems_005", groups="Regression")
  public void getMyInfoSideMenuitemsCount_007() throws IOException {
	  TestUtility.attachScreenshot(dr);
	  Assert.assertEquals(dp.isWelcomeDisplayed(),true);
	  info.clickOnMyInfoTab();
	  TestUtility.attachScreenshot(dr);
	  int act = info.getSideMenuItemCount();
	  int exp = 11;
	  Reporter.log("Act: "+act);
	  Reporter.log("Exp: "+exp);
	  Assert.assertEquals(act, exp);
	  
	  
  }
  @BeforeClass(alwaysRun=true)
  public void beforeClass() throws IOException {
	  tb = new TestBase();
	  dr = tb.getInstanceObject();
	  //dr = TestBase.getInstance();
	  lp = new LoginPage(dr);
	  dp = new DashboardPage(dr);
	  info = new MyInfoPage(dr);
	  TestUtility.attachScreenshot(dr);
	  lp.loginToApplication("Admin", "admin123");
  }

  @AfterClass(alwaysRun=true)
  public void afterClass() {
	  dp.logout();
	  dr.quit();
  }

}
