package com.fig4u.qa.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.fig4u.qa.base.TestBase;
import com.fig4u.qa.pages.HomePage;
import com.fig4u.qa.pages.LoginPage;
import com.fig4u.qa.util.TestUtil;

public class HomePageTest extends TestBase 

{
    LoginPage loginpage;
    HomePage homepage;
    TestUtil testUtil;

	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		testUtil=new TestUtil();
		homepage=new   HomePage();
		loginpage =new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle=homepage.verifyHomePageTilte();
		Assert.assertEquals(homePageTitle, "FIG4U");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
     
	 Assert.assertTrue(homepage.verifyCorrectUserName());
	
	}
	
	@Test(priority=3)
	public void verifyWidNoLinkTest()
	{
	
		homepage=homepage.clickOnWidNoLink();
		testUtil.windowHandle();
		
	}
	
	@Test(priority=4,dependsOnMethods = "verifyWidNoLinkTest")
	public void windowPop()
	{
	
		homepage=homepage.windowPop();
		testUtil.windowHandle();
		
	}
	
	
	@Test(priority=5,dependsOnMethods = "windowPop")
	public void searchWIDTest()
	{
		testUtil.windowHandle();
		homepage=homepage.searchWID();
		
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
	driver.quit();
	}
}