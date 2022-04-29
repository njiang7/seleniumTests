package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemReturnPage {
    public SelenideElement itemIdInput = $("input[id='itemId']");
    public SelenideElement borrowerIdInput = $("input[id='borrowerId']");
    public SelenideElement submitButton = $("button[type='submit']");
    public SelenideElement resetButton = $("button[type='reset']");
}
