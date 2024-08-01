package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignIn {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();
		
		driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Risu@143");
		driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
		Thread.sleep(5000);

        System.out.println("Login Successfull");

		driver.quit();

	}

}
