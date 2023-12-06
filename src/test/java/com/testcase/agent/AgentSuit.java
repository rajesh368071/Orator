package com.testcase.agent;

import java.awt.AWTException;
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
import com.pages.admin.FormsWelcomePage;
import com.pages.admin.HolidayGroupPage;
import com.pages.admin.HomePage;
import com.pages.admin.ManageGroupPage;
import com.pages.admin.QuickReplyPage;
import com.pages.admin.TicketPage;
import com.pages.admin.UserManagementPage;
import com.pages.agent.AgentReviewBordPage;
import com.pages.agent.RoutedChatPage;
import com.pages.agent.SupervisorPage;
import com.pages.endusers.ChatbedPage;

public class AgentSuit extends Base_Class{
	
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	SoftAssert softAssertion;
	FakeData fakedata = new FakeData();
	com.Utility.ScreenShot screenShot;
	ExcelReader excel;
	
	WelcomePage welcome = new WelcomePage();
	LoginPage login = new LoginPage();
	ChatbedPage chatbed = new ChatbedPage();
	RoutedChatPage routedchat = new RoutedChatPage();
	AgentReviewBordPage reviewboard = new AgentReviewBordPage();
	SupervisorPage supervisor = new SupervisorPage();
	
	//Testcases
	TC001 tc001;
	TC002 tc002;
	
	public void commend() throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /T");
	}
	
	
	@BeforeSuite
	public void reference() throws InterruptedException, IOException {
			log = new Log();
			excel = new ExcelReader("Agent_Suit");
			TestListener = new TestListener();
			screenShot = new com.Utility.ScreenShot(null);
			Base_Class = new Base_Class();
			softAssertion = new SoftAssert();
			
			tc001 = new TC001();
			tc002 = new TC002();
	}
	
	
	////
	@Test(dataProvider="TestData")
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
					tc001.verifyAgentPart();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC002":
					context.setAttribute("fileName", "Login");
					Login();
					tc002.verifyChatAnalyst();
					Logout();
					context.setAttribute("fileName", "Logout");
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
 
			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
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
	////

	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException, IOException {
		ExtentTestManager.getTest().log(Status.PASS, "Browser closed");
		ExtentManager.getInstance().flush();
	}
	
	
	public void Login() throws InterruptedException, IOException {
		try {
			Base_Class.AgentSetUp();
			WaitForElementToBeVisible(welcome.L_username);
			ExtentTestManager.getTest().log(Status.PASS, "Application Login " + Base_Class.Pagetitle);
			ExtentSuccessMessage("Login successful !");
		} catch (IOException e) {
			
			ExtentTestManager.startTest("Orator Logout");
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login " + "With error ");
			ExtentErrorMessage("Issue while login into the application ");
		} catch (InterruptedException e) {
			
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login With error");
			ExtentErrorMessage("Issue while login into the application");
			e.printStackTrace();
		}
	}
	
	
	public void Logout() throws AWTException, IOException {
		try {
			Thread.sleep(5000);
			if (ElementDisplayed(welcome.L_username)) {
				Thread.sleep(2000);
				welcome.clickUsername();
				Thread.sleep(2000);
				jsClick(L_logout);
				driver.quit();
				ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
			} else {
				Log.error("Logout Not Visiable");
			}
			//driver.quit();
			killExcel();
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (InterruptedException e) {
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
