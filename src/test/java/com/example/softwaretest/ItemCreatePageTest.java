package com.example.softwaretest;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ItemCreatePageTest {

    ItemCreatePage itemCreatePage = new ItemCreatePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/ItemCreate");
    }

    // test creating an item
    @Test
    public void createItem() {
        itemCreatePage.itemNameInput.sendKeys("item name");
        itemCreatePage.itemPriceInput.sendKeys("100");
        itemCreatePage.itemQuantityInput.sendKeys("1");
        itemCreatePage.fineRateInput.sendKeys("0.5");
        itemCreatePage.invoiceNumberInput.sendKeys("1");
        itemCreatePage.vendorNameInput.sendKeys("vendor");
        itemCreatePage.issueButton.click();

        // check if error message doesn't pop up
        SelenideElement error = $("div[class='alert alert-danger']");
        error.shouldNotBe(Condition.visible);
    }

    // test clearing input fields
    @Test
    public void clearInput() {
        itemCreatePage.itemNameInput.sendKeys("item name");
        itemCreatePage.resetButton.click();
        itemCreatePage.itemNameInput.shouldBe(Condition.empty);
    }
}
