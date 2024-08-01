package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchTheShirt {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		
		driver = new ChromeDriver();
	}

	@Test
	public void verifySearchFunctionality() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();

		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("shirt");
		searchBox.submit();
		Thread.sleep(5000);

		// Wait for the page to load and display search results

		assert driver.getPageSource().contains("shirt") : "Search functionality failed.";
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();

		}

	}

}
