package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbc.tbcitacademy.pages.swooppages.KidsCategoryPage;
import io.qameta.allure.Step;


public class KidsCategoryPageSteps {

    KidsCategoryPage kids= new KidsCategoryPage();

    @Step("This step checks if adding item to favorites is impossible without authorization")
    public void addingItemToFavorites(){
        kids.favoritesButton.click();
    }

    @Step("This step navigates to first returned offer")
    public void navigatingToFirstOffer(){
        kids.firstReturnedOffer.click();
    }

    @Step("This step checks the progress bar and determines if the vouchers are sold out, returns a double to assert")
    public boolean checkThatVouchersAreNotSoldOut(){
        return Double.parseDouble(kids.prBar.getAttribute("data-width")) < 100;
    }

    @Step("This step is for scrolling so the elements are into view")
    public void scrollToSideBarFilters(){
        kids.randomOption.scrollTo();
    }

    @Step("This step searches for a zero sell item in the offer, it will surf the pages until it finds one")
    public KidsCategoryPageSteps findOfferWithZeroSells(){
        while(!kids.offerWithZeroInText.isDisplayed()){
            kids.paginationButton.click();
        }
        return this;
    }

    @Step("If the zero sold offer has been found, we scroll so it's well into view")
    public void scrollToOfferIfFound(){
        kids.offerWithZeroInText.scrollTo();
    }

    @Step("This Step gets progressbar value in double to assert that offer with zero sells in text indeed has zero sells")
    public boolean getProgressBarValueOfZeroSoldOffer(){
        return Double.parseDouble(kids.progressBar.getAttribute("data-width")) == 0;
    }

}
