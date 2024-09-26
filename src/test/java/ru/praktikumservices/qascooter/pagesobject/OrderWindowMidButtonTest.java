package ru.praktikumservices.qascooter.pagesobject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class OrderWindowMidButtonTest extends TestDefaultParts {
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

    @Test
    public void midButtonOrderTest(){
        OrderWindow objOrderWindow = new OrderWindow(driver);
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

}