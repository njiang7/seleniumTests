package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class FineCalculationPage {
    public SelenideElement idInput = $("input[id='borrowerId']");
    public SelenideElement calculateFineButton = $("button[type='submit']");
}
