package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemCreatePage {
    public SelenideElement itemNameInput = $("input[id='itemName']");
    public SelenideElement itemPriceInput = $("input[id='itemPrice']");
    public SelenideElement itemQuantityInput = $("input[id='itemQuantity']");
    public SelenideElement fineRateInput = $("input[id='fineRate']");
    public SelenideElement invoiceNumberInput = $("input[id='invoiceNumber']");
    public SelenideElement vendorNameInput = $("input[id='vendorName']");
    public SelenideElement resetButton = $("button[id='resetBtn']");
    public SelenideElement issueButton = $("button[id='addBtn']");
}
