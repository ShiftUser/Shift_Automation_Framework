package Shift_Test;

import Utilities.Constants;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class
BaseTest {
    public static ExtentSparkReporter sparkReporter;
    public static ExtentReports extent;
    public static ExtentTest logger;
    public static WindowsDriver windowsDriver;

    public static String ReportDateAndTime;

    /*The BeforeSuite here is establishing a report and also the report is getting created by date and time stamp*/

    @BeforeSuite
    public void StartReport() {
        String dateName = new SimpleDateFormat("dd-MM-yyyy-hh_mm").format(new Date());
        ReportDateAndTime = dateName;
        sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "Shift reports" + File.separator + "Shift Reports_" + dateName + ".html");

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Browser", Constants.browser);


        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setDocumentTitle("Shift Report");
        sparkReporter.config().setReportName("Automation Test Result for Shift");
        sparkReporter.config().setTimeStampFormat("EEEE,MMMM dd, yyyy,hh:mm a'('zzz')' ");

    }


    /*The BeforeMethod here does the login functionality everytime.
    * If you want to change the login functionality you can do the modifications in Before Method
    * and you don't have to change it anywhere in the program*/
    @BeforeMethod
    public void SetDriver() throws InterruptedException {



    }



    /*The AfterMethod here writes into the extent reports on the basis of their status - pass or fail*/
    @AfterMethod
    public void getTestResult(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {

            logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "FAILED", ExtentColor.RED));
            logger.fail(result.getThrowable());


        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));

           /* Below line  is added to take screenshot when the test case is passed*/

        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.YELLOW));
            logger.skip(result.getThrowable());
        }


    }

    @AfterSuite
    public void tearDown() {
        extent.flush();
    }



}