package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignOut {

    WebDriver driver;

    public SignOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//ul[@class='header links']//li[@class='customer-welcome']//span[@class='customer-name']/button)[1]")
    WebElement accountProfile;
    @FindBy(xpath = "//li[@class='customer-welcome active']//li//a[contains(text(),'Sign Out')]")
    WebElement signOutButton;

    public void clickSignOut() {

        accountProfile.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();
    }
}
