package tests.base;


import PFpack.util.Constants;
import PFpack.util.ExtentManager;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest  {

    public static WebDriver driver;

    public static ExtentReports er = ExtentManager.extent();
    public static ExtentTest logger = null;

    public void openBrowser(String browsertype) {
        logger.log(LogStatus.INFO, "Opening the browser" + browsertype);

//        driver = null;
        if(browsertype.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions= new ChromeOptions();
            chromeOptions.setBinary(Constants.CHROME_DRIVER_EXE);
            System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_EXE);
            driver = new ChromeDriver();
        }
        else if (browsertype.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", Constants.FIREFOX_DRIVER_EXE);
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    public void reportPass(String message) {
        logger.log(LogStatus.PASS, message);
    }

    public void reportFail(String message) {
        logger.log(LogStatus.FAIL, message);
        Assert.fail(message);
    }

    public void takeScreenshot() throws IOException {
        Date d = new Date();
        String Screetshotfile = d.toString().replace(" ", "_").replace(":", "_");
        System.out.println(driver);
        TakesScreenshot ss = (TakesScreenshot)driver;
        File src = ss.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("Screenshots/" + Screetshotfile + ".jpg"));
        logger.log(LogStatus.FAIL, logger.addScreenCapture("Screenshots/" + Screetshotfile + ".jpg") );
    }
}
