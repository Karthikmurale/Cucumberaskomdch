package DriverFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import context.Testcontext;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	static WebDriver driver;
	
	
	//private static ThreadLocal<WebDriver> Webdriver = new ThreadLocal<>();

	
	@SuppressWarnings("deprecation")
	public static WebDriver initializeDriver(String browser)
	{
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			System.out.println("Driver initialization has been completed successfully");
		}
		
		return driver;
	}
	
	
	/*
	 * public static WebDriver getDriver() { return Webdriver.get(); }
	 */
	

}
