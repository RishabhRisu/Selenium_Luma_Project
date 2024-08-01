package Project.ProjectLuma;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class InvalidSearch {

    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testInvalidSearch() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/");
        
        driver.findElement(By.xpath("(//li[@class='authorization-link']//a)[1]")).click();
        driver.findElement(By.id("email")).sendKeys("risugupta97@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Risu@143");
        driver.findElement(By.xpath("//button[@class='action login primary']//span")).click();

        Thread.sleep(5000); 

        driver.findElement(By.id("search")).sendKeys("shirtwww");
        driver.findElement(By.cssSelector("button[title='Search']")).click();

        WebElement noResultsMessage = driver.findElement(By.cssSelector("#maincontent > div.page-title-wrapper > h1 > span"));
        Assert.assertTrue(noResultsMessage.isDisplayed(), "No results message not displayed");

        System.out.println("Verify The Invalid Search Input");
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
