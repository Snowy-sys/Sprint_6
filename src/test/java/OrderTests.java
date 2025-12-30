import BaseDriverClass.ChromeBaseClass;
import PageObjects.HomePage;
import PageObjects.OrderPage;
import PageObjects.RentPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTests extends ChromeBaseClass {

    private HomePage objhHomePage;
    private OrderPage objOrderPage;
    private RentPage objRentPage;

    private static Stream<Arguments> credentialsProvider() {
        return Stream.of(
                Arguments.of("Тест", "Тестовый", "Тестовый адрес", "Измайловская", "70000000000", "Позвонить за час до доставки"),
                Arguments.of("Тестик", "Тестиковый", "Улица Пушкина, дом колотушкина", "Черкизовская", "80000000000", "Вход с торца"),
                Arguments.of("Петр", "Сидоров", "Москва, Красная площадь, д.1", "Бульвар рокоссовского", "79245842844", "Позвонить как подьедите к шлагбауму")
        );
    }

    @BeforeEach
    public void initHomePage() {
        objhHomePage = new HomePage(driver);
        objhHomePage.clickCookieAcceptButton();

        objOrderPage = new OrderPage(driver);
        objRentPage = new RentPage(driver);
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    public void headerOrderFlow(String name, String fname, String address, String metro, long phone, String comments) throws Exception {

        objOrderPage.clickHeaderOrderButton();

        objOrderPage.mainOrderData(name, fname, address, metro, phone);
        objOrderPage.clickButtonNextPage();

        objRentPage.mainInfoRent(comments);
        objRentPage.clickButtonNextPage();
        objRentPage.confirmOrder();

        String actualResult = objRentPage.checkExpectedStatusAfterConfirm();

        assertTrue(actualResult.contains("Заказ оформлен"), "Не найден текст 'Заказ оформлен'");
        assertTrue(actualResult.matches("(?s).*Номер заказа:\\s*\\d{6}.*"),
                "Номер заказа должен состоять из 6 цифр");
    }

    @ParameterizedTest
    @MethodSource("credentialsProvider")
    public void middleOrderFlow(String name, String fname, String address, String metro, long phone){

        objOrderPage.clickMiddleOrderButton();

        objOrderPage.mainOrderData(name, fname, address, metro, phone);
        objOrderPage.clickButtonNextPage();

        objRentPage.mainInfoRentWithoutComments();
        objRentPage.clickButtonNextPage();
        objRentPage.confirmOrder();

        String actualResult = objRentPage.checkExpectedStatusAfterConfirm();

        assertTrue(actualResult.contains("Заказ оформлен"), "Не найден текст 'Заказ оформлен'");
        assertTrue(actualResult.matches("(?s).*Номер заказа:\\s*\\d{6}.*"),
                "Номер заказа должен состоять из 6 цифр");

    }

    @Test
    public void checkRequiredFieldOnOrderPage() {
        objOrderPage.clickMiddleOrderButton();
        objOrderPage.clickButtonNextPage();

        assertTrue(objOrderPage.hasAnyErrors(), "Должна появиться хотя бы одна ошибка валидации");

        assertEquals(3, objOrderPage.getVisibleErrors().size(),
                "Должны подсветиться все обязательные поля");

        assertFalse(objRentPage.contentPageVisibility(),
                "Форма перехода на следующий шаг не должна открываться");

    }

}
