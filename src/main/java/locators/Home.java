package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Home implements PageModel {

    @FindBy(name = "fromPort")
    private WebElement departureCity;

    @FindBy(name = "toPort")
    private WebElement destinationCity;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement findFlightsBtn;

    @FindBy(xpath = "//h1")
    private WebElement header;

    @Override
    public String getUrl() {
        return "https://blazedemo.com/";
    }

    public WebElement getDepartureCity() {
        return departureCity;
    }

    public WebElement getDestinationCity() {
        return destinationCity;
    }

    public WebElement getFindFlightsBtn() {
        return findFlightsBtn;
    }

    public WebElement getHeader() {
        return header;
    }
}
