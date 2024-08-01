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

public class FooterTerms {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/");
    }

    @Test(priority = 1)
    public void verifyFooterNotes() {
        WebElement footerNotes = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='footer-content']//div[contains(text(), 'Contact Us')]")));
        String footerText = footerNotes.getText();
        System.out.println("Footer Notes Text: " + footerText);
    }

    @Test(priority = 2)
    public void footerSearchTerm() {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='search']")));
        searchInput.sendKeys("Jackets");
        
        WebElement searchButton = driver.findElement(By.xpath("//button[@title='Search']"));
        searchButton.click();
        
        WebElement searchResults = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='page-title']")));
        System.out.println("Search Results Title: " + searchResults.getText());
    }

    @Test(priority = 3)
    public void footerPrivacyPolicy() {
        WebElement privacyPolicyLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Privacy Policy')]")));
        privacyPolicyLink.click();
        
        WebElement privacyPolicyHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Privacy Policy')]")));
        System.out.println("Privacy Policy Page Header: " + privacyPolicyHeader.getText());
    }

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
