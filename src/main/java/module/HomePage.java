package module;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    @FindBy
    By createAccountButton = By.xpath("//header[@class='page-header']//ul[@class='header links']//li//a[contains(text(),'Create an Account')]");
    @FindBy
    By closeadButton = By.xpath("//div[@id='dismiss-button' and @aria-label='Close ad']");
    @FindBy
    By frame_ads = By.xpath("(//iframe[contains(@id,'aswift')])[last()]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void createAccount() {
        driver.findElement(createAccountButton).click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(frame_ads));
            driver.switchTo().frame(iframe);

            // Wait for and click the close button inside the iframe
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeadButton));
            closeBtn.click();

            // Switch back to the main content
            driver.switchTo().defaultContent();
            WebElement closeAd = driver.findElement(closeadButton);
            if (closeAd.isDisplayed()) {
                closeAd.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

}
