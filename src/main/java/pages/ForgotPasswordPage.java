package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {

	private WebDriver dr;
	public ForgotPasswordPage(WebDriver driver)
	{
		this.dr=driver;
		PageFactory.initElements(dr, this);
	}
	
	@FindBy(xpath="//h1[text()='Forgot Your Password?']")
	private WebElement headerText;
	
	public boolean isForgotPasswordHeaderDisplayed()
	{
		boolean b = false;
		try {
			b = headerText.isDisplayed();
		}catch(Exception e) 
		{
			e.printStackTrace();
		}
		return b;
	}
	
}
