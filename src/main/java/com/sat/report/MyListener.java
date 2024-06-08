package com.sat.report;
 
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
// import sun.misc.BASE64Decoder;
import com.sat.utils.BasicTest;
 
 
 
public class MyListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {
    }
 
    public void onTestSuccess(ITestResult iTestResult) {
        BasicTest.test.log(Status.PASS,MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" PASS",ExtentColor.GREEN));
        reportPrint();
    }
 
    public void onTestFailure(ITestResult iTestResult) {
        BasicTest.test.log(Status.FAIL,iTestResult.getThrowable().getMessage());
        BasicTest.test.log(Status.FAIL,MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" FAIL",ExtentColor.RED));
        reportPrint();
    }
 
    public void onTestSkipped(ITestResult iTestResult) {
        BasicTest.test.log(Status.SKIP,MarkupHelper.createLabel(iTestResult.getName().toUpperCase()+" SKIPPED",ExtentColor.PURPLE));
 
    }
 
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
 
    }
 
    public void onStart(ITestContext iTestContext) {
 
    }
 
    public void onFinish(ITestContext iTestContext) {
        
    }

    private void reportPrint() {
        BasicTest.test.addScreenCaptureFromBase64String(takeScreenshot());
    }

    private String takeScreenshot() {
        return ((TakesScreenshot) BasicTest.driver).getScreenshotAs(OutputType.BASE64);
    }
 
 
}