package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import testbase.TestBase;

public class TestUtility extends TestBase{

	public static void scrollToElement(WebElement ele, WebDriver driver)
	{
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", ele);
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)", "");
	}
	
	public static void clickOnElementJS(WebElement ele, WebDriver driver)
	{
		//JavascriptExecutor je = (JavascriptExecutor) driver;
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele);
	}
	
	public static void captureScreenshot(WebDriver driver) throws IOException
	{
		//TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Screenshots/"+getDate()+"_image.jpg"));
	}
	
	public static void attachScreenshot(WebDriver driver) throws IOException
	{
		//TakesScreenshot ts=(TakesScreenshot) driver;
		 String src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		 String imge ="<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		 Reporter.log(imge);
	}
	static String getDate()
	{
		Calendar s =  Calendar.getInstance();
		//System.out.println(s.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("Y_MMM_dd_HH_mm_ss_S");
		String ss = sdf.format(s.getTime());
		//System.out.println(ss);
		return ss;
	}
	
	public static void waitForElement(WebElement ele, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public static void waitForElementClickable(WebElement ele, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	public static void waitForElementInvisibility(WebElement ele, WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}

