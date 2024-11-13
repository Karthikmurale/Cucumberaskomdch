package stepDefinitions;
import pages.*;

import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import context.Testcontext;
import io.cucumber.java.en.Then;

public class cartstepDefinitions {
	
	private Testcontext context;
	WebDriver driver;
	
	public cartstepDefinitions(Testcontext context) {
		
		this.driver = (WebDriver) context.driver;
		
	}

	
	
	
	@Then("^User validates the Product \"(.*)\" and count \"(.*)\"$")
	public void ProductValidation(String ExpProductName,String ExpProductCount)
	{
		cart cartpage = new cart(driver);
		String actProdName = cartpage.getProductName();
		int actProdCnt = cartpage.getProdCount();
		if(actProdName.equalsIgnoreCase(actProdName) && actProdCnt== Integer.parseInt(ExpProductCount))
		{
			System.out.println("Pass - Product name "+actProdName+" and count "+actProdCnt+" are displayed as expected");
			cartpage.clickCheckout();
			System.out.println("Checkout button has been clicked successfully");
		}
		else
		{
			System.err.println("Fail - Product name "+actProdName+" and count "+actProdCnt+" are not displayed as expected");
		}
	}

}
