import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.HomePage;
import pages.ProfilePage;

public class SwitchBetweenPagesTest {
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
    public void switchFromProfileToMainByLogo() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickLoginBtnHeader();
        profilePage.clickGoMainByClickLogo();
        Assert.assertEquals(true, homePage.seeH1CreateBurger());
    }

    @Test
    public void switchFromProfileToMainByConstructorBtn() {
        HomePage homePage = new HomePage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        driver.get("https://stellarburgers.nomoreparties.site/");
        homePage.clickLoginBtnHeader();
        profilePage.clickGoMainByClickConstructor();
        Assert.assertEquals(true, homePage.seeH1CreateBurger());
    }
}
