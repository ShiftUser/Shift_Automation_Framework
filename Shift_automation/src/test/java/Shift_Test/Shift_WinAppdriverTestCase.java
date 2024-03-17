package Shift_Test;

import Utilities.Constants;
import Utilities.WinDriver;
import com.aventstack.extentreports.Status;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.ui.context.Theme;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

public class Shift_WinAppdriverTestCase extends BaseTest
{
    SoftAssert softAssert = new SoftAssert(); //This is a global declaration
    @Test(priority = 1)
    public void Verifying_Shift_Version(Method testMethod) throws InterruptedException {

        logger = extent.createTest(testMethod.getName());
        logger.assignCategory("Test 2");
        logger.assignCategory("Test 3");
        logger.assignAuthor("Shift");
        try {
            Thread.sleep(5000);
            logger.log(Status.INFO, "Launching Shift Application");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("app", Constants.shiftApplicationPath);
            cap.setCapability("platformName", "Windows");
            cap.setCapability("deviceName", "WindowsPC");
            WinDriver.start();
            Thread.sleep(8000);
            try {
                // Create a new WindowsDriver instance
                windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
                Thread.sleep(10000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            logger.log(Status.INFO, "Launching WinAppdriver");
            Thread.sleep(5000);
            /* windowsDriver.findElement(By.xpath("//Pane[@ClassName='#32769'][@Name='Desktop 1']//Pane[@ClassName='Chrome_WidgetWin_1'][@Name='Gmail - Shift']//Document[@ClassName='Chrome_RenderWidgetHostHWND'][@Name='Shift']")).click();*/
            logger.log(Status.INFO, "Clicking on Privacy Policy Checkbox");
           WebElement clickCheckBox= windowsDriver.findElement(By.xpath("//CheckBox[starts-with(@Name,'Privacy Policy and Terms of Use I agree to the terms and conditi')][@AutomationId='checkbox-accept-terms-checkbox']"));
            //WebElement clickCheckBox = windowsDriver.findElementByName("Privacy Policy and Terms of Use I agree to the terms and conditions of this Privacy Policy , Terms of Use , EULA and to receive email communications.");
            Actions actions = new Actions(windowsDriver);
            actions.click(clickCheckBox).perform();
            // windowsDriver.findElementByName("Privacy Policy and Terms of Use I agree to the terms and conditions of this Privacy Policy , Terms of Use , EULA and to receive email communications.").click();
            Thread.sleep(2000);
            logger.log(Status.INFO, "Clicking on Sign in with Google");
            windowsDriver.findElementByName("Sign in with Google").click();
            Thread.sleep(8000);
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            logger.log(Status.INFO, "Providing Email in the Email textBox");
            windowsDriver.findElementByName("Email or phone").clear();
            Thread.sleep(3000);
            windowsDriver.findElementByName("Email or phone").click();
            Thread.sleep(3000);
            windowsDriver.findElementByName("Email or phone").sendKeys("Forworkfsb@gmail.com");
            Thread.sleep(3000);
            logger.log(Status.INFO, "Clicking on Next ");
            //windowsDriver.findElementByName("Next").click();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            logger.log(Status.INFO, "Providing Password");
            windowsDriver.findElementByName("Enter your password").sendKeys("Fa0880251125!");
            Thread.sleep(2000);
            logger.log(Status.INFO, "Clicking on Next ");
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            logger.log(Status.INFO, "Clicking on Continue and Allow Button");
           // windowsDriver.findElementByName("Continue").click();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            windowsDriver.findElementByName("Allow").click();
            Thread.sleep(12000);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_COMMA);
            robot.keyRelease(KeyEvent.VK_COMMA);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(3000);
            windowsDriver.findElementByName("9.2.5.1070").getText();
            if (windowsDriver.getPageSource().contains("9.2.5.1070")) {
                logger.log(Status.INFO, " Version is Matching");
                System.out.println("Version is Correct");
                softAssert.assertTrue(true);
            } else {
                logger.log(Status.INFO, "Version is not matching");
                System.out.println("version doesn't match");
                softAssert.assertFalse(true);
            }
            softAssert.assertAll();
            logger.log(Status.INFO, "Closing the Shift Application");
            windowsDriver.quit();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            /* windowsDriver.findElement(By.xpath("//Document[@ClassName='Chrome_RenderWidgetHostHWND'][@Name='Shift']/Group/Group[@AutomationId='app']/Group/Group/Group/Button/Image")).isDisplayed();
             */

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test(priority = 2)
    public void Verifyinglogin_UnreadEmails(Method testMethod) throws InterruptedException {

        logger = extent.createTest(testMethod.getName());
        logger.assignCategory("Test 3");
        logger.assignAuthor("Shift");

        try {
            Thread.sleep(7000);
            logger.log(Status.INFO, "Launching Shift Application");
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("app", Constants.shiftApplicationPath);
            cap.setCapability("platformName", "Windows");
            cap.setCapability("deviceName", "WindowsPC");
            WinDriver.start();
            Thread.sleep(8000);
            try {
                // Create a new WindowsDriver instance
                windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
                Thread.sleep(10000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Thread.sleep(5000);
            Robot robot  = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            // Wait for the context menu to appear and select an option (e.g., by pressing tab)
            Thread.sleep(2000);

            //This send Gmail.com to the search bar
            robot.keyPress(KeyEvent.VK_G);
            robot.keyRelease(KeyEvent.VK_G);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            robot.keyPress(KeyEvent.VK_A);
            robot.keyRelease(KeyEvent.VK_A);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyRelease(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyPress(KeyEvent.VK_PERIOD);
            robot.keyRelease(KeyEvent.VK_PERIOD);
            robot.keyPress(KeyEvent.VK_C);
            robot.keyRelease(KeyEvent.VK_C);
            robot.keyPress(KeyEvent.VK_O);
            robot.keyRelease(KeyEvent.VK_O);
            robot.keyPress(KeyEvent.VK_M);
            robot.keyRelease(KeyEvent.VK_M);
            Thread.sleep(2000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            logger.log(Status.INFO, "Checking for element such as Search mail/ Gmail Main Menu");
            WebDriverWait wait = new WebDriverWait(windowsDriver, 30);
            WebElement ElementNew = wait.until(ExpectedConditions.elementToBeClickable(By.name("Main menu")));
            ElementNew.click();


            //For checking successfully logging
            if(windowsDriver.findElementByName("Search mail").isDisplayed() || windowsDriver.findElementByName("Primary").isDisplayed() || windowsDriver.findElementByName("Main menu").isDisplayed())
            {
                System.out.println("Login is successfull");
                logger.log(Status.INFO, "Login Successful");
                softAssert.assertTrue(true);
            }
            else {
                System.out.println("Login failed - Unable to login");
                logger.log(Status.INFO, "Login Verification Failed");
                softAssert.assertFalse(true);
            }
            softAssert.assertAll();
            //Fetching Unread msg
            windowsDriver.findElementByName("Main menu").click();
            Thread.sleep(1000);

            logger.log(Status.INFO, "Clicking On Inbox");
            windowsDriver.findElementByName("Inbox").click();
            logger.log(Status.INFO, "Fetching Unread Gmail Msgs");
            WebElement googleElement = windowsDriver.switchTo().activeElement();
            String inboxText = googleElement.getText(); //Getting all the text from the Inbox element
            String unreadCount = inboxText.replaceAll("[^0-9]", ""); //Extracting number from the entire text
            String ExtractingUnreadmail = unreadCount.replaceAll("[^0-9]", "").substring(0, 1); //Extracting only the first value as it displays the number of Unread msgs
            System.out.println("Unread Msg Gmail : " + ExtractingUnreadmail);
            logger.log(Status.INFO,"Unread Msg Gmail : "+ExtractingUnreadmail);
            Thread.sleep(3000);



        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    @Test(priority = 3)
    public void Workspace2_LoggingIn_UnreadEmails(Method testMethod) throws InterruptedException {

        logger = extent.createTest(testMethod.getName());
        logger.assignCategory("Test 4");
        logger.assignAuthor("Shift");

        try {

            logger.log(Status.INFO,"Clicking on Add Icon");
            windowsDriver.findElement(By.xpath("//Button[@Name='Add to Shift']")).click();
            Thread.sleep(1000);
            logger.log(Status.INFO,"Clicking on Add Workspace");
            windowsDriver.findElementByName("Add Workspace").click();
            Thread.sleep(1000);
            logger.log(Status.INFO,"Entering 2nd account for Email workspace");
            windowsDriver.findElement(By.xpath("//Edit[@Name='Email for your Workspace Skip'][@AutomationId='email']")).click();
            Thread.sleep(1000);
            windowsDriver.findElement(By.xpath("//Edit[@Name='Email for your Workspace Skip'][@AutomationId='email']")).sendKeys("Forwork007@hotmail.com");
            Thread.sleep(1000);
            logger.log(Status.INFO,"Clicking on Create Workspace");
            windowsDriver.findElementByName("Create Workspace").click();
            Thread.sleep(15000);
            logger.log(Status.INFO,"Directly clicking on Next as the email is already mentioned in the Email Textbox");
            windowsDriver.findElementByName("Next").click();
            Thread.sleep(3000);
            windowsDriver.findElementByName("Password").click();
            Thread.sleep(1000);
            logger.log(Status.INFO,"Providing Password");
            windowsDriver.findElementByName("Password").sendKeys("Fa0880251125!");
            Thread.sleep(3000);
Robot robot= new Robot();
            for (int i= 0; i< 2; i++)
    {
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
    }
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(15000);
            logger.log(Status.INFO,"Clicking on Sign In");
            logger.log(Status.INFO,"Searching for the 5 demo emails in the Search box");
            windowsDriver.findElementByName("Search for email, meetings, files and more.").click();
            windowsDriver.findElementByName("Search for email, meetings, files and more.").sendKeys("Supattra Boonchalee");
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(4000);
            logger.log(Status.INFO,"Reading 2 emails");
            for (int i = 0; i < 2; i++) {
             robot.keyPress(KeyEvent.VK_DOWN);
             robot.keyRelease(KeyEvent.VK_DOWN);
            Thread.sleep(3000);
}
            Thread.sleep(1000);
            logger.log(Status.INFO,"Clicking on Unread to verify the emails");
            windowsDriver.findElementByName("Unread").click();
            Thread.sleep(2000);
            logger.log(Status.INFO,"Extracting Inbox status");
            WebElement inboxElement = windowsDriver.findElementByName("Inbox");
            Actions actions = new Actions(windowsDriver);
            actions.contextClick(inboxElement).build().perform();

    // Press the right arrow key

            robot.keyPress(KeyEvent.VK_RIGHT);
            robot.keyRelease(KeyEvent.VK_RIGHT);
    // Wait for the context menu to appear and select an option (e.g., by pressing tab)
            Thread.sleep(2000);
    WebElement selectedElement = windowsDriver.switchTo().activeElement();
    String selectedText = selectedElement.getText();
            System.out.println("Inbox Status for Outlook" + selectedText);
            logger.log(Status.INFO,"Inbox Status for Outlook :"+selectedText);
            Thread.sleep(3000);
            windowsDriver.findElementByName("Unread").click();
            logger.log(Status.INFO, "Closing the Shift Application");
            windowsDriver.quit();

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            WinDriver.stop();
        } catch (Exception e) {
            e.printStackTrace();


        }



    }



    @Test(priority = 4)
    public void Adding_New_Messenger_Application(Method testMethod) throws InterruptedException {
        logger = extent.createTest(testMethod.getName());
        logger.assignCategory("Test 5");
        logger.assignAuthor("Shift");

        try {
            Thread.sleep(10000);
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("app", Constants.shiftApplicationPath);
            cap.setCapability("platformName", "Windows");
            cap.setCapability("deviceName", "WindowsPC");
            WinDriver.start();
            Thread.sleep(3000);
            try {
                // Create a new WindowsDriver instance
                windowsDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), cap);
                //Thread.sleep(8000);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            Thread.sleep(10000);
            logger.log(Status.INFO,"Click on add to shift button at the bottom left ");
            windowsDriver.findElement(By.xpath("//Button[@AutomationId='sidebar-flyout-add'][@Name='Add to Shift']")).click();
            Thread.sleep(1000);
            logger.log(Status.INFO,"Click on Add Application button");
            windowsDriver.findElementByName("Add Application").click();
            Thread.sleep(5000);
            windowsDriver.findElementByName("All").click();
            Thread.sleep(3000);
            Actions actions = new Actions(windowsDriver);
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys("Messenger").perform();
            Thread.sleep(8000);
            windowsDriver.findElementByName("Messenger").click();
            Thread.sleep(5000);
            windowsDriver.findElement(By.xpath("//Edit[@AutomationId='name'][@Name='Account name']")).sendKeys("Test_Messenger");
            Thread.sleep(1000);
            windowsDriver.findElementByName("Save").click();
            Thread.sleep(8000);

            actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).perform();
            actions.sendKeys("forworkfsb@gmail.com").perform();

            // windowsDriver.findElement(By.xpath("//Edit[@AutomationId='email'][@Name='Email or phone number']")).sendKeys("forworkfsb@gmail.com");
            Thread.sleep(1000);
            windowsDriver.findElementByName("Password").click();
            Thread.sleep(1000);
            windowsDriver.findElementByName("Password").sendKeys("Fa123456789");
            Thread.sleep(2000);
            Robot robot = new Robot();

            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(8000);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(2000);
            windowsDriver.findElementByName("Chats").click();
            Thread.sleep(2000);
            if(windowsDriver.findElementByName("Chats").isDisplayed()){
                logger.log(Status.INFO,"successfully login to messenger");
                System.out.println("successfully login to messenger");
            }else {
                logger.log(Status.INFO,"successfully login to messenger failed");
                System.out.println("successfully login to messenger failed");
            }

           /* windowsDriver.findElement(By.xpath("//Document[@Name='Messenger']")).click();
            Thread.sleep(1000);////Document[@Name='Messenger']*/

            logger.log(Status.INFO, "Closing the Shift Application");
            windowsDriver.quit();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            WinDriver.stop();


        } catch (Exception e) {
            e.printStackTrace();
   }
}



}
