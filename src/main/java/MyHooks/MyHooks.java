package MyHooks;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import context.Testcontext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class MyHooks {
	
	WebDriver driver;
	private Testcontext context;
	
	public MyHooks(Testcontext context)
	{
		this.context = context;
	}
	
	@Before
	public void before()
	{
		driver = DriverFactory.initializeDriver("chrome");
		context.driver = driver;
		//driver = DriverFactory.getDriver();
	}
	
	@After
	public void after()
	{
		driver.quit();
	}
	

}
