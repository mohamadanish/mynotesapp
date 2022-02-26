package mynotesapp;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DeleteReminder {
	@Test
	public void f() {
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
