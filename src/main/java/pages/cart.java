package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class cart {

	WebDriver driver;
	
	public cart(WebDriver driver) {
		//super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH,using = "//td[@class='product-name']//a")
	private WebElement prodName ; 
	
	@FindBy(how = How.XPATH,using = "//td[@data-title='Quantity']//input")
	private WebElement Quantity ; 
	
	@FindBy(how = How.XPATH,using = "//a[contains(text(),'Proceed to checkout')]")
	private WebElement btnProceedtoChkout ; 
	
	
	
	
	public String getProductName()
	{
		String name = prodName.getText();
		return name;
	}
	
	public int getProdCount()
	{
		int cnt = Integer.parseInt(Quantity.getAttribute("value"));
		return cnt;
	}
	
	public void clickCheckout()
	{
		btnProceedtoChkout.click();
	}
	
	

}
