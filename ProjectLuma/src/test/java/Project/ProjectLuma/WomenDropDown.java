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

public class WomenDropDown {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test
    public void womenDropDownSelectItem() {
        WebElement loginLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='authorization-link']//a)[1]")));
        loginLink.click();
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys("risugupta97@gmail.com");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("Risu@143"); 
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='action login primary']//span"));
        loginButton.click();

        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[1]")));
        dropdown.click();
        WebElement item = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='item']//a)[4]")));
        item.click();
        WebElement productImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//img[@class='product-image-photo'])[10]")));
        productImage.click();
        WebElement sizeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='swatch-option text'])[3]")));
        sizeOption.click();
        WebElement colorOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='swatch-option color'])[3]")));
        colorOption.click();
        WebElement addToWishlistButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@class='action towishlist']//span)[1]")));
        addToWishlistButton.click();

        System.out.println("Select women jacket item wishlist successfull");
    }

    @AfterMethod
    public void logOutPage() {
        WebElement accountMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='button'])[1]")));
        accountMenu.click();
        WebElement logoutLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//li[@class='authorization-link']//a)[1]")));
        logoutLink.click();
        driver.quit();
        System.out.println("Logout from the application successfull");
    }
}
