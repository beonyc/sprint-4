package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class rentPageOrder {
    private WebDriver driver;
    //локатор для поля с датой привоза самоката
    private By arrivalDate = By.xpath(".//*[@class='Order_Form__17u6u']//input[@placeholder='* Когда привезти самокат']");
    //локатор появляющегося календаря в поле с датйо привоза с выбранной датой
    private By calendar = By.xpath(".//*[contains(@class,'react-datepicker__day--selected')]");
    //локатор инпута с  скроком аренды
    private By rentalPeriodInput = By.cssSelector(".Dropdown-control");
    //локатор для выбранного срока аренды, который полностью инициалищзируется в методе, в зависимости от входных данных
    private By rentalListNumber;
    //локатор чёрного цвета
    private By colorBlack = By.cssSelector("#black.Checkbox_Input__14A2w");
    //локатор серого цвета
    private By colorGrey = By.cssSelector("#grey.Checkbox_Input__14A2w");
    //локатор инпута с коментариями
    private By commentInput = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    //локатор кнопки ЗАКАЗАТЬ
    private By orderButton = By.xpath(".//*[@class='Order_Buttons__1xGrp']//button[text()='Заказать']");
    //локатор кнопки потвреждения заказа
    private By yesButton = By.xpath(".//*[@class='Order_Buttons__1xGrp']/button[text()='Да']");

    //конструктор
    public rentPageOrder(WebDriver driver) {
        this.driver = driver;
    }
    //метод для ввода даты доставки
    public void setArrivalDate(String dateValue) {
        driver.findElement(arrivalDate).sendKeys(dateValue);//сначало вводим саму дату
        driver.findElement(calendar).click();//нажимаем на введеную дату ужеь в самом календаре, чтобы он закрылся

    }
    //метод для выбора срорка аренды,в качестве входных параметров идут стринговые цифры от 1 до 7  - это и есть количество суток
    public void setRentalPeriod(String periodValue) {

        rentalListNumber = By.xpath(".//*[contains(@class,'Dropdown-option')]" + "[" + Integer.parseInt(periodValue) + "]");//локатор для выбранного срока аренды
        driver.findElement(rentalPeriodInput).click();
        driver.findElement(rentalListNumber).click();
    }

    //метод для выбора цвета в зависимости от введеных данных
    public void setColor(String color) {
        if (color.contains("black") && color.contains("grey")) {
            driver.findElement(colorBlack).click();
            driver.findElement(colorGrey).click();
        } else if (color.equals("black")) {
            driver.findElement(colorBlack).click();
        } else {
            driver.findElement(colorGrey).click();
        }
    }
    //метод для ввода коментария
    public void setComment(String commentValue) {
        driver.findElement(commentInput).sendKeys(commentValue);
    }
    //метод для нажатия кнопки ЗАКАЗАТЬ
    public void pressOrderButton() {
        driver.findElement(orderButton).click();
    }
    //метод для подтверждения заказа
    public void confirmOrder() {
        driver.findElement(yesButton).click();
    }
    // объеденённый метод
    public void enterWholeRentInformation(String dateValue, String periodValue, String color, String commentValue) {
        setArrivalDate(dateValue);
        setRentalPeriod(periodValue);
        setColor(color);
        setComment(commentValue);
        pressOrderButton();
        confirmOrder();
    }


}
