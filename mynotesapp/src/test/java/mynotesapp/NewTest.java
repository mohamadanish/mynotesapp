package mynotesapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
	@Test
//	public void register() {
//		
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//
//		
//		WebDriver driver = new ChromeDriver();
//		
//		driver.get("http://localhost:8090/mynotesapp/register.jsp");
//		
//		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing2");
//		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
//		driver.findElement(By.xpath("//*[@id=\"cfmPassword\"]")).sendKeys("testing123");
//		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testing123@gmail.com");
//		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("99998888");
//		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("123 Testing");
//		driver.findElement(By.xpath("//*[@id=\"register\"]")).click();
//
//	}

	//public void login() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.get("http://localhost:8090/mynotesapp/login.jsp");
		//driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		//driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		//.findElement(By.xpath("//*[@id=\"signin\"]")).click();
	//}
	
	public void updateUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		// define the drive instance
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		driver.findElement(By.linkText("ADMIN")).click();
		driver.findElement(By.linkText("Edit")).click();
	}
	

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
	}

}
