package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteTheCart {

	WebDriver driver;

	@BeforeMethod
	void login() throws InterruptedException {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/\n");

		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();

		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();

		Thread.sleep(3000);
	}

	@Test
	void deleteCart() throws InterruptedException {
		WebElement cartIcon = driver.findElement(By.xpath("//a[@class='action showcart']"));
		cartIcon.click();

		Thread.sleep(2000);
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();

			while (true) {
				try {
					WebElement removeItemLink = driver.findElement(By.xpath("//a[@title='Remove item']"));
					removeItemLink.click();

					WebElement modalOkButton = driver.findElement(
							By.xpath("//footer[@class='modal-footer']//button[@class='action-primary action-accept']"));
					modalOkButton.click();

					Thread.sleep(2000);
				} catch (Exception e) {
					break;
				}
			}
		}
	}
}
