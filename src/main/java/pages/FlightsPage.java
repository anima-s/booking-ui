package pages;

import locators.Flights;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.FindByLocators;
import utils.Wait;

public class FlightsPage extends AbstractPage{
    private Flights flights;
    Wait wait = null;
    FindByLocators findByLocators = null;

    public FlightsPage(final WebDriver webDriver, Flights pageModel) {
        super(webDriver, pageModel);
        this.flights = pageModel;
        this.findByLocators = new FindByLocators(webDriver);
        this.wait = getWaitInstance();
    }

    public void verifyFlightsPageTitle(String title){
        wait.waitforTextToBePresent(flights.getHeader(),title);
        Assert.assertEquals(flights.getHeader().getText(),title);
    }

    public void selectFlightByIndex(int index){
        findByLocators.findByXpath(flights.getChooseThisFlightBtnByIndexXpath(index)).click();
    }
    public void selectFlightByAirline(String airline){
        findByLocators.findByXpath(flights.selectFlightByAirline(airline)).click();
    }
}
