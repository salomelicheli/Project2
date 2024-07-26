package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.$;

public class CommonSidebarOfferPages {
    public static final SelenideElement sideBar = $("#sidebar");
            public SelenideElement minPriceField = sideBar.$("#minprice"),
            maxPriceField = sideBar.$("#maxprice"),
            searchButton = sideBar.$(".submit-button"),
            defaultCheckedCheckbox = $(byAttribute("checked", "checked")),
            deleteButton = sideBar.$(byTagName("i")),
            locationDropdown = sideBar.$(".ms-choice"),
            defaultLocation = locationDropdown.$(byTagName("span")),
            gldaniOption = sideBar.$("input[value='5']"),
            vaucheriPayment = sideBar.$("input[type='radio'][value='1']");
}
