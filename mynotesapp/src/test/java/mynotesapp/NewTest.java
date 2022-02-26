package mynotesapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
  @Test
	public void f() {
		// define the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		// define the driver instance
		WebDriver driver = new ChromeDriver();

		// navigate the browser to this url
		driver.get("http://localhost:8090/mynotesapp/RemindersServlet/dashboard");

		// browser look for link with text value "Add new reminders"
		driver.findElement(By.linkText("Add New Reminders")).click();

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"startdate\"]")).sendKeys("23 Feb");

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"enddate\"]")).sendKeys("27 Feb");

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"task\"]")).sendKeys("Testing Automation");

		// browser look for link with text value "Add new reminders"
		// driver.findElement(By.linkText("Add reminder")).submit();
		driver.findElement(By.id("submit")).click();
	}
   
  
	public void g() {
		// define the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		// define the driver instance
		WebDriver driver = new ChromeDriver();

		// navigate the browser to this url
		driver.get("http://localhost:8090/mynotesapp/RemindersServlet/dashboard");

		// browser look for link with text value "Add new reminders"
		driver.findElement(By.linkText("Edit")).click();

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"startdate\"]")).clear();
		driver.findElement(By.xpath("//*[@name=\"startdate\"]")).sendKeys("1 Feb");

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"enddate\"]")).clear();
		driver.findElement(By.xpath("//*[@name=\"enddate\"]")).sendKeys("2 Feb");

		// find input and fill
		driver.findElement(By.xpath("//*[@name=\"task\"]")).clear();
		driver.findElement(By.xpath("//*[@name=\"task\"]")).sendKeys("Testing Automation 2");
		
	}
	
	public void h() {
		// define the chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		// define the driver instance
		WebDriver driver = new ChromeDriver();

		// navigate the browser to this url
		driver.get("http://localhost:8090/mynotesapp/RemindersServlet/dashboard");

		// browser look for link with text value "Add new reminders"
		driver.findElement(By.linkText("Delete")).click();
	}
  
  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

}
