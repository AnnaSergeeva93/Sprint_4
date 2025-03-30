// Локаторы и методы для проверки выпадающего списка "Вопросы о важном"
// на главной странице Яндекс.Самоката

package ru.praktikum.pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MainPage {

    private WebDriver driver;


    // Локатор раздела "Вопросы о важном"
    private By questionsSection = By.className("Home_FourPart__1uthg");



    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    // Метод для открытия главной страницы Яндекс.Самокат
    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    // Метод для скролла до раздела "Вопросы о важном"
    public void scrollToQuestions() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsSection));
    }

    // Метод для открытия ответов в разделе "Вопросы о важном"
    public void clickQuestion(By question) {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(question)).click();
    }

    // Метод ожидания загрузки ответа на вопрос в разделе "Вопросы о важном"
    public void waitLoadQuestion(By accordionLabel) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> (driver.findElement(accordionLabel).getText() != null
                && !driver.findElement(accordionLabel).getText().isEmpty()
        ));
    }
}

