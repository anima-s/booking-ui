package locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Confirmation implements PageModel {

    @FindBy(xpath = "//tbody/tr/td[text()='Id']/following-sibling::td")
    private WebElement id;

    @FindBy(xpath = "//tbody/tr/td[text()='Status']/following-sibling::td")
    private WebElement status;

    @FindBy(xpath = "//tbody/tr/td[text()='Amount']/following-sibling::td")
    private WebElement amount;

    @FindBy(xpath = "//tbody/tr/td[text()='Card Number']/following-sibling::td")
    private WebElement cardNumber;

    @FindBy(xpath = "//tbody/tr/td[text()='Expiration']/following-sibling::td")
    private WebElement expiration;

    @FindBy(xpath = "//tbody/tr/td[text()='Auth Code']/following-sibling::td")
    private WebElement authCode;

    @FindBy(xpath = "//tbody/tr/td[text()='Date']/following-sibling::td")
    private WebElement date;

    @FindBy(xpath = "//h1")
    private WebElement header;

    @FindBy(xpath = "//pre")
    private WebElement apiResponse;

    @Override
    public String getUrl() {
        return "";
    }

    public WebElement getId() {
        return id;
    }

    public WebElement getStatus() {
        return status;
    }

    public WebElement getAmount() {
        return amount;
    }

    public WebElement getCardNumber() {
        return cardNumber;
    }

    public WebElement getExpiration() {
        return expiration;
    }

    public WebElement getAuthCode() {
        return authCode;
    }

    public WebElement getDate() {
        return date;
    }

    public WebElement getApiResponse() {
        return apiResponse;
    }

    public WebElement getHeader() {
        return header;
    }
}
