package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By saveBtn = By.xpath(".//button[@class='button_button__33qZ0 button_button_type_primary__1O7Bx button_button_size_medium__3zxIa']");

    private final By logo = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    private final By constructorLinkHeader = By.xpath(".//a[@class='AppHeader_header__link__3D_hX']");

    private final By logoutBtn = By.xpath(".//button[text()='Выход']");

    public void clickGoMainByClickLogo() {
        driver.findElement(logo).click();
    }

    public void clickGoMainByClickConstructor() {
        driver.findElement(constructorLinkHeader).click();
    }

    public void logout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(logoutBtn));
        driver.findElement(logoutBtn).click();
    }

}
