package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemIssuanceCreatePage {
    public SelenideElement itemIdInput = $("input[id='itemId']");
    public SelenideElement borrowerIdInput = $("input[id='borrowerId']");
    public SelenideElement loanDurationInput = $("input[id='loanDuration']");
    public SelenideElement cancelButton = $("button[type='reset']");
    public SelenideElement issueButton = $("button[type='submit']");

}
