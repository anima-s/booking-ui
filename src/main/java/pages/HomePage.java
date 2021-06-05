package pages;

import locators.Home;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Wait;

public class HomePage extends AbstractPage{

    private Home home;
    Wait wait = null;

    public HomePage(final WebDriver webDriver, Home pageModel) {
        super(webDriver, pageModel);
        this.home = pageModel;
        this.wait = getWaitInstance();
    }

    public void verifyHomePageTitle(String title){
        wait.waitforTextToBePresent(home.getHeader(),title);
        Assert.assertEquals(home.getHeader().getText(),title);
    }

    public void selectToAndFromCities(String from, String to){
        Select fromLoc = new Select(home.getDepartureCity());
        Select toLoc = new Select(home.getDestinationCity());
        fromLoc.selectByValue(from);
        Assert.assertEquals(fromLoc.getFirstSelectedOption().getText(),from);

        toLoc.selectByValue(to);
        Assert.assertEquals(toLoc.getFirstSelectedOption().getText(),to);

        wait.waitForElementToBeClickable(home.getFindFlightsBtn());
        home.getFindFlightsBtn().click();
    }

}
