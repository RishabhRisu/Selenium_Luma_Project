package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SortBy {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");

		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();
		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com"); // Corrected email address
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
	}

	@Test
	public void sortByDropDown() throws InterruptedException {
		WebElement categoryLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='level-top ui-corner-all']//span)[10]")));
		categoryLink.click();
		Thread.sleep(3000);

		WebElement productLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='item']//a)[13]")));
		productLink.click();
		Thread.sleep(3000);

		WebElement sortByDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='sorter-options']")));
		sortByDropdown.sendKeys("Product Name");
		Thread.sleep(3000);

		WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='product-image-wrapper']//img)[7]")));
		productImage.click();
		Thread.sleep(3000);

		WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit']//span)[2]")));
		addToCartButton.click();
	}

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
