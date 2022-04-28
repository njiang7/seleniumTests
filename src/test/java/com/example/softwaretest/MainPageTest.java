package com.example.softwaretest;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static com.codeborne.selenide.Selectors.*;
import static org.junit.jupiter.api.Assertions.*;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPageTest {

    MainPage mainPage = new MainPage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/");
    }

    @Test
    public void testSearch() {
        mainPage.searchBox.sendKeys("searching for this");
        mainPage.searchButton.click();
        sleep(1000);
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertNotEquals("http://localhost:8086/", currentUrl); // no specs given for search, so just assume it loads some other page
    }

    @Test
    public void testDropDownMenu() {
        mainPage.dropDown.click();
        assertEquals("true", $(By.id("userDropdown")).getAttribute("aria-expanded"));
    }

    // fails, logging out doesn't do anything
    @Test
    public void testLogOut() {
        mainPage.dropDown.click();
        SelenideElement logout = $(byXpath("/html/body/div[2]/nav/ul/li/div/a[3]"));
        SelenideElement userDisplay = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[2]"));
        logout.click();
        String currentUser = "Inventory Manager";
        String user = userDisplay.getText();
        assertFalse(user.contains(currentUser));
    }

    @Test
    public void testHamburgerMenu() {
        WebDriver driver = WebDriverRunner.getWebDriver();
        mainPage.hamburgerMenu.click();
        mainPage.hamburgerMenu.click();
        assertTrue(driver.findElement(byCssSelector("div[class='sb-sidenav-menu']")).isDisplayed());
    }

    @Test
    public void testNavigation() {
        SelenideElement navModules = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
        navModules.click();
        SelenideElement navElement = $(byXpath("//*[@id=\"sidenavAccordionPages\"]/a[2]"));
        navElement.click();
        SelenideElement addItem = $(byXpath("//*[@id=\"pagesCollapseItem\"]/nav/a[2]"));
        addItem.click();
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        sleep(1000);
        assertTrue(currentUrl.contains("/ItemCreate"));
    }



}
