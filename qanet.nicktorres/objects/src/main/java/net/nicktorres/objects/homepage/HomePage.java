package net.nicktorres.objects.homepage;


import net.nicktorres.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    private WebElement AboutLink;
    private WebElement ContactLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isNavBarDisplayed(){
        return waitForElementToAppear(By.cssSelector(".navbar-custom"));
    }

    public boolean isJumboDisplayed(){
        return waitForElementToAppear(By.cssSelector("[data-cy='jumbo-component']"));
    }

    public boolean isFooterDisplayed(){
        return waitForElementToAppear(By.cssSelector(".footer"));
    }

    public void goToAbout(){
        AboutLink = waitAndReturnElement(By.cssSelector("[data-cy=about-link]"));
        AboutLink.click();
    }

    public void goToContact(){
        try{
            ContactLink = waitAndReturnElement(By.cssSelector("[data-cy=about-link]"));
            ContactLink.click();
        }catch (Error e){
            System.out.println("*** Failed to locate and click contact link" + e.toString());
        }
    }

    public boolean isContactVisible(){
        return waitForElementToAppear(By.cssSelector("[data-cy='contact-component']"));
    }

    public boolean isAboutMeVisible(){
        return waitForElementToAppear(By.cssSelector("[data-cy='about-component']"));
    }
}
