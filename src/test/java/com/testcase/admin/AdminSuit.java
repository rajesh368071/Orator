package com.testcase.admin;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.ExcelReader;
import com.Utility.FakeData;
import com.Utility.Log;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.LoginPage;
import com.orator.pages.WelcomePage;
import com.pages.admin.BusinessHoursPage;
import com.pages.admin.ChatCategoriesPage;
import com.pages.admin.ChatFeedbackPage;
import com.pages.admin.FormsWelcomePage;
import com.pages.admin.HolidayGroupPage;
import com.pages.admin.HomePage;
import com.pages.admin.ManageGroupPage;
import com.pages.admin.QuickReplyPage;
import com.pages.admin.ThemePage;
import com.pages.admin.TicketPage;
import com.pages.admin.UserManagementPage;
import com.pages.endusers.ChatbedPage;

public class AdminSuit extends Base_Class{
	
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	SoftAssert softAssertion;
	FakeData fakedata = new FakeData();
	com.Utility.ScreenShot screenShot;
	ExcelReader excel;
	
	HomePage home = new HomePage();
	WelcomePage welcome = new WelcomePage();
	UserManagementPage userManage = new UserManagementPage(); 
	LoginPage login = new LoginPage();
	ChatCategoriesPage category = new ChatCategoriesPage();
	QuickReplyPage quickreply = new QuickReplyPage();
	FormsWelcomePage formwelcome = new FormsWelcomePage();
	ChatbedPage chatbed = new ChatbedPage();
	HolidayGroupPage holidaygroup = new HolidayGroupPage();
	BusinessHoursPage businesshours = new BusinessHoursPage();
	ManageGroupPage managegroup = new ManageGroupPage();
	TicketPage ticket = new TicketPage();
	ChatFeedbackPage chatfeedback = new ChatFeedbackPage();
	ThemePage theme = new ThemePage();
	
	//Testcases Obj
	TC001 tc001;
	TC002 tc002;
	TC003 tc003;
	TC004 tc004;
	TC005 tc005;
	TC006 tc006;
	TC007 tc007;
	TC008 tc008;
	TC009 tc009;
	TC010 tc010;
	TC011 tc011;
	TC012 tc012;
	TC013 tc013;
	TC014 tc014;
	TC015 tc015;
	TC016 tc016;
	TC017 tc017;
	TC018 tc018;
	TC019 tc019;
	TC020 tc020;
	TC021 tc021;
	TC022 tc022;
	TC023 tc023;
	TC024 tc024;
	TC025 tc025;
	TC026 tc026;
	TC027 tc027;
	TC028 tc028;
	TC029 tc029;
	TC030 tc030;
	TC031 tc031;
	TC032 tc032;
	TC040 tc040;
	TC041 tc041;
	TC042 tc042;
	TC043 tc043;


	
	public void commend() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
	}
	
	
	@BeforeClass
	public void reference() throws InterruptedException, IOException {
		try {
			excel = new ExcelReader("Admin_Suit");
			log = new Log();
			TestListener = new TestListener();
			screenShot = new com.Utility.ScreenShot(null);
			Base_Class = new Base_Class();
			softAssertion = new SoftAssert();
			tc001 = new TC001();
			tc002 = new TC002();
			tc003 = new TC003();
			tc004 = new TC004();
			tc040 = new TC040();
			tc041 = new TC041();
			tc042 = new TC042();
			tc043 = new TC043();
			Thread.sleep(2000);
			//ExtentTestManager.startTest("Orator Admin Page Launched");
			
		} catch (Exception e) {
			driver.quit();
			commend();
		}
			
	}
	
	////////
	
	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata,ITestContext context) throws Throwable {
		
		try {
			String TestScenario = testdata.get("Test_ID").toString();
			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("TC")) {
				ExtentTestManager.startTest(TestScenario);
				System.out.println("\n");
				System.out.println("<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + TestScenario + "...");
				Log.info("*** Running test method " + TestScenario + "...");
 
				switch (TestScenario) {
				case "TC001":
					context.setAttribute("fileName", "Login");
					Login();
					tc001.verifyReviewBord();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC002":
					context.setAttribute("fileName", "Login");
					Login();
					tc002.verifyUserManagement();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC040":
					context.setAttribute("fileName", "Login");
					Login();
					tc040.verifySameWelcomeMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC041":
					context.setAttribute("fileName", "Login");
					Login();
					tc041.verifySameWelcomeMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC042":
					context.setAttribute("fileName", "Login");
					Login();
					tc042.verifySameWelcomeMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC043":
					context.setAttribute("fileName", "Login");
					Login();
					tc043.verifySameWelcomeMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC003":
					///context.setAttribute("fileName", "Login");
					Login();
					
					Logout();
					//context.setAttribute("fileName", "Logout");
				break;
				default:
					break;
				}
 
				// EndTest
				System.out.println(("*** Test Suite " + TestScenario + " ending ***"));
				ExtentTestManager.endTest();
				ExtentManager.getInstance().flush();
				Log.info("*** Test Suite " + TestScenario + " ending ***");
 
			}
 
		} catch (Exception e) {
 
			System.out.println("<----------------Failed--- Test execution " + testdata.get("Test_ID").toString()
					+ " ---Failed ---------------->");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");
 
			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("Test_ID").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("Catch File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
 
			// EndTest
			System.out.println(("*** Test Suite " + testdata.get("Test_ID").toString() + " ending ***"));
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("*** Test Suite " + testdata.get("Test_ID").toString() + " ending ***");
		} catch (AssertionError e) {
			System.out.println("*** Test execution " + testdata.get("Test_ID").toString() + " failed...");
			Log.error("*** Test execution " + testdata.get("Test_ID").toString() + " failed...");
			Log.error("" + e.getMessage());
			String fileName = (String) context.getAttribute("fileName");
 
			try {
				File file = new com.Utility.ScreenShot(driver).takeScreenShot(fileName,
						testdata.get("Test_ID").toString());
				ExtentTestManager.getTest().fail(e.getMessage(),
						MediaEntityBuilder.createScreenCaptureFromPath(file.toString()).build());
			} catch (Exception NoSuchWindowException) {
				System.out.println("File not found error");
			}
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
 
			// EndTest
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
			Log.info("************************ Test Suite " + testdata.get("Test_ID").toString()
					+ " ending ****************************");
 
		} finally {
			if (driver != null) {}
				commend();
 
		}
	}
	
	public void Logout() throws InterruptedException, IOException {
		WaitForElementToBeVisible(welcome.L_username);
		Thread.sleep(5000);
		welcome.clickUsername();
		Thread.sleep(3000);
		jsClick(L_logout);
		Thread.sleep(3000);
		ExtentManager.getInstance().flush();
	}
	
	
	
	//////////

	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException, IOException {
		/*try {
			WaitForElementToBeVisible(welcome.L_username);
			Thread.sleep(5000);
			welcome.clickUsername();
			Thread.sleep(3000);
			jsClick(L_logout);
			Thread.sleep(3000);
			driver.quit();
			commend();
			ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			ExtentManager.getInstance().flush();
		} catch (Exception e) {
			driver.quit();
			commend();
			ExtentTestManager.getTest().log(Status.FAIL, "Application Quit");
			log.error(e.toString());
			ExtentManager.getInstance().flush();
		} */
		
		ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
		ExtentManager.getInstance().flush();
		driver.quit();
		
	}
	
	
	public void Login() throws InterruptedException, IOException {
		try {
			Base_Class.AdminSetUp();
			WaitForElementToBeVisible(welcome.L_username);
		} catch (IOException e) {
			driver.quit();
			commend();
			ExtentTestManager.startTest("Orator Logout");
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login " + "With error ");
			ExtentErrorMessage("Issue while login into the application ");
		} catch (InterruptedException e) {
			driver.quit();
			commend();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login With error");
			ExtentErrorMessage("Issue while login into the application");
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "TestData")
	public static Object[][] gettestdate() throws IOException {

		Object[][] objectarry = null;
		java.util.List<Map<String, String>> completedata = com.Utility.ExcelReader.getdata();

		objectarry = new Object[completedata.size()][1];

		for (int i = 0; i < completedata.size(); i++) {
			objectarry[i][0] = completedata.get(i);
		}
		return objectarry;

	}
	

}
