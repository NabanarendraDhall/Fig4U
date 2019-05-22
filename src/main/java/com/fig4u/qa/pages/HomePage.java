package com.fig4u.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.fig4u.qa.base.TestBase;

public class HomePage extends TestBase 
{

	@FindBy(xpath="//span[@class='usernamemdesk']")
	WebElement userNameLabel;
	
	@FindBy(xpath="(//td[text()='Pending']/following-sibling::td[1])[1]")
	WebElement widNoLink;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchBtn;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTilte()
	{
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName()
	
	{
	  return userNameLabel.isDisplayed();
		
	 }

	
	public HomePage clickOnWidNoLink()
	{
		
		widNoLink.click();
		return new HomePage();
		
	}
	
	public HomePage windowPop()
	{
	      String ele=widNoLink.getText();
		  return new HomePage();
			
	}
	
	public HomePage searchWID()
	{
		
		String ele=widNoLink.getText();
		searchBtn.click(); 
		searchBtn.sendKeys(ele);
		return new HomePage();
	
		
		
	
	}

}
	
	
