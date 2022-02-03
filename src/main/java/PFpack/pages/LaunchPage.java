package PFpack.pages;

import PFpack.base.BasePage;
import PFpack.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LaunchPage extends BasePage {

    LoginPage lop;

    @FindBy(className = "login")
    public WebElement signin;

    @FindBy(className = "signUp")
    public WebElement signup;

    public LaunchPage(WebDriver driver, ExtentTest logger) {

        this.driver = driver;
        this.logger = logger;

    }

    public boolean goToLoginPage() throws InterruptedException {
        driver.get(Constants.APP_URL);
        System.out.println(driver);
        logger.log(LogStatus.INFO, "Application URL "+ Constants.APP_URL + " is opened");
        signin.click();
        logger.log(LogStatus.INFO, "Clicked on Signin link");
        lop = new LoginPage(driver, logger);
        PageFactory.initElements(driver, lop);
        boolean status = lop.doLogin();
        logger.log(LogStatus.INFO, "Status in Launch page is " + status);
        return status;
    }
}
