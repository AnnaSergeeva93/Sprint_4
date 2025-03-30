// Локаторы и методы для проверки выпадающего списка "Вопросы о важном"
// на главной странице Яндекс.Самоката

package ru.praktikum.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPage {

    private WebDriver driver;


    // Локатор раздела "Вопросы о важном"
    private By questionsSection = By.className("Home_FourPart__1uthg");

    // Локатор списка всех вопросов и ответов раздела "Вопросы о важном”
    private By questionsAndAnswersList = By.className("accordion__item");

    // Локатор всех вопросов раздела "Вопросы о важном”
    private By questions = By.className("accordion__button");

    // Локатор всех ответов раздела "Вопросы о важном"
    private By answers = By.className("accordion__panel");

    // Локатор текстов ответов раздела "Вопросы о важном"
    private By answersText = By.tagName("p");

    // Переменная списка всех вопросов и ответов в разделе "Вопросы о важном"
    private List<WebElement> questionsList;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }


    // Метод для открытия главной страницы Яндекс.Самокат
    public void openMainPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }


    // Метод для скролла до раздела "Вопросы о важном" и получение списка вопросов и ответов
    public void scrollToQuestionsAndGetQuestionsList() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                driver.findElement(questionsSection));
        questionsList = driver.findElements(questionsAndAnswersList);
    }

    // Метод для открытия ответов в разделе "Вопросы о важном"
    public void clickQuestion(int i) {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(questionsList.get(i))).click();
    }

    // Метод получения текста вопросов и ответов в разделе "Вопросы о важном"
    public Question getQuestion(int i) {
        var item = questionsList.get(i);
        return new Question(
                item.findElement(questions).getText(),
                item.findElement(answers)
                        .findElement(answersText).getText()
        );
    }

    // Класс и геттеры для получения текста ответов и вопросов
    public class Question {

        private final String question;
        private final String answer;

        public Question(String question, String answer) {
            this.question = question;
            this.answer = answer;
        }

        public String getAnswer() {
            return answer;
        }

        public String getQuestion() {
            return question;
        }
    }
}
