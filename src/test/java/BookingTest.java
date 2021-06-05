import api.BookingConfirmation;
import com.google.gson.Gson;
import locators.Confirmation;
import locators.Flights;
import locators.Home;
import locators.Purchase;
import models.Customer;
import models.Payment;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.ConfirmationPage;
import pages.FlightsPage;
import pages.HomePage;
import pages.PurchasePage;
import utils.SingletonDriver;

import java.text.SimpleDateFormat;

public class BookingTest {
    WebDriver driver = null;
    private HomePage homepage;
    private FlightsPage flightsPage;
    private PurchasePage purchasePage;
    private ConfirmationPage confirmationPage;

    @BeforeClass
    void setup(){
        driver = SingletonDriver.getInstance();
   }

   @Test
   void verifyBookingWithCorrectDetails(){
        String from="Boston",to="London";
        Customer customer = new Customer("Anima","HRBR","Bangalore","Karnataka",123456);
        Payment payment = new Payment(1234567890123456L,12,2021,"Anima Sharma");

       homepage = new HomePage(driver, new Home());
       homepage.verifyHomePageTitle("Welcome to the Simple Travel Agency!");
       homepage.selectToAndFromCities(from,to);

       flightsPage = new FlightsPage(driver, new Flights());
       flightsPage.verifyFlightsPageTitle("Flights from "+from+" to "+to+":");
       flightsPage.selectFlightByAirline("United Airlines");

       purchasePage = new PurchasePage(driver, new Purchase());
       purchasePage.verifyPurchasePageTitle("Your flight from TLV to SFO has been reserved.");
       purchasePage.verifyFlightDetails("United","UA954",400,514.76);
       purchasePage.purchaseFlight(customer,payment);

       confirmationPage = new ConfirmationPage(driver, new Confirmation());
       confirmationPage.verifyConfirmationPageTitle("Thank you for your purchase today!");
       String response = confirmationPage.getAPIResponse();
       Gson gson = new Gson();
       BookingConfirmation api_confirmation = gson.fromJson(response, BookingConfirmation.class);
       String amount = api_confirmation.getAmount() + " " +api_confirmation.getCurrency();
       String expiration = api_confirmation.getPayment().getCardExpirationMonth() + " /" + api_confirmation.getPayment().getCardExpirationYear();
       confirmationPage.verifyBookingDetails(api_confirmation.getId(),api_confirmation.getStatus(),amount,
               api_confirmation.getPayment().getCardNumber(),expiration,api_confirmation.getAuthCode(),getDate());
   }

   @Test
    void verifyBookingWithIncorrectDetails(){
        String from="Boston",to="London";
        Customer customer = new Customer("$$$$$$$","&&&&&","Bangalore","Karnataka",123456);
        Payment payment = new Payment(0L,0,0000,"");

        homepage = new HomePage(driver, new Home());
        homepage.verifyHomePageTitle("Welcome to the Simple Travel Agency!");
        homepage.selectToAndFromCities(from,to);

        flightsPage = new FlightsPage(driver, new Flights());
        flightsPage.verifyFlightsPageTitle("Flights from "+from+" to "+to+":");
        flightsPage.selectFlightByAirline("United Airlines");

        purchasePage = new PurchasePage(driver, new Purchase());
        purchasePage.verifyPurchasePageTitle("Your flight from TLV to SFO has been reserved.");
        purchasePage.verifyFlightDetails("United","UA954",400,514.76);
        purchasePage.purchaseFlight(customer,payment);

        confirmationPage = new ConfirmationPage(driver, new Confirmation());
        confirmationPage.verifyConfirmationPageTitle("Thank you for your purchase today!");
        String response = confirmationPage.getAPIResponse();
        Gson gson = new Gson();
        BookingConfirmation api_confirmation = gson.fromJson(response, BookingConfirmation.class);
        String amount = api_confirmation.getAmount() + " " +api_confirmation.getCurrency();
        String expiration = api_confirmation.getPayment().getCardExpirationMonth() + " /" + api_confirmation.getPayment().getCardExpirationYear();
        confirmationPage.verifyBookingDetails(api_confirmation.getId(),api_confirmation.getStatus(),amount,
                api_confirmation.getPayment().getCardNumber(),expiration,api_confirmation.getAuthCode(),getDate());
    }

    @Test
    void verifyBookingWithNoDetails(){
        String from="Boston",to="London";

        homepage = new HomePage(driver, new Home());
        homepage.verifyHomePageTitle("Welcome to the Simple Travel Agency!");
        homepage.selectToAndFromCities(from,to);

        flightsPage = new FlightsPage(driver, new Flights());
        flightsPage.verifyFlightsPageTitle("Flights from "+from+" to "+to+":");
        flightsPage.selectFlightByAirline("United Airlines");

        purchasePage = new PurchasePage(driver, new Purchase());
        purchasePage.verifyPurchasePageTitle("Your flight from TLV to SFO has been reserved.");
        purchasePage.verifyFlightDetails("United","UA954",400,514.76);
        purchasePage.purchaseFlight(null,null);

        confirmationPage = new ConfirmationPage(driver, new Confirmation());
        confirmationPage.verifyConfirmationPageTitle("Thank you for your purchase today!");
    }

    String getDate(){
        long millis=System.currentTimeMillis();
        java.util.Date date=new java.util.Date(millis);
        //Fri, 04 Jun 2021 16:22:35 +0000
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy");
//        SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy HH:mm:ss.SSSXXX");
        String final_date = sdf.format(date);
        return final_date;
    }

   @AfterClass
    void tearUp(){
       driver.quit();
       driver=null;
   }
}
