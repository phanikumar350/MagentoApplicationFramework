package module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Getter
    @Setter
    @FindBy(xpath = "(//li[@class='greet welcome']//span[contains(text(), 'Welcome, ')])[1]")
    private WebElement header;

    @Getter
    @Setter
    @FindBy(xpath = "//div[@role='alert']//div[contains(normalize-space(text()),'Thank you for registering with Main Website Store.')]")
    private WebElement successMessage;

    public void isRegistrationSuccessful(String message) {
        try {
            boolean success = successMessage.isDisplayed() && header.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void isSignInSuccessful() {
        try {
            boolean success = header.isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
