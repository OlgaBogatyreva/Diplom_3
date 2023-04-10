package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public final By loginBtnHeader = By.xpath(".//p[text()='Личный Кабинет']");
    public final By loginBtnMiddle = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By h1CreateBurger = By.xpath(".//h1[text()='Соберите бургер']");
    private final By bunsTabCurrent = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Булки']");
    private final By saucesTabCurrent = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Соусы']");
    private final By fillingsTabCurrent = By.xpath(".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Начинки']");
    private final By bunsTabNoSelect = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Булки']");
    private final By saucesTabNoSelect = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Соусы']");
    private final By fillingsTabNoSelect = By.xpath(".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']//span[text()='Начинки']");

    public void clickPersonalAccount() {
        driver.findElement(loginBtnHeader).click();
    }

    public void clickLoginBtnHeader() {
        driver.findElement(loginBtnHeader).click();
    }

    public void clickLoginBtnMiddle() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(loginBtnMiddle));
        driver.findElement(loginBtnMiddle).click();
    }

    public void clickSomeBtn(By buttonToClick) {
        driver.findElement(buttonToClick);
    }

    public boolean seeH1CreateBurger() {
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(h1CreateBurger));
        return driver.findElement(h1CreateBurger).isDisplayed();
    }

    public void clickBunsTab() {
        driver.findElement(saucesTabNoSelect).click();
        driver.findElement(bunsTabNoSelect).click();
        driver.findElement(bunsTabCurrent);
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTabNoSelect).click();
        driver.findElement(saucesTabCurrent);
    }

    public void clickFillingsTab() {
        driver.findElement(fillingsTabNoSelect).click();
        driver.findElement(fillingsTabCurrent);
    }
}