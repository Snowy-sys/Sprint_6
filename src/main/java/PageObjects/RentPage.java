package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RentPage {

    private WebDriver driver;

    // Локатор доступности контента на странице
    private final By orderContentVisibility = By.className("Order_Content__bmtHS");

    // Локаторы для выбора даты. Всегда выбирается последний день третьей недели следующего месяца
    private final By dateOfRent = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By dateNextMountNavigation = By.xpath(".//button[@aria-label='Next Month']");
    private final By choiceLastDateOnThirdWeek = By.xpath(".//div[@class='react-datepicker__week'][3]/div[last()]");

    // Срок аренды. Всегда выбирается максимальный период аренды
    private final By periodOfRentField = By.cssSelector(".Dropdown-placeholder");
    private final By maxPeriodOfRent = By.xpath(".//div[@class='Dropdown-option' and text()='семеро суток']");
    private final By minPeriodOfRent = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    // Цвет самоката: чёрный
    private final By colourOfScooter_black = By.id("black");

    // Цвет самоката: серый
    private final By colourOfScooter_grey = By.id("grey");

    // Поле для ввода комментарий курьеру
    private final By commentsForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");

    // Кнопка "Заказать"
    private final By middleOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");

    // Кнопка подтверждения заказа "Да"
    private final By confirmOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    // Проверка статуса заказа
    private final By expectedStatusAfterConfirm = By.cssSelector(".Order_ModalHeader__3FDaJ");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    private boolean isElementVisible(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    public boolean contentPageVisibility() {
        return isElementVisible(dateOfRent);
    }

    public void choiceDateArrivalScooter() {
        driver.findElement(dateOfRent).click();
        driver.findElement(dateNextMountNavigation).click();
        driver.findElement(choiceLastDateOnThirdWeek).click();
    }

    public void choiceMaxPeriodOfRent() {
        driver.findElement(periodOfRentField).click();
        driver.findElement(maxPeriodOfRent).click();
    }

    public void choiceMinPeriodOfRent() {
        driver.findElement(periodOfRentField).click();
        driver.findElement(minPeriodOfRent).click();
    }

    public void checkboxBlackScooterColour() {
        driver.findElement(colourOfScooter_black).click();
    }

    public void checkboxGreyScooterColour() {
        driver.findElement(colourOfScooter_grey).click();
    }

    public void inputCommentsForCourier(String comments) {
        driver.findElement(commentsForCourier).sendKeys(comments);
    }

    public void clickButtonNextPage() {
        driver.findElement(middleOrderButton).click();
    }

    public void mainInfoRent(String comments) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderContentVisibility));
        choiceDateArrivalScooter();
        choiceMaxPeriodOfRent();
        checkboxBlackScooterColour();
        inputCommentsForCourier(comments);
    }

    public void mainInfoRentWithoutComments() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(orderContentVisibility));
        choiceDateArrivalScooter();
        choiceMinPeriodOfRent();
        checkboxGreyScooterColour();
    }

    public void confirmOrder() {
        assertTrue(driver.findElement(confirmOrderButton).isEnabled());
        driver.findElement(confirmOrderButton).click();
    }

    public String checkExpectedStatusAfterConfirm() {
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(expectedStatusAfterConfirm));
        assertTrue(driver.findElement(expectedStatusAfterConfirm).isEnabled());
        return driver.findElement(expectedStatusAfterConfirm).getText();
    }
}

