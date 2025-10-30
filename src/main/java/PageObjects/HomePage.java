package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePage {

    private WebDriver driver;

    // Кнопка "Принять куки"
    private final By cookieAcceptButton = By.id("rcc-confirm-button");

    // Кнопка вопроса №1 аккордиона + элемент текста
    private final By mainQuestionAccordion0 = By.id("accordion__heading-0");
    private final By textFromQuestionAccordion0 = By.id("accordion__panel-0");

    // Кнопка вопроса №2 аккордиона + элемент текста
    private final By mainQuestionAccordion1 = By.id("accordion__heading-1");
    private final By textFromQuestionAccordion1 = By.id("accordion__panel-1");

    // Кнопка вопроса №3 аккордиона + элемент текста
    private final By mainQuestionAccordion2 = By.id("accordion__heading-2");
    private final By textFromQuestionAccordion2 = By.id("accordion__panel-2");

    // Кнопка вопроса №4 аккордиона + элемент текста
    private final By mainQuestionAccordion3 = By.id("accordion__heading-3");
    private final By textFromQuestionAccordion3 = By.id("accordion__panel-3");

    // Кнопка вопроса №5 аккордиона + элемент текста
    private final By mainQuestionAccordion4 = By.id("accordion__heading-4");
    private final By textFromQuestionAccordion4 = By.id("accordion__panel-4");

    // Кнопка вопроса №6 аккордиона + элемент текста
    private final By mainQuestionAccordion5 = By.id("accordion__heading-5");
    private final By textFromQuestionAccordion5 = By.id("accordion__panel-5");

    // Кнопка вопроса №7 аккордиона + элемент текста
    private final By mainQuestionAccordion6 = By.id("accordion__heading-6");
    private final By textFromQuestionAccordion6 = By.id("accordion__panel-6");

    // Кнопка вопроса №8 аккордиона + элемент текста
    private final By mainQuestionAccordion7 = By.id("accordion__heading-7");
    private final By textFromQuestionAccordion7 = By.id("accordion__panel-7");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCookieAcceptButton() {
        assertTrue(driver.findElement(cookieAcceptButton).isEnabled());
        driver.findElement(cookieAcceptButton).click();
    }

    public String getTextFirstQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion0).click();

        assertTrue(driver.findElement(textFromQuestionAccordion0).isEnabled());
        return driver.findElement(textFromQuestionAccordion0).getText();


    }

    public String getTextSecondQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion1).click();

        assertTrue(driver.findElement(textFromQuestionAccordion1).isEnabled());
        return driver.findElement(textFromQuestionAccordion1).getText();
    }

    public String getTextThirdQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion2).click();

        assertTrue(driver.findElement(textFromQuestionAccordion2).isEnabled());
        return driver.findElement(textFromQuestionAccordion2).getText();
    }

    public String getTextFourQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion3).click();

        assertTrue(driver.findElement(textFromQuestionAccordion3).isEnabled());
        return driver.findElement(textFromQuestionAccordion3).getText();
    }

    public String getTextFiveQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion4).click();

        assertTrue(driver.findElement(textFromQuestionAccordion4).isEnabled());
        return driver.findElement(textFromQuestionAccordion4).getText();
    }

    public String getTextSixQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion5).click();

        assertTrue(driver.findElement(textFromQuestionAccordion5).isEnabled());
        return driver.findElement(textFromQuestionAccordion5).getText();
    }

    public String getTextSevenQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion6).click();

        assertTrue(driver.findElement(textFromQuestionAccordion6).isEnabled());
        return driver.findElement(textFromQuestionAccordion6).getText();
    }

    public String getTextEightQuestionsAccordion() {
        driver.findElement(mainQuestionAccordion7).click();

        assertTrue(driver.findElement(textFromQuestionAccordion7).isEnabled());
        return driver.findElement(textFromQuestionAccordion7).getText();
    }
}
