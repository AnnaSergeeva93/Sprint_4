// Локаторы и методы для проверки заказа самоката

package ru.praktikum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {

    private WebDriver driver;

    // Локатор для баннера с куками
    private By сookieBannerButton = By.className("App_CookieButton__3cvqF");

    // Локатор кнопки "Заказать" в шапке страницы
    private By upOrderButton = By.xpath(".//button[@class='Button_Button__ra12g']");

    // Локатор кнопки "Заказать" внизу страницы
    private By downOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    // Локаторы полей и кнопки на странице "Для кого самокат"
    // Имя
    private By nameField = By.xpath(".//input[@placeholder='* Имя']");
    // Фамилия
    private By lastnameField = By.xpath(".//input[@placeholder='* Фамилия']");
    // Адрес: куда привезти заказ
    private By addressField = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Станция метро
    private By metroField = By.xpath(".//input[@placeholder='* Станция метро']");
    private String nameMetro = ".//button[@value='%s']";
    // Телефон: на него позвонит курьер
    private By phoneNumberField = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.xpath(".//button[text()='Далее']");

    // Локаторы полей и кнопок на странице "Про аренду"
    // Когда привезти заказа
    private By deliveryDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Срок аренды
    private By rentalPeriodField = By.xpath(".//span[@class='Dropdown-arrow']");
    // Цвет самоката
    // Чекбокс "чёрный жемчуг"
    private By scooterBlackColourCheckbox = By.id("black");
    // Чекбокс "серая безысходность"
    private By scooterGreyColourCheckbox = By.id("grey");
    // Комментарий для курьера
    private By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//div[contains(@class,'Order_Buttons')]/button[text()='Заказать']");

    // Локатор кнопки "Да" подтверждения заказа в окне "Хотите оформить заказ?"
    private By confirmOrderButton = By.xpath(".//button[text()='Да']");

    // Локатор заголовка окна "Заказ оформлен"
    private By headerOfWindowAfterCreateOrder = By.xpath(".//div[text()='Заказ оформлен']");



    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для закрытия баннера с куками
    public void closeCookieBanner() {
        driver.findElement(сookieBannerButton).click();
    }

    // Метод для скролла до второй кнопки "Заказать"
    public void scrollToDownOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(downOrderButton));
    }

    // Метод для клика по кнопке "Заказать" в шапке страницы
    public void clickUpOrderButton() {
        driver.findElement(upOrderButton).click();
    }

    // Метод для клика по кнопке "Заказать" внизу страницы
    public void clickDownOrderButton() {
        driver.findElement(downOrderButton).click();
    }

    // Метод для заполнения страницы "Для кого самокат"
    public void fillDataScooterRenterPage(String name, String lastname, String address, int metroNumber, String phoneNumber) {
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(lastnameField).sendKeys(lastname);
        driver.findElement(addressField).sendKeys(address);

        driver.findElement(metroField).click();
        By newMetro = By.xpath(String.format(nameMetro, metroNumber));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(newMetro));
        driver.findElement(newMetro).click();

        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        driver.findElement(nextButton).click();
    }

    // Метод для заполнения страницы "Про аренду"
    public void fillRentInfoPage (String deliveryDate, String rentalPeriod, String colour, String comment) {
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);

        driver.findElement(rentalPeriodField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.className("Dropdown-menu"))).click();

        if (colour.equals("чёрный")) {
            driver.findElement(scooterBlackColourCheckbox).click();
        } else if (colour.equals("серый")) {
            driver.findElement(scooterGreyColourCheckbox).click();
        }

        driver.findElement(commentField).sendKeys(comment);

        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
    }

    // Метод для нажатия кнопки "Да" в окне "Хотите оформить заказ?"
    public void confirmOrder () {
        driver.findElement(confirmOrderButton).click();
    }

    // Метод для проверки успешности оформления заказа
    public String getHeaderOfWindowAfterCreateOrder () {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(driver -> (driver.findElement(headerOfWindowAfterCreateOrder).getText() != null
                && !driver.findElement(headerOfWindowAfterCreateOrder).getText().isEmpty()
        ));
        return driver.findElement(headerOfWindowAfterCreateOrder).getText();
    }
}
