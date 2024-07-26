package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbc.tbcitacademy.data.DefaultLocationData;
import ge.tbc.tbcitacademy.pages.swooppages.CommonSidebarOfferPages;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Condition.*;


public class CommonSidebarOfferPagesSteps {

    CommonSidebarOfferPages sidebar = new CommonSidebarOfferPages();
    DefaultLocationData location = new DefaultLocationData();

    @Step("This step indicates the maximum price of the offer which is : {0}")
    public CommonSidebarOfferPagesSteps fillingInMaximumPrice(int maxPrice){
        sidebar.maxPriceField.sendKeys(String.valueOf(maxPrice));
        return this;
    }

    @Step("This step indicates the minimum price of the offer which is : {0}")
    public CommonSidebarOfferPagesSteps fillingInMinimumPrice(int minPrice){
        sidebar.minPriceField.sendKeys(String.valueOf(minPrice));
        return this;
    }

    @Step("After filling out min and max price fields this step clicks on a search button")
    public void clickingOnSearchButton(){
        sidebar.searchButton.click();
    }

    @Step("This step sets the default location in the dropdown before changing it")
    public CommonSidebarOfferPagesSteps setDefaultLocation(){
        location.setDefaultLocation(sidebar.defaultLocation.text());
        return this;
    }

    @Step("This step gets the default location in the dropdown before changing it")
    public String getDefaultLocationBeforeFilter(){
        return location.getDefaultLocation();
    }

    @Step("This step clicks on a dropdown so it shows the options or just closes it")
    public CommonSidebarOfferPagesSteps clickOnADropDown(){
        sidebar.locationDropdown.click();
        return this;
    }

    @Step("This step chooses gldani from the location dropdown")
    public CommonSidebarOfferPagesSteps chooseGldani(){
        sidebar.gldaniOption.click();
        return this;
    }

    @Step("This step changes the default payment checkbox, the default has checked attribute")
    public CommonSidebarOfferPagesSteps chooseAPaymentMethod(){
        sidebar.vaucheriPayment.click();
        return this;
    }

    @Step("This step clears the filters and sets settings to default")
    public CommonSidebarOfferPagesSteps clearFilters(){
        sidebar.deleteButton.click();
        return this;
    }

    @Step("The field default value is an empty string so this step checks if it is back to an empty default after clearing filter")
    public CommonSidebarOfferPagesSteps validatingMinField(){
        sidebar.minPriceField.shouldHave(value(""));
        return this;
    }

    @Step("The field default value is an empty string so this step checks if it is back to an empty default after clearing filter")
    public void validateMaxField(){
        sidebar.maxPriceField.shouldHave(value(""));
    }

    @Step("This step checks whether or not default checked checkbox is selected after clearing the filters")
    public boolean validateIfDefaultCheckboxIsSelected(){
        return sidebar.defaultCheckedCheckbox.isSelected();
    }

    @Step("This step sets location after clearing the filter to see if it's back to default - yvela mdebareoba")
    public CommonSidebarOfferPagesSteps setLocationAfterClearingFilter(){
        location.setDefaultLocationAfterDeletingFilter(sidebar.defaultLocation.text());
        return this;
    }

    @Step("This step sets location after clearing the filter to see if it's back to default - yvela mdebareoba")
    public String getLocationAfterClearingFilter(){
        return location.getDefaultLocationAfterDeletingFilter();
    }
}
