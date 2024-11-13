package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import context.Testcontext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.*;


public class checkoutstepDefinitions {
	
	private Testcontext context;
	WebDriver driver;
	
	public checkoutstepDefinitions(Testcontext context)
	{
		this.driver = (WebDriver) context.driver;
	}
	

	
	
	@And("User place order and verify the details")
	public void place_Order(DataTable UserDetails) throws InterruptedException
	{
		Checkout check = new Checkout(driver);
		List<List<String>> value = UserDetails.asLists();
		check.placeOrder(value);
		check.clickPlaceOrder();
		System.out.println("Place order button has been clicked successfully");
	}
	
	@And("^User capture the id and validate the message \"(.*)\"$")
	public void Capture_ValidateMessage(String message)
	{
		Checkout check = new Checkout(driver);
		Assert.assertEquals(check.getMessage(), message);
		System.out.println("The Order Id which has been captured is "+check.getOrderId());
	}
	
	
}
