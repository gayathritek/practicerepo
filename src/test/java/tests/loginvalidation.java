package tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginvalidation {
	WebDriver driver;
    @BeforeClass
    public void launch() throws InterruptedException
    {
    	
    }
	
	@Test
	public void login() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
    	WebDriver driver = new ChromeDriver();
    	driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));	
		WebDriverWait wait = new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));		
		searchbox.sendKeys("ipho");
		Thread.sleep(5000);
	    List<WebElement> al = driver.findElements(By.xpath("//div[@class='autocomplete-results-container']//span"));
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='autocomplete-results-container']//span")));	
		for(int i=0; i<al.size(); i++) {		   	
		  System.out.println("ipho"+al.get(i).getText());
		}
		searchbox.clear();
		searchbox.sendKeys("iphone X");
		WebElement submit = driver.findElement(By.id("nav-search-submit-button"));
		submit.click();
		
		driver.findElement(By.linkText("Apple iPhone X, 64GB, Silver - For T-Mobile (Renewed)")).click();
	    WebElement sel = driver.findElement(By.id("quantity"));
	    wait.until(ExpectedConditions.visibilityOf(sel));
		Select quantity = new Select(sel);
		quantity.selectByVisibleText("3");
		driver.findElement(By.xpath("(//span[@id='submit.add-to-cart'])[1]//input")).click();
		wait.until(ExpectedConditions.visibilityOf(sel));
		WebElement not = driver.findElement(By.xpath("//span[@id='attachSiNoCoverage']//input"));
		wait.until(ExpectedConditions.visibilityOf(not));
		not.click();
		WebElement checkout = driver.findElement(By.xpath("//span[@id='attach-sidesheet-checkout-button']//input"));
		wait.until(ExpectedConditions.visibilityOf(checkout));
		checkout.click();
		WebElement newacc = driver.findElement(By.linkText("Create your Amazon account"));
		wait.until(ExpectedConditions.visibilityOf(newacc));
		newacc.click();
	
	}
	
	@AfterClass
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.close();
	}
	
}
