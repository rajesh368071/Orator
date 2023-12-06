package com.IVOS_Caching;

import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.By;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;

//Call the methods and 
public class NavigateToWCTabs extends Base_Class {

	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	private static By L_Logout = By.xpath("//body/div[@id='banner']/div[@id='rightMenu']/ul[1]/li[3]/i[1]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("WC_Claim");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

	}

	@AfterSuite
	public void CloseAllBrowser() {
		// Logout
		// context.setAttribute("fileName", "Logout");
		// driver.quit();

		ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
		// ExtentTestManager.getTest().log(Status.FAIL, "Application Logout-Test1");
		// ExtentSuccessMessage("Logout is done");

		// EndTest
		// ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
		// ExtentSuccessMessage("************************ Test Suite " +
		// testdata.get("TestScenario").toString() + " ending
		// ****************************");

	}

	public void Login() throws InterruptedException {
		String ReferenceLogin = "WC";
		try {
			Base_Class.SetUp(ReferenceLogin);
			// ExtentTestManager.getTest().log(Status.PASS, "Application Login " +
			// Base_Class.Pagetitle);
//			ExtentSuccessMessage("Login successful !");
		} catch (IOException e) {
			e.printStackTrace();
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login " + "With error ");
			ExtentErrorMessage("Issue while login into the application ");
		} catch (InterruptedException e) {
			ExtentTestManager.getTest().log(Status.FAIL, "Application fail to Login With error");
			ExtentErrorMessage("Issue while login into the application");
			e.printStackTrace();
		}
	}

	public void Logout() {
		try {
			CloseAllBrower();
			// ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {

		try {

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");

				switch (testdata.get("TestScenario").toString()) {

				default:
					break;

				}

			}

		} catch (Exception e) {
			CloseAllBrower();
			System.out.println("<----------------Failed--- Test execution " + testdata.get("TestScenario").toString()
					+ " ---Failed ---------------->");
			ExtentErrorMessage("" + e.getMessage());
			ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
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
