package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindByLocators {
    WebDriver webDriver=null;
    public FindByLocators(WebDriver driver) {
        this.webDriver=driver;
    }
    public WebElement findByXpath(String xpath){
        return webDriver.findElement(By.xpath(xpath));
    }

    public WebElement findByID(String id){
        return webDriver.findElement(By.id(id));
    }
}
