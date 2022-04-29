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

public class ItemIssuanceCreatePageTest {

    ItemIssuanceCreatePage itemIssuanceCreatePage = new ItemIssuanceCreatePage();

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        open("http://localhost:8086/ItemIssuanceCreate");
    }

    // fails because no way to actually add an item or borrower to the database using app
    @Test
    public void issueItem() {
        itemIssuanceCreatePage.itemIdInput.sendKeys("1");
        itemIssuanceCreatePage.borrowerIdInput.sendKeys("2");
        itemIssuanceCreatePage.loanDurationInput.sendKeys("3");
        itemIssuanceCreatePage.issueButton.click();

        // check if error message doesn't pop up
        SelenideElement error = $("div[class='alert alert-danger']");
        error.shouldNotBe(Condition.visible);
    }

    @Test
    public void clearInput() {
        itemIssuanceCreatePage.itemIdInput.sendKeys("1");
        itemIssuanceCreatePage.borrowerIdInput.sendKeys("2");
        itemIssuanceCreatePage.loanDurationInput.sendKeys("3");
        itemIssuanceCreatePage.cancelButton.click();

        assertEquals("0", itemIssuanceCreatePage.itemIdInput.getAttribute("value"));
        assertEquals("0", itemIssuanceCreatePage.borrowerIdInput.getAttribute("value"));
        assertEquals("0", itemIssuanceCreatePage.loanDurationInput.getAttribute("value"));
    }


}
