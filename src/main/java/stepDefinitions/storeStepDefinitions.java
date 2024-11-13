package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import context.Testcontext;
import pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class storeStepDefinitions {
	
	private Testcontext context;
	
	WebDriver driver;
	
	public storeStepDefinitions(Testcontext context)
	{
		this.driver = (WebDriver) context.driver;
	}
	
	//private WebDriver driver;
	
	
	
	
	 @Given("User landed in the store page")
	 public void landing_Storepage() throws IOException
	 {
		 BasePage base = new BasePage(driver);
		 //DriverFactory.initializeDriver("chrome");
		 String path = BasePage.getConfig("url");
		 base.appLoad(path);
		 System.out.println("The Application is successfuly launched "+path);
	 }
	 
	 @And("^User add \"(.*)\" product in to the cart$")
	 public void add_Products(String product) throws InterruptedException
	 {
		 Store store = new Store(driver);
		 store.addProducts(product);
		 
	 }

}
