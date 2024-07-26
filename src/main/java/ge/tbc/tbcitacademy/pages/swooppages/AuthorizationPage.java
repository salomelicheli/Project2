package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class AuthorizationPage {
    public SelenideElement
            authorizationText = $(withText("ავტორიზაცია")),
            passwordField = $("#Password");
}
