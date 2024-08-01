package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Category {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifyProductCategoriesAccessible() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);

		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();

		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
		Thread.sleep(5000);

		driver.findElement(By.linkText("Men")).click();
		assert driver.getTitle().contains("Men") : "Product category is not accessible.";
		Thread.sleep(5000);

		driver.findElement(By.linkText("Women")).click();
		assert driver.getTitle().contains("Women") : "Product category is not accessible.";
		Thread.sleep(5000);

	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
