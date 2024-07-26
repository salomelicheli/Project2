package ge.tbc.tbcitacademy.steps.saucedemosteps;

import com.codeborne.selenide.Condition;
import ge.tbc.tbcitacademy.pages.saucedemopages.LoginPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.value;

public class LoginPageSteps {

    LoginPage login = new LoginPage();

    @Step("This step fills up a username field with a following username: {0}")
    public LoginPageSteps fillOutUserNameField(String username){
        login.userNameField.sendKeys(username);
        return this;
    }

    @Step("This step fills up a password field with a following password: {0}")
    public LoginPageSteps fillOutPasswordField(String password){
        login.passwordField.sendKeys(password);
        return this;
    }

    @Step("This step clicks on a login button to access the user profile")
    public LoginPageSteps clickOnLoginButton() {
        login.loginButton.click();
        return this;
    }

    @Step("This step returns a boolean to assert if the username field is empty")
    public boolean usernameFieldIsEmpty(){
        return login.userNameField.getValue().equals("");
    }

    @Step("This step returns a boolean to assert if the password field is empty")
    public boolean passwordFieldIsEmpty(){
        return login.passwordField.getValue().equals("");
    }

    @Step("This step checks the error message")
    public String errorMessage(){
        return login.errorElement.getText();
    }

    @Step("This step validates that X error icon appears when logging in with problematic user")
    public void validateThatXiconsareVisible(){
        login.errorXes.forEach(x->x.should(Condition.appear));
    }

}
