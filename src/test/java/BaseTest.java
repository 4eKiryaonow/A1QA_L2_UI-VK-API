import hoard.ConfigManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public abstract class BaseTest {
    @BeforeMethod
    public void setUp() {
        getBrowser().goTo(ConfigManager.getUrlUI());
    }

    @AfterMethod()
    public void tearDown() {
        getBrowser().quit();
    }
}
