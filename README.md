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
- WinAppDriver - [Download here](https://github.com/microsoft/WinAppDriver/releases/download/v1.2.99/WindowsApplicationDriver-1.2.99-win-x64.exe)
- Download Maven and unzip it [Download here](https://dlcdn.apache.org/maven/maven-3/3.9.6/binaries/apache-maven-3.9.6-bin.zip)

### Project Setup
1. Go to the master branch in the Project > click on Code (Green Button dropdown) > Download the zip file.
2. Once the zip/project is downloaded , unzip it.
3. Download and Install WinappDriver from the location in the prerequisite. Once installed Note the location/path where it is installed. *– Note the path*
4. After WinappDriver is installed turn on developer mode settings in your local system Settings.
5. Install Maven . Set Maven path in Environment Variables after installation
6. Install Java JDK . Set Java path in Environment Variables after installation

### Running the Tests
1. For running the test we need to first specify the location/path of our WinappDriver and other folders.
2. For changing the path of winappdriver and other folder 
3. Navigate to the folder--Shift_automation/src/test/java/Utilities/Constants.java And change the path for line 6, 7, 9 respectively. I wish you have noted the location above properly and had not lost it 😊

**Line 6 -** change the path to your Download folder

**Line 7 -** change the path to shift download location which launches your shift application. Try changing Tears in Rain to your folder name.

**Line 9 -** change the path to your WindowsApplicationDriver location and make sure this invokes your exe file.

![path screenshot](https://github.com/ShiftUser/Shift_Automation_Framework/blob/master/Shift_automation/src/test/resources/ChangePath%20Constants.PNG )

4. Once the changes for path is done. *Save the file*
5. Now close the file
6. Make sure Shift is not installed in your system and have no folders related to it also clear your temp files from your local system. Now once your are done with clearing all your Shift related files and Temp.  You can follow the link [How to uninstall Shift](https://support.tryshift.com/kb/article/679-how-to-uninstall-shift-from-your-computer-windows/)
7. Open command prompt and type the below commands

   Command 1 :- **cd locationforpom.xml** Hit Enter

   Command 2 :- **mvn install** Hit Enter
7. The Execution will start .Let's just wait and watch. Please do not touch the mousepad once the execution is finished.
8. Hola your test execution is successful, You can check the reports in Shift reports folder which is generated in the project location with the date and time stamp. 


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
