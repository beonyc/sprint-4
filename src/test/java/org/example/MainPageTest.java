package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class MainPageTest {
    private WebDriver driver;
    //поле заголовка выпадающего спика
    private String textHeader;
    //поле тела выпадающего спика
    private String textBody;
    //поле результата сравнения
    private boolean actual;
    //конструктор для параметизированного класса
    public MainPageTest(String textHeader, String textBody,boolean actual) {
        this.textHeader = textHeader;
        this.textBody = textBody;
        this.actual=actual;
    }
    //метод для получения данных для сравнения
    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",true},
                {"Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",true},
                {"Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее.",true},
                {"Как рассчитывается время аренды?","Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",true},
                {"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",true},
                {"Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",true},
                {"Можно ли отменить заказ?","Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",true},
                {"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области.",true},

                {"Сколько это стоит? И как оплатить?","Тут мы случайно ввели не тот текст для проверки(((",false}
        };
    }

    @Before
    public void startUp() {
        //WebDriverManager.firefoxdriver().setup();
         WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkIfTextIsEquals() {

        //driver = new FirefoxDriver();
         driver = new ChromeDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");
        //экземпляр класса, в котором описаны все локаторы и методы первого теста
        MainPage objMainPage = new MainPage(driver);
        //метод для нажатия на выбранный заголовок списка
        objMainPage.findAndClickHeaderOfList(textHeader);
        //проверка, что ожидаемые данные и актуальные равны
        assertEquals(actual, objMainPage.getBodyText(textHeader).equals(textBody));


    }

    @After
    public void tearDown() {
        driver.quit();
    }
}