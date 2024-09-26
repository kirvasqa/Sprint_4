package ru.praktikumservices.qascooter.pagesobject;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class TestDefaultParts {
    protected WebDriver driver;
    final String URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get(URL);

}
    @After
    public void tearDown() {

        driver.quit(); // Закрываем браузер
    }
}
