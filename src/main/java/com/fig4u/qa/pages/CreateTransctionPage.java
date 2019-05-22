package com.fig4u.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fig4u.qa.base.TestBase;

public class CreateTransctionPage extends TestBase
{

	@FindBy(xpath="//span[text()='Transaction']")
	WebElement transactionLink;
	
	@FindBy(xpath="//a[contains(text(),'Create Productwise Transaction')]")
	WebElement createproductwiseLink;
	
	
	public CreateTransctionPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public CreateTransctionPage trnasactionClick()
	
	{
		transactionLink.click();
		return new CreateTransctionPage();
		
	}
	
}
