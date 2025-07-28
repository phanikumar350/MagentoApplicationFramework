package module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Signout {

    WebDriver driver;

    public Signout(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy
    By accountProfile = By.xpath("(//ul[@class='header links']//li[@class='customer-welcome']//span[@class='customer-name']/button)[1]");
    @FindBy
    By signOutButton = By.xpath("//li[@class='customer-welcome active']//li//a[contains(text(),'Sign Out')]");

    public void clickSignOut() {

        WebElement accountProfileButton = driver.findElement(accountProfile);
        accountProfileButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signOutButton)));
        driver.findElement(signOutButton).click();
    }
}
