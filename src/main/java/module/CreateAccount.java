package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    WebDriver driver;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='firstname']")
    WebElement firstName;
    @FindBy(xpath = "//input[@id='lastname']")
    WebElement lastName;
    @FindBy(xpath = "//input[@id='email_address']")
    WebElement email;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    WebElement confirmPassword;
    @FindBy(xpath = "//div[@class='primary']//child::button[@title='Create an Account']")
    WebElement createAnAccountButton;

    public void fillSignupForm(String firstName, String lastName, String email, String password) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.email.sendKeys(email);
        this.password.sendKeys(password);
        this.confirmPassword.sendKeys(password);
    }

    public void submitForm() {
        createAnAccountButton.click();
    }

}
