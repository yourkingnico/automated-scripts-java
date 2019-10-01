package net.nicktorres.tests.homepage;

import net.nicktorres.framework.core.BaseTest;
import net.nicktorres.objects.homepage.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {
    @Test
    public void homepageTests() {

        getDriver().navigate().to("http://localhost:8000");

        HomePage Homepage = new HomePage(getDriver());
        Assert.assertEquals(Homepage.isJumboDisplayed(), true, "*** Jumbo component is not visible");

        Assert.assertEquals(Homepage.isNavBarDisplayed(), true, "*** Navigation component is not visible");

        Homepage.goToAbout();
        Assert.assertEquals(Homepage.isAboutMeVisible(), true, "*** About component is not visible");

        Homepage.goToContact();
        Assert.assertEquals(Homepage.isContactVisible(), true, "*** Contact component is not visible");

        Assert.assertEquals(Homepage.isFooterDisplayed(), true, "*** Footer component is not visible");

    }
}
