package ru.praktikum.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.praktikum.pageobjects.MainPage;

import static ru.praktikum.pageobjects.FAQAnswerTexts.*;

import java.time.Duration;


public class FAQTest {

    private WebDriver driver;

    @Before
    public void StartUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkQuestions() {
        MainPage mainPage = new MainPage(driver);

        mainPage.openMainPage();

        mainPage.scrollToQuestions();

        mainPage.clickQuestion1();
        mainPage.isCorrectText(mainPage.getAnswer1(), answer1Text);

        mainPage.clickQuestion2();
        mainPage.isCorrectText(mainPage.getAnswer2(), answer2Text);

        mainPage.clickQuestion3();
        mainPage.isCorrectText(mainPage.getAnswer3(), answer3Text);

        mainPage.clickQuestion4();
        mainPage.isCorrectText(mainPage.getAnswer4(), answer4Text);

        mainPage.clickQuestion5();
        mainPage.isCorrectText(mainPage.getAnswer5(), answer5Text);

        mainPage.clickQuestion6();
        mainPage.isCorrectText(mainPage.getAnswer6(), answer6Text);

        mainPage.clickQuestion7();
        mainPage.isCorrectText(mainPage.getAnswer7(), answer7Text);

        mainPage.clickQuestion8();
        mainPage.isCorrectText(mainPage.getAnswer8(), answer8Text);

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
