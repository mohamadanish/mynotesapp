
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {

	@Test
	public void register() {

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8090/mynotesapp/register.jsp");

		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing2");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"cfmPassword\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testing123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("99998888");
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("123 Testing");
		driver.findElement(By.xpath("//*[@id=\"register\"]")).click();

	}
	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
	}
	@Test
	public void updateUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		driver.findElement(By.linkText("ADMIN")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Test1");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test1");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Test1@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"address\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Test123");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("99988877");
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();

	}
	@Test
	public void deleteUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		driver.findElement(By.linkText("ADMIN")).click();
		driver.findElement(By.linkText("Delete")).click();
	}
	@Test
	public void updateProfile() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		driver.findElement(By.linkText("TESTING")).click();
		driver.findElement(By.linkText("Update")).click();
		driver.findElement(By.xpath("//*[@id=\"address\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Yishun");
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("88888888");
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
	}
	@Test
	public void logout() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8090/mynotesapp/login.jsp");
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		driver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		driver.findElement(By.linkText("LOGOUT")).click();
	}


	@BeforeTest
	public void beforeTest() {
		
	}

	@AfterTest
	public void afterTest() {
	}

}
