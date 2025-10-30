import BaseDriverClass.ChromeBaseClass;
import PageObjects.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static Constants.MainQuestions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuestionsTests extends ChromeBaseClass {

    private HomePage objhHomePage;

    @BeforeEach
    public void initHomePage() {
        objhHomePage = new HomePage(driver);
        objhHomePage.clickCookieAcceptButton();
    }

    @Test
    public void getTextFromFirstQuestion() {
        String actual = objhHomePage.getTextFirstQuestionsAccordion();
        assertEquals(FIRST_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromSecondQuestion() {
        String actual = objhHomePage.getTextSecondQuestionsAccordion();
        assertEquals(SECOND_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromThirdQuestion() {
        String actual = objhHomePage.getTextThirdQuestionsAccordion();
        assertEquals(THIRD_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromFourQuestion() {
        String actual = objhHomePage.getTextFourQuestionsAccordion();
        assertEquals(FOURTH_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromFiveQuestion() {
        String actual = objhHomePage.getTextFiveQuestionsAccordion();
        assertEquals(FIVETH_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromSixQuestion() {
        String actual = objhHomePage.getTextSixQuestionsAccordion();
        assertEquals(SIXTH_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromSevenQuestion() {
        String actual = objhHomePage.getTextSevenQuestionsAccordion();
        assertEquals(SEVENTH_ACCORDION_QUESTION, actual);
    }

    @Test
    public void getTextFromEightQuestion() {
        String actual = objhHomePage.getTextEightQuestionsAccordion();
        assertEquals(EIGHTH_ACCORDION_QUESTION, actual);
    }
}
