package module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    @Getter
    @Setter
    @FindBy(xpath = "//header[@class='page-header']//ul[@class='header links']//li//a[contains(text(),'Create an Account')]")
    private WebElement createAccountButton;

    @Getter
    @Setter
    @FindBy(xpath = "//div[@id='dismiss-button' and @aria-label='Close ad']")
    private WebElement closeAdButton;

    @Getter
    @Setter
    @FindBy(xpath = "(//iframe[contains(@id,'aswift')])[last()]")
    private WebElement frame_ads;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createAccount() {
        createAccountButton.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement iframe = wait.until(ExpectedConditions.visibilityOf(frame_ads));
            driver.switchTo().frame(iframe);

            // Wait for and click the close button inside the iframe
            WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(closeAdButton));
            closeBtn.click();

            // Switch back to the main content
            driver.switchTo().defaultContent();
            if (closeAdButton.isDisplayed()) {
                closeAdButton.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }
    }

}
