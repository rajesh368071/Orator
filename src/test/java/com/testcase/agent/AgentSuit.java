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
			tc003 = new TC003();
			tc004 = new TC004();
			tc005 = new TC005();
			tc006 = new TC006();
			tc007 = new TC007();
			tc008 = new TC008();
			tc009 = new TC009();
			tc010 = new TC010();
			tc011 = new TC011();
			tc012 = new TC012();
			tc013 = new TC013();
			tc014 = new TC014();
			tc015 = new TC015();
			tc016 = new TC016();
			tc017 = new TC017();
			tc018 = new TC018();
			tc019 = new TC019();
			tc020 = new TC020();
			tc021 = new TC021();
			tc022 = new TC022();
			tc023 = new TC023();
			tc024 = new TC024();
			tc025 = new TC025();
			
			
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
				case "TC003":
					context.setAttribute("fileName", "Login");
					Login();
					tc003.verifyChatAnalyst();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC004":
					context.setAttribute("fileName", "Login");
					Login();
					tc004.verifychatrequest();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC005":
					context.setAttribute("fileName", "Login");
					Login();
					tc005.verifychatrequest();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC006":
					context.setAttribute("fileName", "Login");
					Login();
					tc006.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC007":
					context.setAttribute("fileName", "Login");
					Login();
					tc007.verifyChatMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC008":
					context.setAttribute("fileName", "Login");
					Login();
					tc008.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC009":
					context.setAttribute("fileName", "Login");
					Login();
					tc009.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC010":
					context.setAttribute("fileName", "Login");
					Login();
					tc010.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC011":
					context.setAttribute("fileName", "Login");
					Login();
					tc011.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC012":
					context.setAttribute("fileName", "Login");
					Login();
					tc012.verifyChatMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC013":
					context.setAttribute("fileName", "Login");
					Login();
					tc013.verifyChatMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC014":
					context.setAttribute("fileName", "Login");
					Login();
					tc014.verifyChatMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC015":
					context.setAttribute("fileName", "Login");
					Login();
					tc015.verifychatrequest();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC016":
					context.setAttribute("fileName", "Login");
					Login();
					tc016.verifyChatMessage();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC017":
					context.setAttribute("fileName", "Login");
					Login();
					tc017.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC018":
					context.setAttribute("fileName", "Login");
					Login();
					tc018.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC019":
					context.setAttribute("fileName", "Login");
					Login();
					tc019.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC020":
					context.setAttribute("fileName", "Login");
					Login();
					tc020.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC021":
					context.setAttribute("fileName", "Login");
					Login();
					tc021.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC022":
					context.setAttribute("fileName", "Login");
					Login();
					tc022.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC023":
					context.setAttribute("fileName", "Login");
					Login();
					tc023.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC024":
					context.setAttribute("fileName", "Login");
					Login();
					tc024.verifyChatBoxOpen();
					Logout();
					context.setAttribute("fileName", "Logout");
				break;
				case "TC025":
					context.setAttribute("fileName", "Login");
					Login();
					tc025.verifyChatBoxOpen();
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
