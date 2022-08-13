package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {

	private WebDriver dr;
	public MyInfoPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(css="#menu_pim_viewMyDetails")
	private WebElement myInfoTab;
	
	@FindBy(css="#sidenav>li>a")
	private List<WebElement> sideNav;
	
	public void clickOnMyInfoTab()
	{
		myInfoTab.click();
	}
	
	public List<String> getSideMenuItems()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement e:sideNav)
		{
			tmp.add(e.getText().trim());
		}
		
		return tmp;
	}
	
	public int getSideMenuItemCount()
	{
		return sideNav.size();
	}
}
