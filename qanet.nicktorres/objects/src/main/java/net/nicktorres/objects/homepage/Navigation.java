package net.nicktorres.objects.homepage;

import net.nicktorres.framework.core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Navigation extends BasePage {
    private WebElement AboutLink;
    private WebElement ContactLink;
    private int MAX_TAB_COUNT = 100;


    public Navigation (WebDriver driver) {
        super(driver);
    }

    public boolean isNavBarLoaded(){
        return waitForElementToAppear(By.cssSelector(".navbar-custom"));
    }

    public void goToAbout(){
        AboutLink = waitAndReturnElement(By.cssSelector("[data-cy=about-link]"));
        AboutLink.click();
    }

    public void tabToAbout(){
        boolean isFound = tabToElement("about-link");
        if(!isFound){
            System.out.println("Failed to tab to about link");
        }
    }

    public void tabToContact(){
        boolean isFound = tabToElement("contact-link");
        if(!isFound){
            System.out.println("Failed to tab to contact link");
        }
    }

    public void tabToResume(){
        boolean isFound = tabToElement("resume-link");
        if(!isFound){
            System.out.println("Failed to tab to contact link");
        }
    }

    public void tabToPastWorks() {
        boolean isFound = tabToElement("past-works-link");
        if(!isFound){
            System.out.println("*********** Failed to tab to contact link");
        }
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
