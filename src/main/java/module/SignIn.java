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

public class SignIn {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Getter
    @Setter
    @FindBy(xpath = "//header[@class='page-header']//ul[@class='header links']//li//a[contains(text(),'Sign In')]")
    private WebElement signInInButton;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextbox;

    @Getter
    @Setter
    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass' and @type='password']")
    private WebElement passwordTextBox;

    @Getter
    @Setter
    @FindBy(xpath = "(//div[@class='primary']//button[@id='send2'])[1]")
    private WebElement signInButton;

    public void signInInUsingCredentials(String email, String password) {
        signInInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(emailTextbox));
        emailTextbox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

}
