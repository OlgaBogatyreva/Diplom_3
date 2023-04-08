package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By registrationBtn = By.xpath(".//a[text()='Зарегистрироваться']");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By password = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By loginBtn = By.xpath(".//button[text()='Войти']");
    private final By loginLinkResetPwd = By.xpath(".//a[text()='Войти']");

    private final By recoverThePwdBtn = By.xpath(".//a[text()='Восстановить пароль']");
    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    public void addEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void addPassword(String pwd) {
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }

    public void login(String email, String pwd) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        addEmail(email);
        addPassword(pwd);
        clickLoginBtn();
    }

    public void clickRegistrationBtn() {
        driver.findElement(registrationBtn).click();
    }

    public void clickRecoverPwdBtn() {
        driver.findElement(recoverThePwdBtn).click();
    }

    public void goToMain() {
        driver.findElement(logo).click();
    }

    public void loginBtnFromResetPwdPage() {
        driver.findElement(loginLinkResetPwd).click();
    }
}
