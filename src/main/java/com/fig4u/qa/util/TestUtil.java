package com.fig4u.qa.util;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;

import com.fig4u.qa.base.TestBase;
import com.fig4u.qa.pages.HomePage;

public class TestUtil  extends TestBase
{

	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGE_LOAD_TIMEOUT = 30;

	
	public void windowHandle()
	{
		
	 
		String parent=driver.getWindowHandle();
		 
		// This will return the number of windows opened by Webdriver and will return Set of St//rings
		Set<String>s1=driver.getWindowHandles();
		 
		// Now we will iterate using Iterator
		Iterator<String> I1= s1.iterator();
		 
		while(I1.hasNext())
		{
		 
		String child_window=I1.next();	 
		if(!parent.equals(child_window))
		{
		driver.switchTo().window(child_window);
		System.out.println(driver.switchTo().window(child_window).getTitle());
		driver.manage().window().maximize();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.close();
	    }
        }	
		driver.switchTo().window(parent);		
	}

}
