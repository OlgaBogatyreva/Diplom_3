import api.UserSteps;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.RegistrationPage;

public class LoginTest {

    private WebDriver driver;
    private String name = RandomStringUtils.randomAlphabetic(6);
    private String email = RandomStringUtils.randomAlphabetic(10) + "@" + "rt.rt";
    private String password = RandomStringUtils.randomAlphabetic(8);
    private String accessToken;
    UserSteps userSteps;

    //подготовка: регистрация пользователя, логин и выход
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        //    System.setProperty("webdriver.chrome.driver", // Для запуска в яндекс браузере
        //            "C:/cygwin64/home/bogat/chromedriver_110.exe");
        //    ChromeOptions options = new ChromeOptions();
        //    options.setBinary("C:/YandexBrowser/Application/browser.exe");
        //    options.addArguments("--remote-allow-origins=*");
        //    driver = new ChromeDriver(options);

        driver.get("https://stellarburgers.nomoreparties.site/");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        homePage.clickLoginBtnMiddle();
        loginPage.clickRegistrationBtn();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.registration(name, email, password);
        loginPage.login(email, password);
        homePage.clickPersonalAccount();
        WebStorage webStorage = (WebStorage) driver;
        LocalStorage localStorage = webStorage.getLocalStorage();
        accessToken = localStorage.getItem("accessToken");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.logout();
        loginPage.goToMain();
    }

    @After
    public void teardown() {
        driver.quit();
        userSteps = new UserSteps();
        if (accessToken != null) {
            userSteps.delete(accessToken);
        }
    }

    @Test
    public void loginByHeaderBtn() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginBtnHeader();
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.login(email, password);
        homePage.clickPersonalAccount();
        profilePage.logout();
        loginPage.goToMain();
        Assert.assertTrue(homePage.seeH1CreateBurger());
    }

    @Test
    public void loginPageMiddleBtnLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.clickLoginBtnMiddle();
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        loginPage.login(email, password);
        homePage.clickPersonalAccount();
        profilePage.logout();
        loginPage.goToMain();
        Assert.assertTrue(homePage.seeH1CreateBurger());
    }

    @Test
    public void loginByRegistrationFormBtn() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickLoginBtnHeader();
        loginPage.clickRegistrationBtn();
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.clickLoginBtn();
        loginPage.login(email, password);
        homePage.clickPersonalAccount();
        profilePage.logout();
        loginPage.goToMain();
        Assert.assertTrue(homePage.seeH1CreateBurger());
    }

    @Test
    public void loginByLinkOnResetPwdPage() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);
        homePage.clickLoginBtnHeader();
        loginPage.clickRecoverPwdBtn();
        loginPage.loginBtnFromResetPwdPage();
        loginPage.login(email, password);
        homePage.clickPersonalAccount();
        profilePage.logout();
        loginPage.goToMain();
        Assert.assertTrue(homePage.seeH1CreateBurger());
    }
}

