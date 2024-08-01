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

public class LastNameChange {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {

    	driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
        
        driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();
        driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Risu@143");
        driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();
    }

    @Test
    public void updateLastName() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//ul[@class='header links']//a)[1]"))).click();
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='nav item']//a)[5]"))).click();

            WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
            lastNameField.clear();
            lastNameField.sendKeys("G");

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit']//span)[2]"))).click();
            System.out.println("Last name update successfull");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
