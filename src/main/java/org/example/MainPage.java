package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//класс для первого задания с проверкой на соответсвующий тест
public class MainPage {
    //инициализируем поле дрйвера
    private WebDriver driver;

    //поле для заголовка выпадающиего спика
    private By header;

    //поле для тела выпадающиего спика
    private By body;
    //локатор нахождения всего выпадающего списка
    private By List=By.className("Home_FAQ__3uVm4");

    //конструктор класса MainPage
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод для нажатия на заголовок выпадающего спика
    public void findAndClickHeaderOfList(String textHeader) {
        //скролим до всего выпадающего списка
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(List));
        //локатор для нахождения заголовка выбранного списка
        header = By.xpath(".//*[@data-accordion-component='AccordionItem']/div/div[text()='" + textHeader + "']");
        //нажатие на выбранный выпадающий список
        driver.findElement(header).click();
    }

    //метод для получения внутреннего текста из определенного выпадающего списка
    public String getBodyText(String textHeader) {
        //локатор для нахождения внутреннего текста по выбранному названию выпадающего списка
        body = By.xpath(".//*[@data-accordion-component='AccordionItem']/div/div[text()='" + textHeader + "']/parent::div/parent::div/div[last()]/p");
        //возвращаем текст локатора
        return driver.findElement(body).getText();

    }


}
