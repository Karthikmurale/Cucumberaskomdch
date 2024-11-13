package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import context.Testcontext;
import io.cucumber.datatable.DataTable;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Checkout{

	WebDriver driver;
	Testcontext context;
	
	public Checkout(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_first_name']")
	private WebElement txtFirstName;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_last_name']")
	private WebElement txtLastName;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_company']")
	private WebElement txtCompany;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_address_1']")
	private WebElement txtBillingAddress1;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_city']")
	private WebElement txtCity;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_postcode']")
	private WebElement txtZipCode;
	
	@FindBy(how = How.XPATH , using = "//input[@name='billing_email']")
	private WebElement txtEmailID;
	
	@FindBy(how = How.XPATH , using = "//label[@for='billing_country']/following-sibling::span")
	private WebElement drpCountry;
	
	@FindBy(how = How.XPATH , using = "//label[@for='billing_state']/following-sibling::span")
	private WebElement drpState;
	
	@FindBy(how = How.XPATH , using = "//button[@id='place_order']")
	private WebElement btnPlaceOrder;

	
	public void selectCountryValue(String option) throws InterruptedException
	{
		drpCountry.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(option);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='"+option+"']")).click(); 
		System.out.println("The option has been selected for Country dropdown is "+option);
	}
	
	public void selectStateValue(String option) throws InterruptedException
	{
		drpState.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@aria-autocomplete='list']")).sendKeys(option);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='"+option+"']")).click(); 
		System.out.println("The option has been selected for State dropdown is "+option);
	}
	
	public void placeOrder(List<List<String>> val) throws InterruptedException
	{
		txtFirstName.sendKeys(val.get(0).get(1));
		txtLastName.sendKeys(val.get(1).get(1));
		txtCompany.sendKeys(val.get(2).get(1));
		txtBillingAddress1.sendKeys(val.get(4).get(1));
		txtCity.sendKeys(val.get(5).get(1));
		txtZipCode.sendKeys(val.get(6).get(1));
		txtEmailID.sendKeys(val.get(7).get(1));
		this.selectCountryValue(val.get(3).get(1));
		this.selectStateValue(val.get(8).get(1));
		
	}
	
	public void clickPlaceOrder() throws InterruptedException
	{
		Thread.sleep(3000);
		btnPlaceOrder.click();
	}
	
	
	public String getMessage()
	{
		return driver.findElement(By.xpath("//div[@class='woocommerce-order']/p")).getText();
		
	}
	
	public int getOrderId()
	{
		return Integer.parseInt(driver.findElement(By.xpath("//li[contains(text(),'Order number')]/strong")).getText());
		
	}
	
	
}
