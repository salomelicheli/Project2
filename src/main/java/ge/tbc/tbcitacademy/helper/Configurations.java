package ge.tbc.tbcitacademy.helper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.testng.ScreenShooter;
import ge.tbc.tbcitacademy.data.DataBaseSteps;
import ge.tbc.tbcitacademy.listeners.CustomTestListener;
import ge.tbc.tbcitacademy.pages.saucedemopages.ProfilePage;
import ge.tbc.tbcitacademy.steps.saucedemosteps.LoginPageSteps;
import ge.tbc.tbcitacademy.steps.saucedemosteps.ProfilePageSteps;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;
@Listeners({CustomTestListener.class, ScreenShooter.class})
public class Configurations {
    protected SoftAssert sfa;
    @BeforeClass(alwaysRun = true)
    public void AbeforeClass() {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.addArguments("start-maximized");
        Configuration.browserCapabilities = options;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        sfa = new SoftAssert();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        WebDriverRunner.getWebDriver().close();
        sfa.assertAll();
    }
}
