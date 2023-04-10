import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.ProfilePage;

@RunWith(Parameterized.class)
public class SwitchBetweenPagesTest {
    private static WebDriver driver;
    private final By btnToClick;
    static HomePage homePage = new HomePage(driver);

    public SwitchBetweenPagesTest(By btnToClick) {
        this.btnToClick = btnToClick;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {homePage.loginBtnHeader},
                {homePage.loginBtnMiddle},
        };
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        //   System.setProperty("webdriver.chrome.driver",        // Для запуска в Яндекс браузере
        //           "C:/cygwin64/home/bogat/chromedriver_110.exe");
        //   ChromeOptions options = new ChromeOptions();
        //   options.setBinary("C:/YandexBrowser/Application/browser.exe");
        //   options.addArguments("--remote-allow-origins=*");
        //   driver = new ChromeDriver(options);

    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void switchFromProfileToMainByLogo() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickSomeBtn(btnToClick);
        profilePage.clickGoMainByClickLogo();
        Assert.assertTrue(homePage.seeH1CreateBurger());
    }
}
