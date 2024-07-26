package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbc.tbcitacademy.pages.swooppages.CommonPage;
import io.qameta.allure.Step;

public class CommonSteps {

     CommonPage common = new CommonPage();

     @Step("This step clicks on a holiday option on a common menu bar")
     public void clickHolidayOptionOnMenuBar(){
         common.element.click();
     }

     @Step("This step clicks on a button to accept cookies so the bar doesn't intervene")
     public void acceptingCookies(){
         common.cookieButton.click();
     }

     @Step("This step will click on a categories dropdown")
     public CommonSteps clickOnCategoriesDropdown(){
         common.categoryDropdown.click();
         return this;
     }

     @Step("This step will hover on cars category to display subcategories")
     public CommonSteps hoverOnAnyCategory(){
        common.someCategory.hover();
        return this;
     }

     @Step("This step will choose a subcategory")
     public void clickingOnASubcategory(){
         common.subCategory.click();
     }

     @Step("This step takes us to the kids category")
     public void clickOnKidsCategory(){
         common.kidsCategoryIcon.click();
     }
}
