package Project.ProjectLuma;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SortPrice {

	private WebDriver driver;

	@BeforeClass
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void verifyHomePageLoadsCorrectly() throws InterruptedException {
		driver.get("https://magento.softwaretestingboard.com/");
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
		Thread.sleep(3000);

		Actions actions = new Actions(driver);
		WebElement categoryMenu = driver.findElement(By.xpath("//a[@id='ui-id-4']//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e']"));
		actions.moveToElement(categoryMenu).perform();
		WebElement subCategoryMenu = driver.findElement(By.xpath("//a[@id='ui-id-9']"));
		actions.moveToElement(subCategoryMenu).perform();
		driver.findElement(By.xpath("//a[@id='ui-id-11']")).click();
		driver.findElement(By.xpath("//div[normalize-space()='Price']")).click();
		driver.findElement(By.xpath("//div[11]//div[2]//ol[1]//li[2]//a[1]")).click();
		Thread.sleep(3000);

		Assert.assertTrue(driver.getPageSource().contains("Now Shopping by"), "Sort Price Filter failed.");
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
