package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

	private WebDriver dr;
	public DashboardPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;
	
	@FindBy(linkText="Logout")
	private WebElement logout;
	
	@FindBy(xpath="//div[@class='quickLaunge']/descendant::span")
	private List<WebElement> quickLaunge; 
	
	public boolean isWelcomeDisplayed()
	{
		boolean b = false;
		try {
			b = welcome.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	public String getWelcomeMsg()
	{
		return welcome.getText().trim();
	}
	public void logout()
	{
		welcome.click();
		logout.click();
	}
	
	public List<String> getQuickLaungeItems()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement e: quickLaunge)
		{
			tmp.add(e.getText().trim());
		}
		return tmp;
	}
	
	public int getQuickLaungeItemCount()
	{
		return quickLaunge.size();
	}
}
