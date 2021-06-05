package pages;

import locators.PageModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utils.Wait;

public class AbstractPage{
    private final WebDriver webDriver;
    private Wait wait;

    public AbstractPage(WebDriver webDriver, PageModel pageModel) {
        this.webDriver = webDriver;
        this.wait = Wait.getInstance(webDriver);
        navigateToPage(pageModel);
        initPage(webDriver, pageModel);
    }

    protected void initPage(WebDriver webDriver, PageModel pageModel) {
        System.out.println("Initializing elements on page: " + pageModel.getUrl());
        PageFactory.initElements(webDriver, pageModel);
    }

    protected void navigateToPage(PageModel pageModel) {
        System.out.println("Navigating to: " + pageModel.getUrl());
        if(pageModel.getUrl() !=null && pageModel.getUrl().length() > 0) webDriver.navigate().to(pageModel.getUrl());
    }

    protected WebDriver getWebDriver(){
        return this.webDriver;
    }

    protected Wait getWaitInstance(){return this.wait; }

}
