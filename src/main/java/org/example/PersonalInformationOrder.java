package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class PersonalInformationOrder {
    private WebDriver driver;
    //локатор для поля имя
    private By name = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Имя']");
    //локатор для поля фамилия
    private By surName = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Фамилия']");
    //локатор для Адреса
    private By adress = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Адрес: куда привезти заказ']");
    //локатор для станции метро
    private By metro = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Станция метро']");
    //локатор для выбора элемента из списка метро
    private By nameFromList=By.xpath(".//*[@class='select-search__select']//*[@class='Order_Text__2broi']");
    //локатор для поля телефона
    private By phone = By.xpath(".//div[@class='Order_Form__17u6u']//input[@placeholder='* Телефон: на него позвонит курьер']");
    //локатор кнопки ДАЛЕЕ
    private By nextButton = By.cssSelector(".Order_NextButton__1_rCA button");
    //конструктор
    public PersonalInformationOrder(WebDriver driver) {
        this.driver = driver;
    }
    //метод для ввода имени
    public void setName(String nameValue) {
        driver.findElement(name).clear();
        driver.findElement(name).sendKeys(nameValue);
    }
    //метод для ввода фамилии
    public void setSurName(String surNameValue) {
        driver.findElement(surName).clear();
        driver.findElement(surName).sendKeys(surNameValue);
    }
    //метод для ввода адреса
    public void setAdress(String adressValue) {
        driver.findElement(adress).clear();
        driver.findElement(adress).sendKeys(adressValue);
    }
    //метод для выбора метро
    public void setMetro(String metroValue) {
        driver.findElement(metro).sendKeys(metroValue);// сначало вводим название станции

        if (driver.findElement(nameFromList).getText().equals(metroValue)) //если оно есть в списке, то продолжаем
        {
            driver.findElement(nameFromList).click(); //нажимаем на название станции в списке
        }

    }
    //метод для ввода телефона
    public void setPhone(String phoneValue) {
        driver.findElement(phone).clear();
        driver.findElement(phone).sendKeys(phoneValue);
    }
    //метод для нажатия кнопкии ДАЛЕЕ
    public void pressNextButton() {
        driver.findElement(nextButton).click();
    }

    //ощий метод
    public void EnterWholePersonalInformation(String nameValue, String surNameValue, String adressValue, String metroValue, String phoneValue) {
        setName(nameValue);
        setSurName(surNameValue);
        setAdress(adressValue);
        setMetro(metroValue);
        setPhone(phoneValue);
        pressNextButton();
    }

}
