import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void clickBunsTabTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingsTab();
        homePage.clickBunsTab();
    }

    @Test
    public void clickFillingsTabTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickFillingsTab();
    }

    @Test
    public void clickSaucesTabTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        homePage.clickSaucesTab();
    }
}
