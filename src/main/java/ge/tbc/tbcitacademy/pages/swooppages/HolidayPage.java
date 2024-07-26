package ge.tbc.tbcitacademy.pages.swooppages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$;

public class HolidayPage {
    public ElementsCollection holidayOffers = $(".items").$$("div.discounted-prices > p:first-child");
}
