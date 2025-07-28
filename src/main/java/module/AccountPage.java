package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
    By header = By.xpath("(//li[@class='greet welcome']//span[contains(text(), 'Welcome, ')])[1]");
    @FindBy
    By successMessage = By.xpath("//div[@role='alert']//div[contains(normalize-space(text()),'Thank you for registering with Main Website Store.')]");

    public void isRegistrationSuccessful(String message) {
        try {
            boolean success = driver.findElement(successMessage).isDisplayed() && driver.findElement(header).isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void isSignInSuccessful() {
        try {
            boolean success = driver.findElement(header).isDisplayed();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
