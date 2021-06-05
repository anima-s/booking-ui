package pages;

import locators.Confirmation;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.Wait;

public class ConfirmationPage extends AbstractPage{
    private Confirmation confirmation;
    Wait wait = null;

    public ConfirmationPage(final WebDriver webDriver, Confirmation pageModel) {
        super(webDriver, pageModel);
        this.confirmation = pageModel;
        this.wait = getWaitInstance();
    }

    public void verifyConfirmationPageTitle(String title){
        wait.waitforTextToBePresent(confirmation.getHeader(),title);
        Assert.assertEquals(confirmation.getHeader().getText(),title);
    }

    public void verifyBookingDetails(String id,String status,String amount,String cardnum,String expiration,String authCode,String date){
        Assert.assertEquals(confirmation.getId().getText(),id);
        Assert.assertEquals(confirmation.getStatus().getText(),status);
        Assert.assertEquals(confirmation.getAmount().getText(),amount);
        Assert.assertEquals(confirmation.getExpiration().getText(),expiration);
        Assert.assertEquals(confirmation.getCardNumber().getText(),cardnum);
        Assert.assertEquals(confirmation.getAuthCode().getText(),authCode);
        Assert.assertTrue(confirmation.getDate().getText().contains(date));
    }

    public String getAPIResponse(){
        return confirmation.getApiResponse().getText();
    }
}
