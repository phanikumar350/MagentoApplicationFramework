package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignIn {

    WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//header[@class='page-header']//ul[@class='header links']//li//a[contains(text(),'Sign In')]")
    WebElement signInInButton;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailTextbox;
    @FindBy(xpath = "//fieldset[@class='fieldset login']//input[@id='pass' and @type='password']")
    WebElement passwordTextBox;
    @FindBy(xpath = "(//div[@class='primary']//button[@id='send2'])[1]")
    WebElement signInButton;

    public void signInInUsingCredentials(String email, String password) {
        signInInButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement iframe = wait.until(ExpectedConditions.visibilityOf(emailTextbox));
        emailTextbox.sendKeys(email);
        passwordTextBox.sendKeys(password);
        signInButton.click();
    }

}
