
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class NewTest {
public WebDriver webDriver;
	@Test
	public void register() {

//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");

		

		
		webDriver.get("http://localhost:8090/mynotesapp/register.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"cfmPassword\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("testing123@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("99998888");
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("123 Testing");
		webDriver.findElement(By.xpath("//*[@id=\"register\"]")).click();

	}
	@Test
	public void login() {
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		webDriver.get("http://localhost:8090/mynotesapp/login.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
	}
	@Test
	public void updateUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		webDriver.get("http://localhost:8090/mynotesapp/login.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		webDriver.findElement(By.linkText("ADMIN")).click();
		webDriver.findElement(By.linkText("Edit")).click();
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Test1");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Test1");
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("Test1@gmail.com");
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Test123");
		webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("99988877");
		webDriver.findElement(By.xpath("//*[@id=\"save\"]")).click();

	}
	@Test
	public void deleteUser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		webDriver.get("http://localhost:8090/mynotesapp/login.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		webDriver.findElement(By.linkText("ADMIN")).click();
		webDriver.findElement(By.linkText("Delete")).click();
	}
	@Test
	public void updateProfile() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		webDriver.get("http://localhost:8090/mynotesapp/login.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123"); 
		webDriver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		webDriver.findElement(By.linkText("TESTING")).click();
		webDriver.findElement(By.linkText("Update")).click();
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"address\"]")).sendKeys("Yishun");
		webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).clear();
		webDriver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("88888888");
		webDriver.findElement(By.xpath("//*[@id=\"save\"]")).click();
	}
	@Test
	public void logout() {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		webDriver.get("http://localhost:8090/mynotesapp/login.jsp");
		webDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Testing");
		webDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("testing123");
		webDriver.findElement(By.xpath("//*[@id=\"signin\"]")).click();
		webDriver.findElement(By.linkText("LOGOUT")).click();
	}


	@BeforeTest
	public void beforeTest() {
		String chromeDriverDir = "C:\\Program Files\\Google\\Chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverDir);
		webDriver = new ChromeDriver();
	}

	@AfterTest
	public void afterTest() {
	}

}
