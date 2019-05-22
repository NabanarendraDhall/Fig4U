package com.fig4u.qa.pages;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fig4u.qa.base.TestBase;

public class LoginPage extends TestBase 
{

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Sign in')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@src='/assets/img/Fig4u-Logo.png']")
	WebElement fig4uLogo;
	
	@FindBy(xpath="//div[contains(text(),'Username is required.')]")
	WebElement usernameError;
	
	@FindBy(xpath="//div[contains(text(),'Password is required.')]")
	WebElement passwordError;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, LoginPage.this);
	}
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMImage()
	{
		return fig4uLogo.isDisplayed();
		
	}
	
	public boolean signInUsernameError()
	{
		loginBtn.click();
		return usernameError.isDisplayed();
		
	}
	
	public boolean signInPasswordError()
	{
		loginBtn.click();
		return passwordError.isDisplayed();
	}
	
	
	
	
	public HomePage loginInvalid(String un,String pwd)
	{
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.submit();
	return new HomePage();
	}

	
	
	public HomePage login(String un,String pwd)
	{
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginBtn.submit();
	return new HomePage();
	}
}