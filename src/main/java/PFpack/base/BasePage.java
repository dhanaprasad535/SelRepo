package PFpack.base;

import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    public WebDriver driver;
    public ExtentTest logger;


    public boolean isElementPresent(WebElement element) {
        boolean displayedStatus = element.isDisplayed();
        System.out.print("Status in base page is " + displayedStatus);
        return displayedStatus;
    }


}
