package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OrderPage {

    private WebDriver driver;

    // Локатор доступности контента на странице
    private final By orderContentVisibility = By.className("Order_Content__bmtHS");

    // Кнопка "Заказать" в header страницы
    private final By headerOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");

    // Кнопка "Заказать" в середине страницы
    private final By middleOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    // Поле для ввода имени
    private final By inputNameOnOrderPage = By.xpath(".//input[@placeholder='* Имя']");

    // Поле для ввода фамилии
    private final By inputFnameOnOrderPage = By.xpath(".//input[@placeholder='* Фамилия']");

    // Поле для ввода адреса
    private final By inputAddressOnOrderPage = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");

    // Поле для выбора ближайшей станции метро и кнопка подтверждения
    private final By inputMetroOnOrderPage = By.xpath(".//input[@placeholder='* Станция метро']");
    private final By choiceMetroStation = By.xpath(".//button[@tabindex='-1']");

    // Поле для ввода номера телефона
    private final By inputPhoneOnOrderPage = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");

    // Кнопка "Далее"
    private final By buttonNextPage = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // общий селектор для всех ошибок на первой странице
    private final By visibleErrors = By.cssSelector(".Input_ErrorMessage__3HvIb.Input_Visible___syz6");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getVisibleErrors() {
        return driver.findElements(visibleErrors);
    }

    public boolean hasAnyErrors() {
        return !getVisibleErrors().isEmpty();
    }

    public void clickHeaderOrderButton() {
        driver.findElement(headerOrderButton).click();
    }

    public void clickMiddleOrderButton(){
        driver.findElement(middleOrderButton).click();
    }

    public void sendKeysNameOnOrderPage(String name) {
        driver.findElement(inputNameOnOrderPage).sendKeys(name);
    }

    public void sendKeysFnameOnOrderPage(String fname) {
        driver.findElement(inputFnameOnOrderPage).sendKeys(fname);
    }

    public void sendKeysAddressOnOrderPage(String address) {
        driver.findElement(inputAddressOnOrderPage).sendKeys(address);
    }

    public void sendKeysMetroOnOrderPage(String metro) {
        driver.findElement(inputMetroOnOrderPage).sendKeys(metro);
        driver.findElement(choiceMetroStation).click();
    }

    public void sendKeysPhoneOnOrderPage(long phone) {
        driver.findElement(inputPhoneOnOrderPage).sendKeys(String.valueOf(phone));
    }

    public void clickButtonNextPage() {
        driver.findElement(buttonNextPage).click();
    }

    public void mainOrderData(String name, String fname, String address, String metro, long phone) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderContentVisibility));
        sendKeysNameOnOrderPage(name);
        sendKeysFnameOnOrderPage(fname);
        sendKeysAddressOnOrderPage(address);
        sendKeysMetroOnOrderPage(metro);
        sendKeysPhoneOnOrderPage(phone);
    }





}
