package base;

import driverManager.DriverManager;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private WebDriver driver;

    public WebDriver initializeDriver() {
        return DriverManager.getInstance().getWebDriver();
    }

    public void tearDown() {
        DriverManager.getInstance().tearDown();
    }
}
