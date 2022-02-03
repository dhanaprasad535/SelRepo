package PFpack.util;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;
import java.util.Date;

public class ExtentManager {

    public static ExtentReports extent() {
        Date da = new Date();
        String sda = da.toString();
        sda = sda.replace(" ","_").replace(":", "_");

        ExtentReports er = new ExtentReports( sda + ".html");
        er.addSystemInfo("Host Name", "Dhanahost").addSystemInfo("Environment", "Myenv");
        File file = new File("ReportConfig.xml");
        er.loadConfig(file);
        return er;
    }
}
