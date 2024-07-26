package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class CommonPage {
    public SelenideElement
            element = $(".Menus").$(withText("დასვენება")),
            cookieButton = $(".cookieButton"),
            categoryDropdown = $("div[class*='NewCategories']"),
            someCategory = $("div.LeftSideCategories").$(withText("საბავშვო")),
            subCategory = $("div.subCategory-4 a[href*='2048']"),
            kidsCategoryIcon = $(".Menus").$(withText("საბავშვო"));
}
