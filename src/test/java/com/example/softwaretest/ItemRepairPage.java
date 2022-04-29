package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ItemRepairPage {
    public SelenideElement itemIdInput = $("input[id='itemId']");
    public SelenideElement vendorIdInput = $("input[id='vendorId']");
    public SelenideElement itemPriceInput = $("input[id='price']");
    public SelenideElement repairCostInput = $("input[id='repairCost']");
    public SelenideElement resetButton = $("button[type='reset']");
    public SelenideElement submitButton = $("button[type='submit']");
}
