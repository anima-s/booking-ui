package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Purchase implements PageModel {

    @FindBy(xpath = "//p[contains(text(),'Airline:')]")
    private WebElement airlineText;

    @FindBy(xpath = "//p[contains(text(),'Flight Number:')]")
    private WebElement flightNumberText;

    @FindBy(xpath = "//p[contains(text(),'Price:')]")
    private WebElement priceText;

    @FindBy(xpath = "//p[contains(text(),'Arbitrary Fees and Taxes:')]")
    private WebElement arbitraryFeesText;

    @FindBy(xpath = "//p[contains(text(),'Total Cost:')]")
    private WebElement totalCostText;

    @FindBy(id = "inputName")
    private WebElement name;

    @FindBy(id = "address")
    private WebElement address;

    @FindBy(id = "city")
    private WebElement city;

    @FindBy(id = "state")
    private WebElement state;

    @FindBy(id = "zipCode")
    private WebElement zipCode;

    @FindBy(id = "creditCardYear")
    private WebElement creditCardYear;

    @FindBy(id = "creditCardMonth")
    private WebElement creditCardMonth;

    @FindBy(id = "creditCardNumber")
    private WebElement creditCardNumber;

    @FindBy(id = "cardType")
    private WebElement cardType;

    @FindBy(id = "nameOnCard")
    private WebElement nameOnCard;

    @FindBy(id = "rememberMe")
    private WebElement rememberMe;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    private WebElement purchaseFlightBtn;

    @FindBy(xpath = "//h2")
    private WebElement header;

    @Override
    public String getUrl() {
        return "";
    }

    public WebElement getHeader() {
        return header;
    }

    public WebElement getAirlineText() {
        return airlineText;
    }

    public WebElement getFlightNumberText() {
        return flightNumberText;
    }

    public WebElement getPriceText() {
        return priceText;
    }

    public WebElement getArbitraryFeesText() {
        return arbitraryFeesText;
    }

    public WebElement getTotalCostText() {
        return totalCostText;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getAddress() {
        return address;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getZipCode() {
        return zipCode;
    }

    public WebElement getCreditCardYear() {
        return creditCardYear;
    }

    public WebElement getCreditCardMonth() {
        return creditCardMonth;
    }

    public WebElement getCreditCardNumber() {
        return creditCardNumber;
    }

    public WebElement getCardType() {
        return cardType;
    }

    public WebElement getNameOnCard() {
        return nameOnCard;
    }

    public WebElement getRememberMe() {
        return rememberMe;
    }

    public WebElement getPurchaseFlightBtn() {
        return purchaseFlightBtn;
    }
}
