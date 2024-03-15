# Shift Test Automation Framework

### Introduction
Hi My name is Supattra Boonchalee🖐 , I have created an Automation Framework for Shift. This project utilizes a powerful stack of technologies, including Java for robustness, Selenium and WebDriver for web automation, WinAppDriver for Windows application automation, TestNG for test management, and AWT Robot for simulating user interactions. The project also contains automated tests for Shift, a web browser, focusing on installation and verification processes.

### Test Cases Performed
- Verify Shift Browser Download
- Verify Shift Browser Installation
- Verify Login and Unread Emails Count
- Verify Adding Workspace and Unread Emails Status
- Verify Login to Messenger Application

### Prerequisites
- Java JDK installed
- IntelliJ IDEA or any preferred Java IDE
- ChromeDriver – [Download here](https://storage.googleapis.com/chrome-for-testing-public/122.0.6261.128/win64/chromedriver-win64.zip)
- WinAppDriver - [Download here](https://github.com/microsoft/WinAppDriver/releases/download/v1.2.99/WindowsApplicationDriver-1.2.99-win-x64.exe)
- Maven

### Project Setup
1. Download and Install WinappDriver from the location in the prerequisite. Once installed Note the location/path where it is installed. *– Note 1*
2. After WinappDriver is installed turn on developer mode settings in your local system Settings.
3. Install Maven . Set Maven path in Environment Variables after installation
4. Install Java JDK . Set Java path in Environment Variables after installation
5. Download ChromeDriver and unzip it. Note the path where it is installed *– Note 2*
6. Install Shift Windows application manually and keep a note of the default path/location where it is getting installed. *– Note 3*
7. Once you have the location of the Shift exe then uninstall Shift . You can follow the link [How to uninstall Shift](https://support.tryshift.com/kb/article/679-how-to-uninstall-shift-from-your-computer-windows/)
8. Make sure you also delete temp files after installation – “%temp%” .
9. Clone the repository to your local machine.
10. Open the project in your preferred Java IDE 

11. Ensure all dependencies are installed and configured correctly.
12. Navigate to the folder--Shift_automation/src/test/java/Utilities/Constants.java And change the path for line 5, 6, 7, 9 respectively. I wish you have noted the location above properly and had not lost it 😊
![path screenshot](https://github.com/ShiftUser/Shift_Automation_Framework/blob/master/Shift_automation/src/test/resources/Constants.PNG)
13. Once you change the path try to reload maven 
14. Check for build success.

### Running the Tests
1. We get two options to execute our test cases, the first one is we can run our test case one by one and the second one is run everything at once.
2. If you want to run one by one. Make sure Shift is not installed in your system and have no folders related to it. Navigate to “Shift_Browser_TestCase.java” and then right click on the class Shift_Browser_TestCase.java. You will get an option to Run. Click on Run and Do the same for different class i.e Shift_WinAppdriverTestCase.
3. Now the second case, If you want to run everything at once. Make sure Shift is not installed in your system and have no folders related to it. then Navigate to runner folder – Inside it smokeRunner.xml will be present. Right click on smokeRunner.xml and Run it.
4. Once the Execution is successful. A directory will be created in project Folder with the name Shift_Reports. Where you can access the reports and further dig into to check the status of the Test case executed.
5. *Note:-* If you want to perform Step 2 and Step 3 both, In that case first perform Step 2 and then follow point 7 and 8 mentioned in the Project Set up means uninstall and delete everything of Shift browser including temp files and then Perform Step 3.
6. Also, I am keeping an extra class for my Interview Demo Purpose i.e. “Shift_WinAppdriverTestCase_One_By_One.java”. Please do not touch 😊

### Reports
Please note once the execution is successful the report will be generated along with a date and time stamp in the project directory This is how the report will look like:
![Report screenshot 1 ](https://github.com/ShiftUser/Shift_Automation_Framework/blob/master/Shift_automation/src/test/resources/ScreenShortReport1.PNG)


### Execution Sample
[Recorded Execution video](https://www.veed.io/view/679f6f3d-4ff5-4e62-a045-2ec82aab765c?panel=share)

[Test case status](https://github.com/ShiftUser/Shift_Automation_Framework/blob/master/Shift_automation/src/test/resources/TC_Shift_3_15_2024.xlsx)

### Future Steps
- Attaching Screenshot for failure and pass in the report.
- Adding Wait Statement 
- Making the framework more reliable

### Author
Supattra Boonchalee

Feel free to reach out at supattraboonchalee@gmail.com if you have any questions or need further assistance. Happy testing!
