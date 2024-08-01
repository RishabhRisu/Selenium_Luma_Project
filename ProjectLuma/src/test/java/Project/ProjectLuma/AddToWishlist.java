package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToWishlist {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='authorization-link']//a)[1]"))).click();
		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
	}

	@Test
	public void addToWishlist() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search"))).sendKeys("Breathe Easy Tank");
		Thread.sleep(3000);

		// Click on the product image
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='product-image-wrapper']//img)[5]"))).click();
		Thread.sleep(3000);

		// Add product to the wishlist
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='action towishlist']//span)"))).click();
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
