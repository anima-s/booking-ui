package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Flights implements PageModel {

    @FindBy(xpath = "//h3")
    private WebElement header;

    @Override
    public String getUrl() {
        return "";
    }

    public String getChooseThisFlightBtnByIndexXpath(int index) {
        return String.format("//tbody/tr['%d']/td/input", index);
    }

    public String selectFlightByAirline(String airline){
        return String.format("//td[contains(text(),'%s')]/parent::tr/td[1]/input",airline);
    }

    public WebElement getHeader() {
        return header;
    }
}
