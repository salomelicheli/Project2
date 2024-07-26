package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import ge.tbc.tbcitacademy.pages.swooppages.AuthorizationPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.back;

public class AuthorizationPageSteps {

    AuthorizationPage authorize = new AuthorizationPage();
    SoftAssert sfa;

    public AuthorizationPageSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    @Step("This step returns a boolean to assert if it is necessary to login to be able to add offer to favorites")
    public AuthorizationPageSteps validatingThatAuthorization(){
         sfa.assertTrue(authorize.authorizationText.isDisplayed());
         return this;
    }

    @Step("This step returns a boolean to assert if it is necessary to login to be able to add offer to favorites")
    public AuthorizationPageSteps validatingThatLoginPasswordFieldIsPresent(){
        sfa.assertTrue(authorize.passwordField.isDisplayed());
        return this;
    }

    @Step("this step navigates back to the offers page")
    public void navigatingBack(){
        back();
    }
}
