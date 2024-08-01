package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddToCart {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() throws InterruptedException {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}

	@Test
	public void addProductToCart() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/radiant-tee.html");

		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();

		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
		Thread.sleep(5000);

		WebElement sizeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='option-label-size-143-item-167']")));
		sizeOption.click();

		WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='option-label-color-93-item-56']")));
		colorOption.click();

		WebElement qtyField = driver.findElement(By.id("qty"));
		qtyField.clear();
		qtyField.sendKeys("2");

		WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='product-addtocart-button']"));
		addToCartButton.click();
		Thread.sleep(5000);

		System.out.println("Add to Cart Successful");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
