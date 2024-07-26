package ge.tbc.tbcitacademy.steps.saucedemosteps;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.tbcitacademy.pages.saucedemopages.ProfilePage;
import io.qameta.allure.Step;

import java.util.HashSet;
import java.util.Set;

public class ProfilePageSteps {
    ProfilePage profile=  new ProfilePage();

    @Step("Clicking on a sidebar to reach the logout button")
    public ProfilePageSteps clickingOnASideBar(){
        profile.menuButton.click();
        return this;
    }

    @Step("Clicking on a logout button")
    public void clickingOnLogout(){
        profile.logoutButton.click();
    }

    @Step("This step loads the src attribute values in a set")
    public int checkingImages(){
        Set<String> srcSet = new HashSet<>(); loadSet(srcSet);
        return srcSet.size();
    }

    @Step("This step returns elementscollection size")
    public int elementsCollectionSize(){
        return profile.imageElements.size();
    }

    @Step("This step is meant to break down another step and its only meant for this class")
    private void loadSet(Set<String> st){
        for(SelenideElement el : profile.imageElements){
            st.add(el.getAttribute("src"));
        }
    }
}
