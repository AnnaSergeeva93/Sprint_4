package ru.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobjects.MainPage;
import ru.praktikum.pageobjects.OrderPage;
import static org.junit.Assert.assertTrue;

import java.time.Duration;


@RunWith(Parameterized.class)
public class OrderTest {
    private WebDriver driver;
    private final String name;
    private final String lastname;
    private final String address;
    private final int metro;
    private final String phoneNumber;
    private final String deliveryDate;
    private final String rentalPeriod;
    private final String colour;
    private final String comment;
    private final String expectedHeader = "Заказ оформлен";

    public OrderTest(String name, String lastname, String address, int metro, String phoneNumber, String deliveryDate, String rentalPeriod, String colour, String comment) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
        this.metro = metro;
        this.phoneNumber = phoneNumber;
        this.deliveryDate = deliveryDate;
        this.rentalPeriod = rentalPeriod;
        this.colour = colour;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getDateSetForOrder() {
        return new Object[][]{
                {"Александр", "Романов", "г.Москва, улица Мусы Джалиля, дом 2", 7, "89756432109", "01.04.2025", "сутки", "чёрный", "Заранее позвоните по номеру телефона"},
                {"Анна", "Иванова", "улица Кирова, дом 9", 25, "+79876543210", "12.12.2025", "трое суток", "серый", "Привет"},
        };
    }

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void placeOrderTroughUpButtonTest() {
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        orderPage.closeCookieBanner();
        orderPage.clickUpOrderButton();
        orderPage.fillDataScooterRenterPage(name, lastname, address, metro, phoneNumber);
        orderPage.fillRentInfoPage(deliveryDate, rentalPeriod, colour, comment);
        orderPage.confirmOrder();

        assertTrue(orderPage.getHeaderOfWindowAfterCreateOrder().contains(expectedHeader));
    }

    @Test
    public void placeOrderTroughDownButtonTest() {
        OrderPage orderPage = new OrderPage(driver);
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        orderPage.closeCookieBanner();
        orderPage.scrollToDownOrderButton();
        orderPage.clickDownOrderButton();
        orderPage.fillDataScooterRenterPage(name, lastname, address, metro, phoneNumber);
        orderPage.fillRentInfoPage(deliveryDate, rentalPeriod, colour, comment);
        orderPage.confirmOrder();

        assertTrue(orderPage.getHeaderOfWindowAfterCreateOrder().contains(expectedHeader));
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
