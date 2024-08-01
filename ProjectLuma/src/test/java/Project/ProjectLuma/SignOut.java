package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignOut {

	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
	}

	@Test
	public void signOut() throws InterruptedException {
		driver.findElement(By.linkText("Sign In")).click();
		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.id("send2")).click();

		String expectedUrl = "https://magento.softwaretestingboard.com/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed or redirected to incorrect URL");
		System.out.println("Login with valid credentials successful");

		WebElement accountDropdown = driver.findElement(By.xpath("//div[@class='panel header']//button[@type='button']"));
		accountDropdown.click();
		Thread.sleep(3000);

		WebElement signOutLink = driver.findElement(By.xpath("//a[contains(text(), 'Sign Out')]"));
		signOutLink.click();
		System.out.println("Test case 27: Application logged out successfully");

		waitForElement(By.linkText("Sign In"));
		Assert.assertTrue(driver.findElement(By.linkText("Sign In")).isDisplayed(),"Sign In button not found after logout");
		System.out.println("User is on the Sign In page after logout");
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	private void waitForElement(By by) {
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}
}
