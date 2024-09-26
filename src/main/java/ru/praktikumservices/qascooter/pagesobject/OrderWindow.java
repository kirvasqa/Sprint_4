package ru.praktikumservices.qascooter.pagesobject;

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
    private final By orderButtonMid = By.xpath(".//div[5]/button[@class ='Button_Button__ra12g Button_UltraBig__UU3Lp']");
    //Поле Имя
    private final By firstNameField = By.xpath(".//div[1]/input[@placeholder ='* Имя']");
    //Поле Фамилия
    private final By secondNameField = By.xpath(".//div[2]/input[@placeholder ='* Фамилия']");
    //Поле Адрес
    private final By addressField = By.xpath(".//div[3]/input[@placeholder ='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final By metroStationField = By.className("select-search");
    //Станция метро
    private final By metroStationValue  = By.className("Order_Text__2broi");
    //Поле номер телефона
    private final By phoneNumberFiled = By.xpath(".//div[5]/input[@placeholder ='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private final By buttonNext = By.xpath(".//div[3]/button[(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Далее')]");
    //Поле Когда привезти самокат
    private final By deliveryDate = By.xpath(".//div/input[@placeholder ='* Когда привезти самокат']");
    // День аренды
    private final By deliveryDay = By.xpath(".//div[6]/div[2][text() ='1']");
    //Поле срок аренды
    private final By rentalPeriodField = By.className ("Dropdown-control");
    // Пункт списка
    private final By elementOfList = By.xpath(".//div[2]/div[4][(@class ='Dropdown-option' and text() ='четверо суток')]");
    //Кнопка Заказать в форме заказ
    private final By finalOrderButton = By.xpath(".//button[2][(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Заказать')]");
    //Кнопка Да
    private final By yesButton = By.xpath(".//button[2][(@class ='Button_Button__ra12g Button_Middle__1CSJM' and text() ='Да')]");
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

