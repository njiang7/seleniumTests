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
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemRepairPageTest {

    ItemRepairPage itemRepairPage = new ItemRepairPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/ItemRepairCreate");
    }

    // fails since no way to add items or vendors using the app
    @Test
    public void submitRepair() {
        itemRepairPage.itemIdInput.sendKeys("1");
        itemRepairPage.vendorIdInput.sendKeys("2");
        itemRepairPage.itemPriceInput.sendKeys("3");
        itemRepairPage.repairCostInput.sendKeys("3");
        itemRepairPage.submitButton.click();

        // check if error message doesn't pop up
        SelenideElement error = $("div[class='alert alert-danger']");
        error.shouldNotBe(Condition.visible);
    }

    @Test
    public void clearForm() {
        itemRepairPage.itemIdInput.sendKeys("1");
        itemRepairPage.vendorIdInput.sendKeys("2");
        itemRepairPage.itemPriceInput.sendKeys("3");
        itemRepairPage.repairCostInput.sendKeys("3");
        itemRepairPage.resetButton.click();

        assertEquals("0", itemRepairPage.itemIdInput.getAttribute("value"));
        assertEquals("0", itemRepairPage.vendorIdInput.getAttribute("value"));
        assertEquals("0.0", itemRepairPage.itemPriceInput.getAttribute("value"));
        assertEquals("0.0", itemRepairPage.repairCostInput.getAttribute("value"));
    }
}
