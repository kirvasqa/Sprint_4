package ru.praktikumservices.qascooter.pagesobject;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.After;
import org.junit.Test;

public class ClickOnScooterLogoTest extends TestDefaultParts {


    @Test
    public void checkScooterLogo() {

        LandingPageScooter objLandingPage = new LandingPageScooter(driver);

        objLandingPage.clickOnOrderButton();

        objLandingPage.waitLoadOrderWindow();

        objLandingPage.clickOnScooterLogo();

        objLandingPage.waitLoadLandingPageScooter();

        boolean isLogoVisible = objLandingPage.isScooterHeaderVisible();
        Assert.assertTrue("Заголовок самоката должен быть видим на главной странице", isLogoVisible);
    }
}
