package pages;

import java.io.*;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverFactory;

public class BasePage {
	@SuppressWarnings("unused")
	WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	public void appLoad(String url)
	{
		driver.get(url);
	}
	
	
	public static String getConfig(String key) throws IOException
	{
		File file = new File(System.getProperty("user.dir")+File.separator+"config"+File.separator+"config.properties");
		
		FileInputStream fis = new FileInputStream(file);
		
		Properties prop = new Properties();
		
		prop.load(fis);
		
		//System.getProperty("Browser", "chrome");
		
		return prop.getProperty(key);
		
	}
	
	
	
	
	

}
