package tests;

import PFpack.pages.LaunchPage;
import PFpack.util.Constants;
import org.openqa.selenium.WebDriver;
import tests.base.CustomListener;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;

import java.io.IOException;

@Listeners(CustomListener.class)
public class LoginTest extends BaseTest {

    LaunchPage lp;

    @Test
    public void testLogin() throws IOException, InterruptedException {
        logger = er.startTest("Start Test");
        logger.log(LogStatus.INFO, "Login test has started");
        openBrowser(Constants.BROWSER_TYPE);
        lp = new LaunchPage(driver, logger);
        // Initialize the elements in the Launch page
        PageFactory.initElements(driver, lp);
        boolean status = lp.goToLoginPage();
        if(status) {
            // Pass the test case
            reportPass("Login test is passed");
        } else {
            // Fail the test case
            takeScreenshot();
            reportFail("Login test is failed");
        }

    }

    @AfterMethod
    // Hi
    public void testClosure() {
        if(er!=null) {
            er.endTest(logger);
            er.flush();
        }
        if(driver!=null) {
            driver.quit();
        }
    }
}
