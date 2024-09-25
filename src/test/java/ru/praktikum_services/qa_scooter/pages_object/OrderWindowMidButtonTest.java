package ru.praktikum_services.qa_scooter.pages_object;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

@RunWith(Parameterized.class)
public class OrderWindowMidButtonTest {
    private WebDriver driver;
    private OrderWindow objOrderWindow;
    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phone;

    @Parameterized.Parameters
    public static Object[][] userData() {
        return new Object[][]{
                {"Кирилл", "Васильев", "ул. Пушкина", "+79999999999"}
        };
    }
    public OrderWindowMidButtonTest(String firstName, String secondName, String address, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
    }
    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Этот аргумент не поддерживается в Firefox, можно удалить

        // Инициализируем FirefoxDriver
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objOrderWindow = new OrderWindow(driver);
    }
    @Test
    public void MidButtonOrderTest(){
        objOrderWindow.clickAcceptCookieButton();
        objOrderWindow.clickOrderButtonMid();
        objOrderWindow.setFirstName(firstName);
        objOrderWindow.setSecondNameField(secondName);
        objOrderWindow.setAddressField(address);
        objOrderWindow.clickMetroStationField();
        objOrderWindow.waitMetroStationList();
        objOrderWindow.clickMetroStationValue();
        objOrderWindow.setPhoneNumberFiled(phone);
        objOrderWindow.clickButtonNext();
        objOrderWindow.waitOrderSecondStage();
        objOrderWindow.clickDeliveryDate();
        objOrderWindow.waitDeliveryDay();
        objOrderWindow.clickDeliveryDay();
        objOrderWindow.clickRentalPeriodField();
        objOrderWindow.waitElementOfList();
        objOrderWindow.clickElementOfList();
        objOrderWindow.clickFinalOrderButton();
        objOrderWindow.waitYesButton();
        objOrderWindow.clickYesButton();

        boolean isHeaderVisible;
        isHeaderVisible = objOrderWindow.isOrderHeaderVisible();
        Assert.assertTrue("Заголовок должен быть видим на странице", isHeaderVisible);
    }
    @After
    public void tearDown() {
        driver.quit(); // Закрываем браузер
    }
}