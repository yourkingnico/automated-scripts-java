package net.nicktorres.framework.core;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private static final int TIMEOUT = 5;
    private static final int POLLING = 100;
    private static final int MAX_TAB = 100;

    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, TIMEOUT, POLLING);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
    }

    protected boolean waitForElementToAppear(By locator) {
        try{
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        }catch(Error e){
            System.out.println("*** Wait for element :" + locator.toString() + " timed out . . . ");
            return false;
        }
    }

    protected boolean tabToElement(String identifier){
        for(int i=0; i<MAX_TAB; i++){
            pressTabKey(1);
            WebElement activeElement = getActiveElement();
            String dataCy = activeElement.getAttribute("data-cy");
            if(dataCy != null){
                if(dataCy.equalsIgnoreCase(identifier)){
                    pressEnterKey(getActiveElement());
                    return true;
                }
            }
        }
        return false;
    }

    protected void pressTabKey(int numberOfTimes){
        WebElement body = waitAndReturnElement(By.cssSelector("body"));
        for(int i = 0; i < numberOfTimes; i++){
            body.sendKeys(Keys.TAB);
        }
    }

    protected WebElement getActiveElement(){
        return  driver.switchTo().activeElement();
    }

    protected void pressEnterKey(WebElement element){
        element.sendKeys(Keys.ENTER);
    }

    protected WebElement waitAndReturnElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitForTextToDisappear(By locator, String text) {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBe(locator, text)));
    }
}
