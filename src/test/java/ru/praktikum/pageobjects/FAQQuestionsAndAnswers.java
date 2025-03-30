package ru.praktikum.pageobjects;

import org.openqa.selenium.By;

public class FAQQuestionsAndAnswers {
    // Локаторы вопросов 1-8 в разделе "Вопросы о важном"
    public static final By QUESTION_COST = By.id("accordion__heading-0");
    public static final By QUESTION_RENT_SEVERAL_SCOOTERS = By.id("accordion__heading-1");
    public static final By QUESTION_RENTAL_PERIOD_COUNTING = By.id("accordion__heading-2");
    public static final By QUESTION_RENT_TODAY_POSSIBILITY = By.id("accordion__heading-3");
    public static final By QUESTION_EXTEND_RENT_AND_EARLY_RETURN = By.id("accordion__heading-4");
    public static final By QUESTION_CHARGER_GOES_WITH_SCOOTER = By.id("accordion__heading-5");
    public static final By QUESTION_CANCEL_RENT_POSSIBILITY = By.id("accordion__heading-6");
    public static final By QUESTION_MOSCOW_SUBURBS_DELIVERY = By.id("accordion__heading-7");


    // Локаторы ответов 1-8 в разделе "Вопросы о важном"
    public static final By ANSWER_COST = By.id("accordion__panel-0");
    public static final By ANSWER_RENT_SEVERAL_SCOOTERS = By.id("accordion__panel-1");
    public static final By ANSWER_RENTAL_PERIOD_COUNTING = By.id("accordion__panel-2");
    public static final By ANSWER_RENT_TODAY_POSSIBILITY = By.id("accordion__panel-3");
    public static final By ANSWER_EXTEND_RENT_AND_EARLY_RETURN = By.id("accordion__panel-4");
    public static final By ANSWER_CHARGER_GOES_WITH_SCOOTER = By.id("accordion__panel-5");
    public static final By ANSWER_CANCEL_RENT_POSSIBILITY = By.id("accordion__panel-6");
    public static final By ANSWER_MOSCOW_SUBURBS_DELIVERY = By.id("accordion__panel-7");

    // Тексты ответов
    public static final String ANSWER_COST_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String ANSWER_RENT_SEVERAL_SCOOTERS_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String ANSWER_RENTAL_PERIOD_COUNTING_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String ANSWER_RENT_TODAY_POSSIBILITY_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String ANSWER_EXTEND_RENT_AND_EARLY_RETURN_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String ANSWER_CHARGER_GOES_WITH_SCOOTER_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String ANSWER_CANCEL_RENT_POSSIBILITY_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String ANSWER_MOSCOW_SUBURBS_DELIVERY_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

}
