package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ItemViewPage {
    public SelenideElement addItemButton = $("button[id='myButton']");
    public SelenideElement homePageButton = $(byXpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[1]"));
}
