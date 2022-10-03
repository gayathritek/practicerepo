package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basetest {
	WebDriver driver;
	
	@BeforeMethod
	public void launch()
	{
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.tesla.com");
		driver.manage().window().maximize();
		String title = driver.getTitle();
		//System.out.println(title);
		Assert.assertEquals(title, "Electric Cars, Solar & Clean Energy | Tesla");
	}
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
}
