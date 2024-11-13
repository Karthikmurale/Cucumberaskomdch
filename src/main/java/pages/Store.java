package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import DriverFactory.DriverFactory;

public class Store {
	
	 WebDriver driver;

	public Store(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(how = How.XPATH , using = "//h2[text()='Blue Tshirt']/parent::a/following-sibling::a")
	private WebElement BlueTshirt;
	
	@FindBy(how = How.XPATH , using = "//a[@title='View cart']")
	private WebElement ViewCart;
	
	
	public void addProducts(String ProductName) throws InterruptedException
	{
		WebElement prod = driver.findElement(By.xpath("//h2[text()='"+ProductName+"']/parent::a/following-sibling::a"));
		//wait.until(ExpectedConditions.elementToBeClickable(prod));
		prod.click();
		Thread.sleep(5000);
		//WebElement vCart = DriverFactory.getDriver().findElement(By.xpath("//a[@title='View cart']"));
		//wait.until(ExpectedConditions.elementToBeClickable(vCart));
		ViewCart.click();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//h2[text()='"+ProductName+"']/parent::a/following-sibling::a"))).click();
		//wait.until(ExpectedConditions.elementToBeClickable(ViewCart)).click();
		//ViewCart.click();
		System.out.println("The Product "+ProductName+" has been added to the cart");
	}
	
	

}
