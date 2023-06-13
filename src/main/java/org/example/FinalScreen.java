package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FinalScreen {
    private WebDriver driver;
    //локатор который показывает что заза сделан
    private By finalOrderText=By.cssSelector(".Order_NextButton__1_rCA button");

    public FinalScreen(WebDriver driver) {
        this.driver = driver;
    }
    //метод который подтверждает, что заказ сделан
    public boolean isOrderEnabled(){
        return driver.findElement(finalOrderText).isEnabled();
    }
}
