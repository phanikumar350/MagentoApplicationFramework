package module;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    public CreateAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='firstname']")
    private WebElement firstName;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='lastname']")
    private WebElement lastName;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='email_address']")
    private WebElement email;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @Getter
    @Setter
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmPassword;

    @Getter
    @Setter
    @FindBy(xpath = "//div[@class='primary']//child::button[@title='Create an Account']")
    private WebElement createAnAccountButton;

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
