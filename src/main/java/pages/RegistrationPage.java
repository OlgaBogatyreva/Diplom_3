package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private final WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By nameInput = By.xpath(".//label[text()='Имя']/following-sibling::input");
    private final By emailInput = By.xpath(".//label[text()='Email']/following-sibling::input");
    private final By password = By.xpath(".//label[text()='Пароль']/following-sibling::input");
    private final By regBtn = By.xpath(".//button[text()='Зарегистрироваться']");
    private final By errorShortPwd = By.xpath(".//p[text()='Некорректный пароль']");
    private final By loginBtn = By.xpath(".//a[text()='Войти']");

    public void addName(String name) {
        driver.findElement(nameInput).click();
        driver.findElement(nameInput).sendKeys(name);
    }

    public void addEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void addPassword(String pwd) {
        driver.findElement(password).click();
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickRegBtn() {
        driver.findElement(regBtn).click();
    }

    public void shortPwdMessage() {
        driver.findElement(errorShortPwd).isDisplayed();
    }

    public void registration(String name, String email, String pwd) {
        addName(name);
        addEmail(email);
        addPassword(pwd);
        clickRegBtn();
    }

    public void clickLoginBtn() {
        driver.findElement(loginBtn).click();
    }
}
