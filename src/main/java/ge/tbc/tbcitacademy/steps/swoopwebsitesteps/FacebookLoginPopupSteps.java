package ge.tbc.tbcitacademy.steps.swoopwebsitesteps;

import com.codeborne.selenide.Condition;
import ge.tbc.tbcitacademy.pages.swooppages.FacebookLoginPage;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.switchTo;

public class FacebookLoginPopupSteps {

    FacebookLoginPage facebook = new FacebookLoginPage();
    SoftAssert sfa;

    public FacebookLoginPopupSteps(SoftAssert sfa) {
        this.sfa = sfa;
    }

    @Step("Switching to facebook window")
    public FacebookLoginPopupSteps switchingToPopup(){
        switchTo().window(1);
        return this;
    }

    @Step("Validating that the website that appeared is facebook")
    public FacebookLoginPopupSteps validatingThatFacebookLogoAlsoAppeared(){
        sfa.assertTrue(facebook.facebookLogo.exists());
        return this;
    }

    @Step("Validating that login page has appeared")
    public FacebookLoginPopupSteps validatingThatLoginPageAppearedIndeed(){
        sfa.assertTrue(facebook.passwordField.isDisplayed());
        return this;
    }

    @Step("Going back to default window")
    public void goingBackToDefaultWindow(){
        switchTo().defaultContent();
    }
}
