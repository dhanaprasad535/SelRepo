package PFpack.pages;

import PFpack.base.BasePage;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver, ExtentTest logger) {
        this.driver = driver;
        this.logger = logger;
    }

    @FindBy(xpath="//*[@id=\"block-system-main\"]/div/div[3]/section[2]/div/div/ul/li[1]/a/span[2]/label")
    public WebElement crmOption;

    @FindBy(className="zh-main-app zh-sec-apps zh-mail zapp-show")
    public WebElement malesOption;

    public boolean checkCRM() {

        return isElementPresent(crmOption);
    }

    //Reusable method to verify the presence of CRM option

    //Reusable method for navigating to CRM option

    //Reusable method for navigating to SalesIQ option

    //Reusable method for navigating to Cliq option
}
