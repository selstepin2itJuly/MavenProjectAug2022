package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver; 
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="txtUsername")
	private WebElement username;
	
	@FindBy(name="txtPassword")
	private WebElement password;

	@FindBy(css="input.button")
	private WebElement loginButton;
	
	@FindBy(css="[id='spanMessage']")
	private WebElement error;
	
	@FindBy(xpath="//div[@id='forgotPasswordLink']/child::*")
	private WebElement fgp;
	
	public void enterUsername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public void loginToApplication(String user, String pass)
	{
		enterUsername(user);
		enterPassword(pass);
		clickOnLoginButton();
	}

	public boolean isErrorDisplayed()
	{
		boolean b =false;
		try
		{
			b = error.isDisplayed();
		}catch(Exception e)
		{
			
		}
		return b;
	}
	
	public String getErrorText()
	{
		return error.getText().trim();
	}
	
	public void clickOnForgotPassword()
	{
		fgp.click();
	}
}
