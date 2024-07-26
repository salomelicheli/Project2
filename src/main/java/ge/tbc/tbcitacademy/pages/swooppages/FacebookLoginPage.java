package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;

public class FacebookLoginPage {
    public SelenideElement
            facebookLogo = $(withTagAndText("h2","Facebook")),
            passwordField = $("#pass");
}
