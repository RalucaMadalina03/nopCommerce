package Tests;

import ObjectData.HomepageObj;
import Pages.HomePage;
import ShareData.Hooks;
import org.testng.annotations.Test;

public class HomePageTest extends Hooks {
    @Test
    public void testMethod(){

        HomepageObj homepageObj = new HomepageObj(testData);

        HomePage homePage = new HomePage(getDriver());
        homePage.validateHomePage(homepageObj);
    }
}
