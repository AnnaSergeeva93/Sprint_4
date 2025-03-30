package ru.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.praktikum.pageobjects.MainPage;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

import static ru.praktikum.pageobjects.FAQQuestionsAndAnswers.*;


    @RunWith(Parameterized.class)
    public class FAQTest {
        private WebDriver driver;
        private By question;
        private By answer;
        private String expectedAnswerText;

    public FAQTest (By question, By answer, String expectedAnswerText) {
        this.question = question;
        this.answer = answer;
        this.expectedAnswerText = expectedAnswerText;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}, {1} = {2}")
    public static Object[][] getDataSetForQuestions() {
        return new Object[][]{
                {QUESTION_COST, ANSWER_COST, ANSWER_COST_TEXT},
                {QUESTION_RENT_SEVERAL_SCOOTERS, ANSWER_RENT_SEVERAL_SCOOTERS, ANSWER_RENT_SEVERAL_SCOOTERS_TEXT},
                {QUESTION_RENTAL_PERIOD_COUNTING, ANSWER_RENTAL_PERIOD_COUNTING, ANSWER_RENTAL_PERIOD_COUNTING_TEXT},
                {QUESTION_RENT_TODAY_POSSIBILITY, ANSWER_RENT_TODAY_POSSIBILITY, ANSWER_RENT_TODAY_POSSIBILITY_TEXT},
                {QUESTION_EXTEND_RENT_AND_EARLY_RETURN, ANSWER_EXTEND_RENT_AND_EARLY_RETURN, ANSWER_EXTEND_RENT_AND_EARLY_RETURN_TEXT},
                {QUESTION_CHARGER_GOES_WITH_SCOOTER, ANSWER_CHARGER_GOES_WITH_SCOOTER, ANSWER_CHARGER_GOES_WITH_SCOOTER_TEXT},
                {QUESTION_CANCEL_RENT_POSSIBILITY, ANSWER_CANCEL_RENT_POSSIBILITY, ANSWER_CANCEL_RENT_POSSIBILITY_TEXT},
                {QUESTION_MOSCOW_SUBURBS_DELIVERY, ANSWER_MOSCOW_SUBURBS_DELIVERY, ANSWER_MOSCOW_SUBURBS_DELIVERY_TEXT},
        };
    }


    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test
    public void checkQuestionsTest() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.scrollToQuestions();
        mainPage.clickQuestion(question);
        mainPage.waitLoadQuestion(answer);

        String result = driver.findElement(answer).getText();
        assertEquals(expectedAnswerText, result);
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
