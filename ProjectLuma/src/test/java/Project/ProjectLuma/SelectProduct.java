package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SelectProduct {

	private WebDriver driver;
	private WebDriverWait wait;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/"); // Navigate to the base URL
	}

	@Test
	public void searchAndSelectProduct() {
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		searchBar.sendKeys("shirt");
		searchBar.submit();

		WebElement searchResult = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[2]/main[1]/div[3]/div[1]/div[2]/div[2]/ol[1]/li[1]")));
		Assert.assertTrue(searchResult.isDisplayed(), "Search result are not displayed.");

		searchResult.click();

		WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='product-item-link']")));
		Assert.assertTrue(productTitle.isDisplayed(), "Product detail page is not displayed.");
		System.out.println("Search Shirt And Page Open Successfull");
	}

	@Test
	public void searchAndSelectProductNegative() {
		WebElement searchBar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
		searchBar.sendKeys("nonexist");
		searchBar.submit();

		WebElement noResultsMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='base']")));
		Assert.assertTrue(noResultsMessage.isDisplayed(), "No result message is not displayed.");
		System.out.println("Verify The Invalid Search");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
