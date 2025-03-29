// Локаторы и методы для проверки выпадающего списка "Вопросы о важном"
// на главной странице Яндекс.Самоката

package ru.praktikum.pageobjects;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.is;

public class MainPage {

    private WebDriver driver;


    // Локаторы вопросов 1-8 в разделе "Вопросы о важном"
    private By question1 = By.id("accordion__heading-0");
    private By question2 = By.id("accordion__heading-1");
    private By question3 = By.id("accordion__heading-2");
    private By question4 = By.id("accordion__heading-3");
    private By question5 = By.id("accordion__heading-4");
    private By question6 = By.id("accordion__heading-5");
    private By question7 = By.id("accordion__heading-6");
    private By question8 = By.id("accordion__heading-7");

    // Локаторы ответов 1-8 в разделе "Вопросы о важном"
    private By answer1 = By.id("accordion__panel-0");
    private By answer2 = By.id("accordion__panel-1");
    private By answer3 = By.id("accordion__panel-2");
    private By answer4 = By.id("accordion__panel-3");
    private By answer5 = By.id("accordion__panel-4");
    private By answer6 = By.id("accordion__panel-5");
    private By answer7 = By.id("accordion__panel-6");
    private By answer8 = By.id("accordion__panel-7");


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
                driver.findElement(question1));
    }

    // Методы для открытия ответов в разделе "Вопросы о важном"
    public void clickQuestion1() {
        driver.findElement(question1).click();
    }

    public void clickQuestion2() {
        driver.findElement(question2).click();
    }

    public void clickQuestion3() {
        driver.findElement(question3).click();
    }

    public void clickQuestion4() {
        driver.findElement(question4).click();
    }

    public void clickQuestion5() {
        driver.findElement(question5).click();
    }

    public void clickQuestion6() {
        driver.findElement(question6).click();
    }

    public void clickQuestion7() {
        driver.findElement(question7).click();
    }

    public void clickQuestion8() {
        driver.findElement(question8).click();
    }

    // Методы для получения текстов ответов в разделе "Вопросы о важном"
    public String getAnswer1() {
        return driver.findElement(answer1).getText();
    }

    public String getAnswer2() {
        return driver.findElement(answer2).getText();
    }

    public String getAnswer3() {
        return driver.findElement(answer3).getText();
    }

    public String getAnswer4() {
        return driver.findElement(answer4).getText();
    }

    public String getAnswer5() {
        return driver.findElement(answer5).getText();
    }

    public String getAnswer6() {
        return driver.findElement(answer6).getText();
    }

    public String getAnswer7() {
        return driver.findElement(answer7).getText();
    }

    public String getAnswer8() {
        return driver.findElement(answer8).getText();
    }

    // Метод для проверки правильности текста ответов в разделе "Вопросы о важном"
    public void isCorrectText(String answer, String text) {
        MatcherAssert.assertThat(answer, is(text));
    }
}
