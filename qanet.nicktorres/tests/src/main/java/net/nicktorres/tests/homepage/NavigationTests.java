package net.nicktorres.tests.homepage;

import net.nicktorres.framework.core.BaseTest;
import net.nicktorres.objects.homepage.Navigation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationTests extends BaseTest{
    @Test
    public void navigationTests() {

        getDriver().navigate().to("http://localhost:8000");
        Navigation nav = new Navigation(getDriver());

        nav.tabToAbout();
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8000/#about", "*** navigation to About failed.");

        nav.tabToContact();
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8000/#contact", "*** navigation to Contact failed.");

        nav.tabToPastWorks();
        // TODO: wait for page to load and then assert
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8000/pastWorks/", "*** navigation to PastWorks failed.");

        nav.tabToResume();
        // TODO: wait for page to load and then assert
        Assert.assertEquals(getDriver().getCurrentUrl(), "http://localhost:8000/resume/", "*** navigation to Resume failed.");

    }
}
