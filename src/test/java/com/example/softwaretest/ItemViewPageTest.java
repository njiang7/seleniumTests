package com.example.softwaretest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Selenide.open;

public class ItemViewPageTest {

    ItemViewPage itemViewPage = new ItemViewPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/ItemView");
    }

    // test clicking on add item button brings you to add item page
    @Test
    public void addItem() {
        itemViewPage.addItemButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("/ItemCreate"));
    }

    // test that page loads items or displays no data found if nothing in database
    @Test
    public void listItems() {
        String text = "No Data found";
        List<WebElement> list = WebDriverRunner.getWebDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertTrue(list.size() > 0);
    }

    // Test navigation back to homepage from this page
    @Test
    public void navHomePage() {
        itemViewPage.homePageButton.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertEquals("http://localhost:8086/", currentUrl);
    }

}
