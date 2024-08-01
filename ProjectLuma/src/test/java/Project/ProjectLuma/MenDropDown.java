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

public class MenDropDown {

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
    public void menDropdownSelectItem() {
        try {
            WebElement menDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Men']")));
            menDropdown.click();  

            WebElement jacketsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Jackets')]")));
            jacketsLink.click();

            WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@alt='Proteus Fitness Jackshirt']")));
            productImage.click();

            WebElement addToWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='product-addto-links']//a[@class='action towishlist']")));
            addToWishlistButton.click();

            // Print success message
            System.out.println("Item successfully added to the wishlist");
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
