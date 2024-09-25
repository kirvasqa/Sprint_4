package ru.praktikum_services.qa_scooter.pages_object;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

class OrderWindow {
    private final WebDriver driver;
    //Кнопка заказать верх страницы
    private final By orderButtonTop = By.className("Button_Button__ra12g");
    //Принять куки
    private final By acceptCookieButton = By.className("App_CookieButton__3cvqF");
    //Кнопка заказать в середине страницы
    private final By orderButtonMid = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");
    //Поле Имя
    private final By firstNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    //Поле Фамилия
    private final By secondNameField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    //Поле Адрес
    private final By addressField = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    //Поле Станция метро
    private final By metroStationField = By.className("select-search");
    //Станция метро
    private final By metroStationValue  = By.className("Order_Text__2broi");
    //Поле номер телефона
    private final By phoneNumberFiled = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    //Кнопка Далее
    private final By buttonNext = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");
    //Поле Когда привезти самокат
    private final By deliveryDate = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // День аренды
    private final By deliveryDay = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[5]/div[5]");
    //Поле срок аренды
    private final By rentalPeriodField = By.className ("Dropdown-control");
    // Пункт списка
    private final By elementOfList = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[2]/div[4]");
    //Кнопка Заказать в форме заказ
    private final By finalOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    //Кнопка Да
    private final By yesButton = By.xpath("/html/body/div/div/div[2]/div[5]/div[2]/button[2]");
    //Заголовок заказ оформлен
    private final By orderPlaced = By.xpath(".//div[(@class = 'Order_ModalHeader__3FDaJ' and text() ='Заказ оформлен')]");

    public OrderWindow(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOrderButtonTop() {

        driver.findElement(orderButtonTop).click();
    }
    public void clickAcceptCookieButton() {

        driver.findElement(acceptCookieButton).click();
    }
        public void clickOrderButtonMid() {
            driver.findElement(orderButtonMid).click();
    }
        public void setFirstName(String firstName) {
            driver.findElement(firstNameField).sendKeys(firstName);
        }

        public void setSecondNameField(String secondName) {
            driver.findElement(secondNameField).sendKeys(secondName);
        }
        public void setAddressField(String address) {
            driver.findElement(addressField).sendKeys(address);
        }
        public void clickMetroStationField() {
            driver.findElement(metroStationField).click();
        }
    public void  waitMetroStationList() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(metroStationValue));
    }
        public void clickMetroStationValue() {
            driver.findElement(metroStationValue).click();
        }
        public void setPhoneNumberFiled(String phone) {
            driver.findElement(phoneNumberFiled).sendKeys(phone);
        }
        public void clickButtonNext() {
            driver.findElement(buttonNext).click();
        }
        public void  waitOrderSecondStage() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDate));
    }
        public void clickDeliveryDate() {
            driver.findElement(deliveryDate).click();
        }
    public void  waitDeliveryDay() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(deliveryDay));
    }
        public void clickDeliveryDay() {
        driver.findElement(deliveryDay).click();
        }
        public void clickRentalPeriodField() {
        driver.findElement(rentalPeriodField).click();
        }
    public void  waitElementOfList() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(elementOfList));
    }
        public void clickElementOfList() {
            driver.findElement(elementOfList).click();
        }
        public void clickFinalOrderButton() {
            driver.findElement(finalOrderButton).click();
        }
    public void  waitYesButton() {
         new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
}
public void clickYesButton() {
        driver.findElement(yesButton).click();
    }
    public boolean isOrderHeaderVisible() {
        try {
            return driver.findElement(orderPlaced).isDisplayed();
        } catch (NoSuchElementException e) {

            return false;
        }
    }

    }

