package ru.praktikum_services.qa_scooter.pages_object;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;

public class ClickOnScooterLogoTest {
    private WebDriver driver;

    @Test
    public void checkScooterLogo() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        LandingPageScooter objLandingPage = new LandingPageScooter(driver);

        objLandingPage.clickOnOrderButton();

        objLandingPage.waitLoadOrderWindow();

        objLandingPage.clickOnScooterLogo();

        objLandingPage.waitLoadLandingPageScooter();

        boolean isLogoVisible = objLandingPage.isScooterHeaderVisible();
        Assert.assertTrue("Заголовок самоката должен быть видим на главной странице", isLogoVisible);
    }

    @After
    public void teardown() {
        driver.quit();
    }

}
