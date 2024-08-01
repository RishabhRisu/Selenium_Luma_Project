package Project.ProjectLuma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePage {

	private WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void verifyHomePageLoadsCorrectly() {
		driver.get("https://magento.softwaretestingboard.com/");
		Assert.assertTrue(driver.getTitle().contains("Home"), "Home Page did not load correctly.");

	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
