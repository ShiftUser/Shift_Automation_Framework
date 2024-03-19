package Shift;

import Utilities.Constants;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;


public class Shift_Browser_TestCase extends BaseTest
{
    SoftAssert softAssert = new SoftAssert(); //This is a global declaration
    @Test(priority = 1)
    public void Opening_Chrome_Browser_and_visitingShiftUR2L(Method testMethod) throws InterruptedException {
        try {
            logger = extent.createTest(testMethod.getName());
            logger.assignCategory("Test 1");
            logger.assignAuthor("Shift");

            logger.log(Status.INFO, "Launching" +
                    " Chrome Browser");
            WebDriverManager.chromedriver().setup();
            WebDriver driver =  new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            logger.log(Status.INFO, "Entering Shift url");
            driver.get(Constants.urls); //accessing the
            // url
            logger.log(Status.INFO, "Verifying the url");
            if (driver.getCurrentUrl().contains("shift")) {
                System.out.println("url is correct");
                logger.log(Status.INFO, "url is correct");
                softAssert.assertTrue(true);
            } else {
                logger.log(Status.INFO, "Incorrect Shift url");

                System.out.println("Pop up msg is Wrong. Please verify  url ");
                softAssert.assertFalse(true, "Pop up msg is Wrong. Please verify url ");
            }
            softAssert.assertAll();
            logger.log(Status.INFO, "Downloading shift windows application");
            driver.findElement(By.xpath("//h1[text()='Your power browser']/following-sibling::a")).click();
        } catch (Exception e) {
            System.out.println("TimeOut Error: " + e.getMessage());

        }
    }
    @Test(priority = 2)
    public void Downloading_Shift(Method testMethod) throws InterruptedException {
        try {
            logger = extent.createTest(testMethod.getName());
            logger.assignCategory("Test 1");
            logger.log(Status.INFO, "Opening Downloads");
            Thread.sleep(8000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_J);
            robot.keyRelease(KeyEvent.VK_J);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            for (int i = 0; i < 4; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            }

            logger.log(Status.INFO, "Visiting to Download file");
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            logger.log(Status.INFO, "Closing the alert window and downloading Shift");
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10000);

        } catch (Exception e) {
            System.out.println("TimeOut Error: " + e.getMessage());

        }

    }
    @Test(priority = 3)
    public void Verifying_Shift_Download_Filename(Method testMethod) {
        try {
            logger = extent.createTest(testMethod.getName());
            logger.assignCategory("Test 1");

            logger.log(Status.INFO, "Visiting to Download folder in local system/drive");
            String filePath = Constants.fileDownloadPath;
            File downloadFolder = new File(filePath);
            if (downloadFolder.exists() && downloadFolder.isDirectory()) {
                // List files in the download folder
                File[] files = downloadFolder.listFiles();

                logger.log(Status.INFO, "Checking for files in the download folder");
                // Check if there are any files in the download folder
                if (files != null && files.length > 0)
                {

                    // Iterate through the files to find the latest downloaded file
                    logger.log(Status.INFO, "Comparing the first file (last modified) with other files last modified");
                    File latestFile = files[0];
                             for (File file : files)
                                  {
                                         if (file.isFile() && file.lastModified() > latestFile.lastModified())
                                            {
                                                 latestFile = file;
                                            }
                                  }
                    logger.log(Status.INFO, "Fetching the latest downloaded file name");
                    // Get the file name of the latest downloaded file
                    String fileName = latestFile.getName();

                    logger.log(Status.INFO, "Displaying the latest downloaded file name");
                    System.out.println("Latest downloaded file name: " + fileName);
                    logger.log(Status.INFO, "Latest downloaded file name: " + fileName);
                }
                else
                    {
                         System.out.println("File not found");
                         logger.log(Status.FAIL, "File not found");
                    }
            }
            else
                {
                System.out.println("Download folder does not exist or is not a directory.");
                logger.log(Status.FAIL, "Download folder does not exist or is not a directory.");
                 }
        }
        catch (Exception e)
        {
            System.out.println("Error verifying the download: " + e.getMessage());

        }

    }
    @Test(priority = 4)
    public void Installing_Shift_Browser(Method testMethod) throws InterruptedException {

        //If the test case fails uninstall delete all the files related to shift also go to run and delete temp files from there - then it will work
        logger = extent.createTest(testMethod.getName());
        logger.assignCategory("Test 2");

        logger.log(Status.INFO, "Visiting to Chrome downloads");
        try {
            Robot robot = new Robot();
            logger.log(Status.INFO, "Clicking on the exe file to install Shift");
            for (int i = 0; i < 10; i++) {
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
                Thread.sleep(1000);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            logger.log(Status.INFO, "Clicking on Next Buttons to Install Shift");
            Thread.sleep(10000);
            for (int i = 0; i < 3; i++) {
                Thread.sleep(2000); // Wait for 2 seconds
                robot.keyPress(KeyEvent.VK_ENTER);
                robot.keyRelease(KeyEvent.VK_ENTER);
            }

            Thread.sleep(20000); // Wait for 20 seconds to install the application


            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(12000);

            logger.log(Status.INFO, "Installation Successful");
            logger.log(Status.INFO, "Closing the Shift application");
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(10000);
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            Thread.sleep(5000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }




}








