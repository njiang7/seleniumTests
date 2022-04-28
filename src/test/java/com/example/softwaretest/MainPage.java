package com.example.softwaretest;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    public SelenideElement searchBox = $("input[class='form-control']");
    public SelenideElement searchButton = $("button[class='btn btn-primary']");
    public SelenideElement dropDown = $("a[id='userDropdown']");
    public SelenideElement hamburgerMenu = $("button[id='sidebarToggle']");


}
