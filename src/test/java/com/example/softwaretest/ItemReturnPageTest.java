package com.example.softwaretest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemReturnPageTest {

    ItemReturnPage itemReturnPage = new ItemReturnPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/ItemReturnCreate");
    }

    // fails because no way to actually add in item using the app
    @Test
    public void returnItem() {
        String itemId = "1";
        String borrowerId = "2";
        itemReturnPage.itemIdInput.sendKeys(itemId);
        itemReturnPage.borrowerIdInput.sendKeys(borrowerId);
        itemReturnPage.submitButton.click();

        // check if error message doesn't pop up
        SelenideElement error = $("div[class='alert alert-danger']");
        error.shouldNotBe(Condition.visible);
    }

    @Test
    public void clearInput() {
        String itemId = "1";
        String borrowerId = "2";
        itemReturnPage.itemIdInput.sendKeys(itemId);
        itemReturnPage.borrowerIdInput.sendKeys(borrowerId);
        itemReturnPage.resetButton.click();
        assertEquals("0", itemReturnPage.borrowerIdInput.getAttribute("value"));
        assertEquals("0", itemReturnPage.itemIdInput.getAttribute("value"));
    }
}
