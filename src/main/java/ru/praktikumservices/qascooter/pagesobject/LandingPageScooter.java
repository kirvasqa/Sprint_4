package ru.praktikumservices.qascooter.pagesobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
class LandingPageScooter {

  private final WebDriver driver;


   // Локаторы
   private final By headerYandex = By.className("Header_LogoYandex__3TSOI"); // Лого Яндекс
   private final By headerScooter = By.className("Header_LogoScooter__3lsAR"); // Лого Самокат
   private final By orderButton = By.className("Button_Button__ra12g");// Кнопка заказать
   private final By acceptCookieButton = By.className("App_CookieButton__3cvqF"); // Кнопка принять куки
   private final By scooterLandingPageHeader = By.className("Home_Header__iJKdX"); // Первая строка из заголовка Самокат на пару дней

   // Параметры для работы с Вопросы о важном
   private By faqAccordionHeader(int index) {
      return By.xpath(".//div[contains(@id,'accordion__heading-" + index + "')]"); // Вопрос
   }
   public By faqAccordionPanel(int index) {
      return By.xpath(".//div[contains(@id,'accordion__panel-" + index + "')]"); //Панель с ответом
   }

   public LandingPageScooter(WebDriver driver) {
       this.driver = driver;
      PageFactory.initElements(driver, this);
   }
   public void clickOnAcceptCookieButton(){
      driver.findElement(acceptCookieButton).click();
   }
   // Метод для ожидания элемента

   public void scrollToAccordion(WebElement faqAccordionHeader) {
      ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", faqAccordionHeader);
   }

   // Расширение секции FAQ
   public void expandFaqSection(int index) {
      WebElement accordionHeader = driver.findElement(faqAccordionHeader(index));
      scrollToAccordion(accordionHeader); // Прокрутка к заголовку аккордеона перед кликом
      accordionHeader.click();
   }



   // Получение текста панели ответа FAQ
   public String getFaqAccordionItemPanelText(int index) {
      WebElement accordionPanel = driver.findElement(faqAccordionPanel(index));
      return accordionPanel.getText();
   }
   public void clickOnScooterLogo() {
      driver.findElement(headerScooter).click();
   }
   public void clickOnOrderButton() {
      driver.findElement(orderButton).click();
   }
   public void  waitLoadLandingPageScooter() {
      new WebDriverWait(driver, Duration.ofSeconds(10))
              .until(ExpectedConditions.visibilityOfElementLocated(scooterLandingPageHeader));
   }

   public boolean isScooterHeaderVisible() {
      return driver.findElement(headerScooter).isDisplayed();
   }

   public void waitLoadOrderWindow(){
      new WebDriverWait(driver, Duration.ofSeconds(10))
              .until(ExpectedConditions.visibilityOfElementLocated(By.className("Order_Header__BZXOb")));
   }



}