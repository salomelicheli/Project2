package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbc.tbcitacademy.pages.swooppages.KidsEntertainmentOfferPage;
import io.qameta.allure.Step;

public class KidsEnterteinmentOfferPageSteps {

    KidsEntertainmentOfferPage kids = new KidsEntertainmentOfferPage();

    @Step("This step clicks on a share button on a offer page")
    public void clickingOnShareButton(){
        kids.sharingButton.click();
    }
}
