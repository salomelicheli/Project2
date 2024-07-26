package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class KidsCategoryPage {
    public SelenideElement offerContainer = $(".items"),
            firstReturnedOffer = offerContainer.$(".special-offer"),
            prBar = firstReturnedOffer.$("div.voucher-limit"),
            favoritesButton = $("div.dis-price"),
            randomOption = $("#sidebar").$(withText("გმირების გამოძახება")),
            offerWithZeroInText = offerContainer.$$(".special-offer").filterBy(text("გაყიდულია 0")).get(1),
            progressBar = offerWithZeroInText.$("div.voucher-limit"),
            paginationButton = $x("//a[./img[contains(@src, 'arrow-01')]]");
}
