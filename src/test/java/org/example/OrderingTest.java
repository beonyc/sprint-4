package org.example;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;



import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class OrderingTest {
    private WebDriver driver;
    private final String nameValue;//имя
    private final String surNameValue;//фамилия
    private final String adressValue;//адрес доставки
    private final String metroValue;//метро
    private final String phoneValue;//телефон
    private final String dateValue;//дата привоза самоката
    private final String periodValue;//срок аренды
    private final String color;//цвет самоката
    private final String commentValue;//комментарий

    public OrderingTest(String nameValue, String surNameValue, String adressValue, String metroValue, String phoneValue, String dateValue, String periodValue, String color, String commentValue) {
        this.nameValue = nameValue;
        this.surNameValue = surNameValue;
        this.adressValue = adressValue;
        this.metroValue = metroValue;
        this.phoneValue = phoneValue;
        this.dateValue = dateValue;
        this.periodValue = periodValue;
        this.color = color;
        this.commentValue = commentValue;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"Юрра", "Сугробов", "г. Москва", "Выхино", "89175864161", "14.06.2023", "3", "greyblack", "some comment"},
                {"Жуня", "Сицанов", "г. Осло", "Сокольники", "89135811161", "24.08.2023", "1", "black", "some comment2"}
        };
    }

   // @Before
    public void startUp() {
        WebDriverManager.firefoxdriver().setup();
        //WebDriverManager.chromedriver().setup();
    }

    @Test
    public void OrderSamokat() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\yrik0\\fireFoxdriver_win32\\geckodriver.exe");
        driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        // экземпляр класса, в котором описаны конпки заказать на главное странице
        MainPageForOrderingSamokat objOrder = new MainPageForOrderingSamokat(driver);
        //так как в условии аж 2 раза повторилось что кнопки 2, то можно выбрать любую из ник:    1- верхняя кнопка, 2- нижняя кнопка
        objOrder.pressOrderButton(2);

        // экземпляр класса, в котором описана персональная информация
        PersonalInformationOrder objInformationPage = new PersonalInformationOrder(driver);
        //метод который объединяет все вводы на данной странице
        objInformationPage.EnterWholePersonalInformation(nameValue, surNameValue, adressValue, metroValue, phoneValue);

        //экземляр класса, в котором описана информаци про аренду
        rentPageOrder objRendPage = new rentPageOrder(driver);
        //метод который объединяет все вводы на данной странице
        objRendPage.enterWholeRentInformation(dateValue, periodValue, color, commentValue);

        //экземпляр класса, который подтверждает создание заказа
        FinalScreen objFinalScreen = new FinalScreen(driver);
        //возыращает true, если заказ сделан
        assertTrue(objFinalScreen.isOrderEnabled());


    }

    @After
    public void tearDown() {
        driver.quit();
    }

}