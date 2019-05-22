package com.fig4u.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.fig4u.qa.util.TestUtil;
import com.fig4u.qa.util.WebEventListener;
public class TestBase
{
	public static WebDriver driver=null;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public TestBase()
	{
	
	try
	{
	prop =new Properties();
	FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/com/fig4u/qa/config/config.properties");
	prop.load(ip);
	
	} catch (FileNotFoundException e)
	{
		e.printStackTrace();
	} catch(IOException e)
	{
		e.printStackTrace();
	}
	
}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\Users\\ajit.swami\\eclipse-workspace\\FIG4UPOM\\BrowserDriver\\chromedriver1.exe");
			 driver= new ChromeDriver();
		}
		
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
}