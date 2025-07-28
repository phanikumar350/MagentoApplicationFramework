package driverManager;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


/**
 * A singleton class for initializing the WebDriver.
 * @author - Phani Kumar Peddimsetti
 */
public class DriverManager {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static WebDriver driver;

    private DriverManager() {

    }

    /**
     * @return DriverManager
     *  Returns the object of DriverManager to handle the WebDriver object as the DriverManager was created like a singleton class.
     */
    public static DriverManager getInstance() {
        return new DriverManager();
    }

    /**
     * @return WebDriver
     *  Initializes the object of WebDriver returns the same.
     */
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    /**
     *  Quits/Kills the object of WebDriver.
     */
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
