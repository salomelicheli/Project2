package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import com.codeborne.selenide.conditions.webdriver.CurrentFrameUrlContaining;
import ge.tbc.tbcitacademy.helper.HelperMethods;
import ge.tbc.tbcitacademy.pages.swooppages.HolidayPage;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.webdriver;
import static ge.tbc.tbcitacademy.data.ConstantData.MIN_PRICE;

public class HolidayPageSteps {

    HolidayPage holidayPage = new HolidayPage();

    @Step("This step returns prices of all the offers on the first page")
    public HolidayPageSteps pageLoad(){
        webdriver().shouldHave(new CurrentFrameUrlContaining(MIN_PRICE));
        return this;
    }

    @Step("this step surfs on first page and check all the prices if they are in the range")
    public List<Double> surfOffersOnFirstPage() {
        List<Double> prices = new ArrayList<>();
        loadingList(prices);
        return prices;
    }

    private void loadingList(List<Double> prc){
        holidayPage.holidayOffers.forEach(x-> prc.add(HelperMethods.extractPrice(x)));
    }
}
