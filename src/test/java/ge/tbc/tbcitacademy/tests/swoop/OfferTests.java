package ge.tbc.tbcitacademy.tests.swoop;

import ge.tbc.tbcitacademy.data.DefaultLocationData;
import ge.tbc.tbcitacademy.data.PricesData;
import ge.tbc.tbcitacademy.helper.Configurations;
import ge.tbc.tbcitacademy.steps.swoopwebsitesteps.*;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.tbcitacademy.data.ConstantData.SWOOP_LINK;

@Test(groups = "SwoopRegression")
@Epic("Swoop Regression Tests")
public class OfferTests extends Configurations {
    KidsCategoryPageSteps kidsCategory;
    CommonSteps commonSteps;
    HolidayPageSteps holiday;
    AuthorizationPageSteps authorize;
    KidsEnterteinmentOfferPageSteps offerSteps;
    CommonSidebarOfferPagesSteps sidebar;
    DefaultLocationData loc;
    FacebookLoginPopupSteps facebookWindow;
    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        commonSteps = new CommonSteps();
        holiday = new HolidayPageSteps();
        kidsCategory = new KidsCategoryPageSteps();
        authorize = new AuthorizationPageSteps(sfa);
        offerSteps = new KidsEnterteinmentOfferPageSteps();
        sidebar = new CommonSidebarOfferPagesSteps();
        loc = new DefaultLocationData();
        facebookWindow = new FacebookLoginPopupSteps(sfa);
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        open(SWOOP_LINK);
        commonSteps.acceptingCookies();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Testing if the price ranges are correctly included after filtering prices")
    @Description("Testing the website after filtering the prices")
    @Test(dataProvider = "priceData", dataProviderClass = PricesData.class, description =
      "This test checks if after filtering the prices the website gives the correct offers in the range", priority = 4)
    @Feature("Checking price filters")
    public void rangeTest(int minPrice, int maxPrice) {
        commonSteps.clickHolidayOptionOnMenuBar();
        sidebar.fillingInMinimumPrice(minPrice)
                .fillingInMaximumPrice(maxPrice)
                .clickingOnSearchButton();
        holiday.pageLoad()
                .surfOffersOnFirstPage()
                .forEach(x-> Assert.assertTrue(x>=minPrice && x<=maxPrice));
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Adding an offer to the favorites on swoop")
    @Description("This test determines if the favorites works correctly and displays a login page, user has to be logged in to add something in favorites!")
    @Feature("Checking adding to favorites button")
    @Test(description = "Test to find out whether adding to favorites button works well or not", priority = 2)
    public void favouriteOfferTest() {
        commonSteps.clickOnCategoriesDropdown()
                .hoverOnAnyCategory()
                .clickingOnASubcategory();
        kidsCategory.addingItemToFavorites();
        authorize.validatingThatAuthorization()
                 .validatingThatLoginPasswordFieldIsPresent()
                 .navigatingBack();
        sfa.assertTrue(kidsCategory.checkThatVouchersAreNotSoldOut());
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Share button test on offers swoop page")
    @Description("This test determines if the share button does work correctly and displays the facebook login page so user can log in to the account and share the item")
    @Feature("Checking share button")
    @Test(priority = 3, description = "This testcase checks if the share button on the offer page works correctly")
    public void shareOfferTest() {
        commonSteps.clickOnCategoriesDropdown()
                .hoverOnAnyCategory()
                .clickingOnASubcategory();
        kidsCategory.navigatingToFirstOffer();
        offerSteps.clickingOnShareButton();
        facebookWindow.switchingToPopup()
                      .validatingThatFacebookLogoAlsoAppeared()
                      .validatingThatLoginPageAppearedIndeed()
                      .goingBackToDefaultWindow();
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Test the delete filters button on swoop webpage")
    @Description("In this testcase all the filters in the sidebar menu are altered and deleted after to see how well the delete button works")
    @Feature("checking delete filter")
    @Test( priority = 1, description = "This test checks if the delete button works correctly and sets all the filters back to default")
    public void clearFilterTest() {
        commonSteps.clickOnKidsCategory();
        kidsCategory.scrollToSideBarFilters();
        sidebar.setDefaultLocation()
                .clickOnADropDown()
                .chooseGldani()
                .clickOnADropDown()
                .chooseAPaymentMethod()
                .fillingInMinimumPrice(30)
                .fillingInMaximumPrice(100)
                .clearFilters()
                .setLocationAfterClearingFilter()
                .validatingMinField()
                .validateMaxField();
        sfa.assertTrue(sidebar.validateIfDefaultCheckboxIsSelected());
        sfa.assertTrue(sidebar.getDefaultLocationBeforeFilter()
                .equalsIgnoreCase(sidebar.getLocationAfterClearingFilter()));
    }

    @Severity(SeverityLevel.MINOR)
    @Story("Progress bar testing on the website")
    @Description("Test case to check if the progress bar is displayed correctly")
    @Feature("checking the progress bar")
    @Test(priority = 5, description = "check if the progress bar shows sold items correctly")
    public void noOffersSoldTest() {
        commonSteps.clickOnKidsCategory();
        kidsCategory.findOfferWithZeroSells()
                .scrollToOfferIfFound();
        Assert.assertTrue(kidsCategory.getProgressBarValueOfZeroSoldOffer());
    }
}
