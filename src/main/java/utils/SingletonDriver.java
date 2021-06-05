package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
    static WebDriver driver;

    public static WebDriver getInstance(){

        if(driver == null){
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

        return driver;
    }
}
