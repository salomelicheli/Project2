package ge.tbc.tbcitacademy.pages.saucedemopages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {
    public ElementsCollection imageElements = $$(".inventory_item_img img");
    public SelenideElement
            menuButton = $("#react-burger-menu-btn"),
            logoutButton = $("#logout_sidebar_link");
}
