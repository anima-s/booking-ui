package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Wait extends WebDriverWait{
    private static Wait wait;

    public Wait(WebDriver driver, long timeOutInSeconds) {
        super(driver, timeOutInSeconds);
    }

    public static Wait getInstance(WebDriver driver) {
        if(wait ==null){
            wait = new Wait(driver, 5000);
        }
        return wait;
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitforTextToBePresent(WebElement element,String text){
        wait.until(ExpectedConditions.textToBePresentInElement(element,text));
    }

}
