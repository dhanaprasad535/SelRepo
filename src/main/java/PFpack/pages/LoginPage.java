package PFpack.pages;

import PFpack.base.BasePage;
import PFpack.util.Constants;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class LoginPage extends BasePage {

    HomePage hp;

    public LoginPage(WebDriver driver, ExtentTest logger){
        this.driver = driver;
        this.logger = logger;
    }
    @FindBy(id="login_id")
    public WebElement emailField;

    @FindBy(id="nextbtn")
    public WebElement nextButton;

    @FindBy(id="password")
    public WebElement passwordField;

    //Reusable method for logging into the application
    public boolean doLogin() throws InterruptedException {
        emailField.sendKeys(Constants.USERNAME);
        logger.log(LogStatus.INFO, "Email address is entered");
        nextButton.click();
        sleep(5000);
        passwordField.sendKeys(Constants.PASSWORD);
        logger.log(LogStatus.INFO, "Password is entered");
        nextButton.click();
        logger.log(LogStatus.INFO, "Clicked on next button");
        hp = new HomePage(driver, logger);
        PageFactory.initElements(driver, hp);
        boolean status = hp.checkCRM();
        logger.log(LogStatus.INFO, "Status in Loginpage page is " + status);
        return status;
    }

    //Other reusable methods

}
