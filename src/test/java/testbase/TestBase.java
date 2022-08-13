package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public  WebDriver driver;
	private  String browser;
	private  String URL;
	public  Properties prop = new Properties();
	/*public static WebDriver getInstance() throws IOException
	{
		String path = "./src/main/java/config/config.properties";
		FileInputStream file = new FileInputStream(new File(path));
		
		prop.load(file); 
		browser = prop.getProperty("browser");
		URL = prop.getProperty("url.qa");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			String key="webdriver.chrome.driver";
			String value=prop.getProperty("chromeagent");
			System.setProperty(key, value);		
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			String key="webdriver.gecko.driver";
			String value=prop.getProperty("geckoagent");
			System.setProperty(key, value);		
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			String key="webdriver.edge.driver";
			String value=prop.getProperty("edgeagent");
			System.setProperty(key, value);		
			driver = new EdgeDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().setSize(new Dimension(412,914));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;	
	}*/
	public WebDriver getInstanceObject() throws IOException
	{
		String path = "./src/main/java/config/config.properties";
		FileInputStream file = new FileInputStream(new File(path));
		
		prop.load(file); 
		browser = prop.getProperty("browser");
		URL = prop.getProperty("url.qa");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			String key="webdriver.chrome.driver";
			String value=prop.getProperty("chromeagent");
			System.setProperty(key, value);		
			driver = new ChromeDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			String key="webdriver.gecko.driver";
			String value=prop.getProperty("geckoagent");
			System.setProperty(key, value);		
			driver = new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("edge"))
		{
			String key="webdriver.edge.driver";
			String value=prop.getProperty("edgeagent");
			System.setProperty(key, value);		
			driver = new EdgeDriver();
		}else
		{
			Throwable thr = new Throwable();
			thr.initCause(null);
		}
		driver.get(URL);
		driver.manage().window().maximize();
		//driver.manage().window().minimize();
		//driver.manage().window().setSize(new Dimension(412,914));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		return driver;	
	}
}

