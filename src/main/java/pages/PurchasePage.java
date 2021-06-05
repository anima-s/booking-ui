package pages;

import locators.Purchase;
import models.Customer;
import models.Payment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Wait;

public class PurchasePage extends AbstractPage{

    private Purchase purchase;
    Wait wait = null;

    public PurchasePage(final WebDriver webDriver, Purchase pageModel) {
        super(webDriver, pageModel);
        this.purchase = pageModel;
        this.wait = getWaitInstance();
    }

    public void verifyPurchasePageTitle(String title){
        wait.waitforTextToBePresent(purchase.getHeader(),title);
        Assert.assertEquals(purchase.getHeader().getText(),title);
    }

    public void verifyFlightDetails(String airline, String flightNum, float price, double fees){
        float f_price;
        double f_fees,f_totalCost,totalCost;
        f_price = Float.parseFloat(purchase.getPriceText().getText().split(":")[1].trim());
        f_fees = Double.parseDouble(purchase.getArbitraryFeesText().getText().split(":")[1].trim());
        f_totalCost = Double.parseDouble(purchase.getTotalCostText().getText().split(":")[1].trim());
        totalCost = price+fees;

        Assert.assertEquals(purchase.getAirlineText().getText().split(":")[1].trim(),airline);
        Assert.assertEquals(purchase.getFlightNumberText().getText().split(":")[1].trim(),flightNum);
        Assert.assertEquals(f_price,price);
        Assert.assertEquals(f_fees,fees);
        Assert.assertEquals(f_totalCost,totalCost);
    }


    public void purchaseFlight(Customer customer, Payment payment){
        if (customer != null && payment != null) {
            purchase.getName().sendKeys(customer.getName());
            purchase.getAddress().sendKeys(customer.getAddress());
            purchase.getCity().sendKeys(customer.getCity());
            purchase.getState().sendKeys(customer.getState());
            purchase.getZipCode().sendKeys(String.valueOf(customer.getZipcode()));
            new Select(purchase.getCardType()).selectByVisibleText(Payment.CARDTYPE.DINER.getType());
            purchase.getCreditCardNumber().sendKeys(String.valueOf(payment.getCardNumber()));
            purchase.getCreditCardMonth().sendKeys(String.valueOf(payment.getMonth()));
            purchase.getCreditCardYear().sendKeys(String.valueOf(payment.getYear()));
            purchase.getNameOnCard().sendKeys(payment.getName());
            purchase.getRememberMe().click();
        }

        purchase.getPurchaseFlightBtn().click();

    }


}
