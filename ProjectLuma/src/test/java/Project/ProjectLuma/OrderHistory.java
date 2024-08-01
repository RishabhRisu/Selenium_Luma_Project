package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrderHistory {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Increased timeout for dynamic content
		driver.manage().window().maximize();
	}

	@Test
	public void verifyOrderHistory() throws InterruptedException {
		// Navigate to the website
		driver.get("https://magento.softwaretestingboard.com/");

		// Log in to the application
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]"))).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
		Thread.sleep(3000);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='panel header']//button[@type='button']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-hidden='false']//a[normalize-space()='My Account']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='My Orders']"))).click();
		Thread.sleep(3000);
		
		Assert.assertTrue(driver.getPageSource().contains("My Orders"), "Order History.");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
