package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageForOrderingSamokat {
    private WebDriver driver;
    //локатор для верхней кнопки ЗАКАЗАТЬ
    private By FirstOrderButton = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    //локатор для нижней кнопки ЗАКАЗАТЬ
    private By SecondOrderButton = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public MainPageForOrderingSamokat(WebDriver driver) {
        this.driver = driver;
    }

    //метод который нажимает на выбранную кнопку ЗАКАЗАТЬ
    public void pressOrderButton(int numberOfButton) {
        if (numberOfButton == 1) {
            driver.findElement(FirstOrderButton).click();
        } else {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(SecondOrderButton));
            driver.findElement(SecondOrderButton).click();
        }

    }
}
