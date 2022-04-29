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

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FineCalculationPageTest {

    FineCalculationPage fineCalculationPage = new FineCalculationPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/FineCreate");
    }


    // fails because there is no way to actually add a borrower
    @Test
    public void testCalculateFine() {
        String borrowerId = "1";
        fineCalculationPage.idInput.sendKeys(borrowerId);
        fineCalculationPage.calculateFineButton.click();
        String text = "error";
        List<WebElement> list = WebDriverRunner.getWebDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertFalse(list.size() > 0); //check webpage doesn't have error
    }
}
