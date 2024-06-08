package com.sat.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


import java.lang.reflect.Method;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
// import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.sat.report.MyListener;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({MyListener.class})
public abstract class BasicTest {
    
    public static final Logger logger = LogManager.getLogger();
    public static WebDriver driver;
    // private String driverPath;

    ExtentHtmlReporter htmlReporter;
 
    public static ExtentReports extent;
    //helps to generate the logs in the test report.
    public static ExtentTest test;

    @BeforeTest
    public void startReport() {
        // initialize the HtmlReporter
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/reports/html-reports/testReport.html");
 
        //initialize ExtentReports and attach the HtmlReporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
 
 
        //configuration items to change the look and feel
        //add content, manage tests etc
        // htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Simple Automation Report");
        htmlReporter.config().setReportName("Test Report");
        // htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
    }

    @BeforeMethod
    public void preCondition(Method method) {
        // Chromedriver path
        // String driverPath = "src/main/resources/WebDrivers/chromedriver";
        // ChromeOptions options = new ChromeOptions();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        // WebDriverManager.edgedriver().setup();
        // driver = new EdgeDriver();
        // Maximize the browser
        driver.manage().window().maximize();

        String testMethodName = method.getName(); 
        // String descriptiveTestName = method.getAnnotation(Test.class).testName(); 
        test = extent.createTest(testMethodName);
    }

    @AfterTest
    public void tearDown() {
        //to write or update test information to reporter
        extent.flush();
    }

    @AfterMethod
    public void postCondition(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL,result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, result.getTestName());
        }
        else {
            test.log(Status.SKIP, result.getTestName());
        }
        
        // Quit the Browser
        driver.quit();
    }
    
}