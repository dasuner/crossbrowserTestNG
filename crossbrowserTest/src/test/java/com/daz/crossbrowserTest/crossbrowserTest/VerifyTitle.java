package com.daz.crossbrowserTest.crossbrowserTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/*
 * @auther daz
 */

public class VerifyTitle {
	WebDriver driver;
    static String CHROME_PATH="drivers/chromedriver";
    static String URL="http://www.google.lk";
    
    @Test
    @Parameters("browser")
    public void VerifyPageTitle(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Safari"))
		{
			driver=new SafariDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", CHROME_PATH);
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		System.out.println(BrowserName+" : "+driver.getTitle());
		driver.quit();
	}

}
