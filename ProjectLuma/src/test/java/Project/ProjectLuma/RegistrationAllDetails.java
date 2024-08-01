package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationAllDetails {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/");
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Create an Account")).click();
		
		driver.findElement(By.id("firstname")).sendKeys("Rishabh");
		driver.findElement(By.id("lastname")).sendKeys("Gupta");
		Thread.sleep(3000);
		
		driver.findElement(By.id("email_address")).sendKeys("risugupta97@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Rishabh@143");
		Thread.sleep(3000);
		
		driver.findElement(By.id("password-confirmation")).sendKeys("Rishabh@143");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@title='Create an Account']")).click();
		
        System.out.println("Registration Successfull");

		driver.quit();

	}

}
