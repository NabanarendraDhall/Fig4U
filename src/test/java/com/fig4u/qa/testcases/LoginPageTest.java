package com.fig4u.qa.testcases;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fig4u.qa.base.TestBase;
import com.fig4u.qa.pages.HomePage;
import com.fig4u.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
   LoginPage loginPage;
    HomePage homePage;
	
	public LoginPageTest() throws IOException
	{
		super();
	}
	
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
		loginPage= new LoginPage();
		
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "FIG4U");
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCRMImage();
		Assert.assertTrue(flag);
	}
	
	
	@Test(priority=3)
	public void signUsernameErrorTest()
	{
		boolean flag=loginPage.signInUsernameError();
		Assert.assertTrue(flag);
		

	}
	
	
	
	@Test(priority=4)
	public void signPasswordErrorTest()
	{
		boolean flag=loginPage.signInPasswordError();
		Assert.assertTrue(flag);
		
	}
	
	@Test(priority=5)
	public void loginInvalidTest()
	{
		homePage=loginPage.loginInvalid(prop.getProperty("Invalidusername"), prop.getProperty("Invalidpassword"));
	}
	
	
	@Test(priority=6)
	public void loginTest()
	{
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
	//driver.quit();
	}
	
		
	
}