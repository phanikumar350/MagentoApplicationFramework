package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CreateAccount {

    WebDriver driver;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
    By firstName = By.xpath("//input[@id='firstname']");
    @FindBy
    By lastName = By.xpath("//input[@id='lastname']");
    @FindBy
    By email = By.xpath("//input[@id='email_address']");
    @FindBy
    By password = By.xpath("//input[@id='password']");
    @FindBy
    By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    @FindBy
    By createAnAccountButton = By.xpath("//div[@class='primary']//child::button[@title='Create an Account']");

    public void fillSignupForm(String firstName, String lastName, String email, String password) {
        driver.findElement(this.firstName).sendKeys(firstName);
        driver.findElement(this.lastName).sendKeys(lastName);
        driver.findElement(this.email).sendKeys(email);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(this.confirmPassword).sendKeys(password);
    }

    public void submitForm() {
        driver.findElement(this.createAnAccountButton).click();
    }

}
