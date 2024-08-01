package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePassword {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();
		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Rishabh@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
		Thread.sleep(3000);
	}

	@Test
	public void changePassword() throws InterruptedException {
		// Change password
		WebElement act = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		act.click();
		driver.findElement(By.xpath("(//ul[@class='header links']//a)[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='box-actions']//a)[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("current_password")).sendKeys("Rishabh@143");
		driver.findElement(By.name("password")).sendKeys("Risu@143");
		driver.findElement(By.name("password_confirmation")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action save primary']")).click();
		Thread.sleep(2000); 
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.quit();
	}
}
