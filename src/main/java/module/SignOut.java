package module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignOut {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    public SignOut(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Getter
    @Setter
    @FindBy(xpath = "(//ul[@class='header links']//li[@class='customer-welcome']//span[@class='customer-name']/button)[1]")
    private WebElement accountProfile;

    @Getter
    @Setter
    @FindBy(xpath = "//li[@class='customer-welcome active']//li//a[contains(text(),'Sign Out')]")
    private WebElement signOutButton;

    public void clickSignOut() {
        accountProfile.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(signOutButton));
        signOutButton.click();
    }
}
