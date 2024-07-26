package ge.tbc.tbcitacademy.tests.saucedemo;

import ge.tbc.tbcitacademy.data.DataBaseSteps;
import ge.tbc.tbcitacademy.helper.Configurations;
import ge.tbc.tbcitacademy.helper.UserModel;
import ge.tbc.tbcitacademy.pages.saucedemopages.ProfilePage;
import ge.tbc.tbcitacademy.steps.saucedemosteps.LoginPageSteps;
import ge.tbc.tbcitacademy.steps.saucedemosteps.ProfilePageSteps;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.tbcitacademy.data.ConstantData.ERROR_MESSAGE;
import static ge.tbc.tbcitacademy.data.ConstantData.SAUCE_DEMO_LINK;

@Test(groups = "SauceDemoLogin")
@Epic("Login Tests")
@Feature("SauceDemo Login")
public class LoginTests extends Configurations {
    DataBaseSteps dbSteps;
    LoginPageSteps loginPageSteps;
    ProfilePageSteps profilePage;
    ProfilePage prf;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        dbSteps = new DataBaseSteps();
        loginPageSteps = new LoginPageSteps();
        profilePage = new ProfilePageSteps();
        prf = new ProfilePage();
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){
        open(SAUCE_DEMO_LINK);
    }

    @Severity(SeverityLevel.CRITICAL)
    @Story("Standard user profile test")
    @Description("Testing standard user page to check the images displayed")
    @Test( priority = 2, description = "Checking that the images are loaded correctly")
    public void successfulLoginTest() {
        UserModel user = dbSteps.getSpecificUserInfo(1001);
        loginPageSteps.fillOutUserNameField(user.getUsername())
                .fillOutPasswordField(user.getPassword())
                .clickOnLoginButton();
        Assert.assertEquals(profilePage.checkingImages(), profilePage.elementsCollectionSize());
    }

    @Severity(SeverityLevel.MINOR)
    @Story("banned user profile test")
    @Description("Testing banned user page to check the outputs")
    @Test(priority = 4, description = "Checking that the error message and icons appear indeed")
    public void bannedUserLoginTest() {
        UserModel user = dbSteps.getSpecificUserInfo(1002);
        loginPageSteps.fillOutUserNameField(user.getUsername())
                .fillOutPasswordField(user.getPassword())
                .clickOnLoginButton()
                .validateThatXiconsareVisible();
        sfa.assertEquals(loginPageSteps.errorMessage(), ERROR_MESSAGE);

    }

    @Severity(SeverityLevel.MINOR)
    @Story("Problematic user profile test")
    @Description("Testing problematic user page to check that the images are not displayed correctly")
    @Test(priority = 1, description = "Checking that the images are not loaded correctly")
    public void problematicLoginTest() {
        UserModel user = dbSteps.getSpecificUserInfo(1003);
        loginPageSteps.fillOutUserNameField(user.getUsername())
                .fillOutPasswordField(user.getPassword())
                .clickOnLoginButton();
        Assert.assertEquals(profilePage.checkingImages(), profilePage.elementsCollectionSize());
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Logging out of the standard user profile")
    @Description("Testing if the fields are empty after logging put")
    @Test(priority = 3, description = "log out to check the password and username field values")
    public void logOutTest() {
        UserModel user = dbSteps.getSpecificUserInfo(1001);
        loginPageSteps.fillOutUserNameField(user.getUsername())
                .fillOutPasswordField(user.getPassword())
                .clickOnLoginButton();
        profilePage.clickingOnASideBar()
                .clickingOnLogout();
        sfa.assertTrue(loginPageSteps.usernameFieldIsEmpty());
        sfa.assertTrue(loginPageSteps.passwordFieldIsEmpty());
    }
}
