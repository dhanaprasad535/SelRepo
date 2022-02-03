package tests.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class CustomListener extends BaseTest implements ITestListener{


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        if(ITestResult.FAILURE==iTestResult.getStatus()) {
            System.out.println(iTestResult.getStatus());
            System.out.println("Test case is failed so taking a screenshot");
            try {
                takeScreenshot();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(ITestResult.SUCCESS==iTestResult.getStatus()) {
            System.out.println("Test case is suceeded");

        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {

    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}

