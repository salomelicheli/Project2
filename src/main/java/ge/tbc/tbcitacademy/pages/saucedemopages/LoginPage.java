package ge.tbc.tbcitacademy.pages.saucedemopages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
   public SelenideElement userNameField = $("#user-name"),
           passwordField = $("#password"),
           loginButton = $("#login-button"),
           errorElement = $("h3[data-test='error']");
   public ElementsCollection errorXes = $$("svg[data-prefix='fas']");
}
