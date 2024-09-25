package ru.praktikum_services.qa_scooter.pages_object;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LandingPageScooterTest {

    private WebDriver driver;
    private LandingPageScooter objLandingPageScooter;
    private final int index;
    private final String expectedText;




    @Parameterized.Parameters
    public static Object[][] expectedText() {
        return new Object[][]{
                {0, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1,"Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2,"Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3,"Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4,"Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5,"Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6,"Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }
    public LandingPageScooterTest(int index, String expectedText) {
        this.index = index;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        objLandingPageScooter = new LandingPageScooter(driver);



    }


    @Test
    public void faqAccordionScooterTest() {
        objLandingPageScooter.waitLoadLandingPageScooter();
        objLandingPageScooter.clickOnAcceptCookieButton();
        objLandingPageScooter.expandFaqSection(index);

        // Добавляем явное ожидание для текстов в панелях FAQ. (Для визуализации процесса)
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(objLandingPageScooter.faqAccordionPanel(index)));

        String actualText = objLandingPageScooter.getFaqAccordionItemPanelText(index);

        // Используем trim для сравнения текстов (Убрали зависимость от форматирования текста)
        assertEquals(expectedText.trim(), actualText.trim());
    }


    @After
    public void tearDown() {
        driver.quit(); // Закрываем браузер
    }
}