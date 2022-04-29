package com.example.softwaretest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserManagementPageTest {

    String text = "error";

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/");
        SelenideElement navModules = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
        navModules.click();
        SelenideElement navElement = $(byXpath("//*[@id=\"sidenavAccordionPages\"]/a[7]"));
        navElement.click();
    }

    // none of these links work so we are just checking if clicking on them will return a page with the word error
    @Test
    public void accountManagement() {
        SelenideElement link = $(byXpath("//*[@id=\"pagesCollapseUser\"]/nav/a[1]"));
        link.click();
        List<WebElement> list = WebDriverRunner.getWebDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertFalse(list.size() > 0); //check webpage doesn't have error

    }

    @Test
    public void addUser() {
        SelenideElement link = $(byXpath("//*[@id=\"pagesCollapseUser\"]/nav/a[2]"));
        link.click();
        List<WebElement> list = WebDriverRunner.getWebDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertFalse(list.size() > 0); //check webpage doesn't have error
    }

    @Test
    public void changePassword() {
        SelenideElement link = $(byXpath("//*[@id=\"pagesCollapseUser\"]/nav/a[3]"));
        link.click();
        List<WebElement> list = WebDriverRunner.getWebDriver().findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
        assertFalse(list.size() > 0); //check webpage doesn't have error
    }

}
