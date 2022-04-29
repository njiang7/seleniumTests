package com.example.softwaretest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class AuthenticationPageTest {

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/");
    }

    // fails: clicking on login doesn't do anything
    @Test
    public void testLogin() {
        SelenideElement navModules = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
        navModules.click();
        SelenideElement authentication = $(byXpath("//*[@id=\"sidenavAccordionPages\"]/a[1]"));
        authentication.click();
        SelenideElement login = $(byXpath("//*[@id=\"pagesCollapseAuth\"]/nav/a[1]"));
        login.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("login"));
    }

    // fails: clicking on register doesn't do anything
    @Test
    public void testCreateAccount() {
        SelenideElement navModules = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
        navModules.click();
        SelenideElement authentication = $(byXpath("//*[@id=\"sidenavAccordionPages\"]/a[1]"));
        authentication.click();
        SelenideElement register = $(byXpath("//*[@id=\"pagesCollapseAuth\"]/nav/a[2]"));
        register.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("register"));
    }
}
