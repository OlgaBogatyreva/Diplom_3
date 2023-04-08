import api.UserSteps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegistrationPage;


@RunWith(Parameterized.class)
public class RegistrationTest {

    private WebDriver driver;
    private final String name;
    private final String email;
    private final String password;
    private final boolean isRegOk;
    UserSteps userSteps;
    private String accessToken;

    public RegistrationTest(String name, String email, String password, boolean isRegOk) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.isRegOk = isRegOk;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    @After
    public void clearData() {
        driver.quit();
        userSteps = new UserSteps();
        if (accessToken != null) {
            userSteps.delete(accessToken);
        }
    }

    @Parameterized.Parameters
    public static Object[][] getDataUser() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(10) + "@" + "rt.rt", RandomStringUtils.randomAlphabetic(6), true},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(10) + "@" + "rt.rt", RandomStringUtils.randomAlphabetic(7), true},
                {RandomStringUtils.randomAlphabetic(6), RandomStringUtils.randomAlphabetic(10) + "@" + "rt.rt", RandomStringUtils.randomAlphabetic(5), false},
        };
    }

    @Test
    public void registerTest() {
        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = new RegistrationPage(driver);
        homePage.clickLoginBtnMiddle();
        loginPage.clickRegistrationBtn();
        registrationPage.registration(name, email, password);

        if (password.length() > 5) {
            loginPage.login(email, password);
            Assert.assertTrue(homePage.seeH1CreateBurger() == isRegOk);
        } else {
            registrationPage.shortPwdMessage();
        }
        WebStorage webStorage = (WebStorage) driver;
        LocalStorage localStorage = webStorage.getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
    }
}
