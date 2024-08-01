package Project.ProjectLuma;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenTheApplication {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/\n");
		
        System.out.println("Run application Proper");
		
		driver.quit();

	}

}
