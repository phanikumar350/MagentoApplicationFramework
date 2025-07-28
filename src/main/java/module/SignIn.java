package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignIn {

    WebDriver driver;

    public SignIn(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
    By siginInButton = By.xpath("//header[@class='page-header']//ul[@class='header links']//li//a[contains(text(),'Sign In')]");
    @FindBy
    By emailTextbox = By.xpath("//input[@id='email']");
    @FindBy
    By passwordTextBox = By.xpath("//fieldset[@class='fieldset login']//input[@id='pass' and @type='password']");
    @FindBy
    By signInButton = By.xpath("(//div[@class='primary']//button[@id='send2'])[1]");

    public void siginInUsingCreds(String email, String password) {
        driver.findElement(siginInButton).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(emailTextbox));

        driver.findElement(emailTextbox).sendKeys(email);
        driver.findElement(passwordTextBox).sendKeys(password);

        driver.findElement(signInButton).click();
    }

}
