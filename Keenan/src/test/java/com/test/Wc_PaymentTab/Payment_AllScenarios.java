package com.test.Wc_PaymentTab;

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

public class Payment_AllScenarios extends Base_Class {
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	com.Utility.ExcelReader ExcelReader;

	WC_PaymentTab_TC001 WC_PaymentTab_TC001;
	WC_PaymentTab_TC002 WC_PaymentTab_TC002;
	WC_PaymentTab_TC003 WC_PaymentTab_TC003;
	WC_PaymentTab_TC004 WC_PaymentTab_TC004;
	WC_PaymentTab_TC006 WC_PaymentTab_TC006;
	WC_PaymentTab_TC008 WC_PaymentTab_TC008;
	WC_PaymentTab_TC009 WC_PaymentTab_TC009;
	WC_PaymentTab_TC010 WC_PaymentTab_TC010;
	WC_PaymentTab_TC011 WC_PaymentTab_TC011;
	WC_PaymentTab_TC012 WC_PaymentTab_TC012;
	WC_PaymentTab_TC013 WC_PaymentTab_TC013;
	WC_PaymentTab_TC014 WC_PaymentTab_TC014;
	WC_PaymentTab_TC015 WC_PaymentTab_TC015;
	WC_PaymentTab_TC016 WC_PaymentTab_TC016;
	WC_PaymentTab_TC021 WC_PaymentTab_TC021;
	WC_PaymentTab_TC022 WC_PaymentTab_TC022;
	WC_PaymentTab_TC023 WC_PaymentTab_TC023;

	private static By L_Logout = By.xpath("//body/div[@id='banner']/div[@id='rightMenu']/ul[1]/li[3]/i[1]");

	@BeforeSuite
	public void reference() {
		ExcelReader = new com.Utility.ExcelReader("WC_PaymentTab");
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();

		WC_PaymentTab_TC001 = new WC_PaymentTab_TC001();
		WC_PaymentTab_TC002 = new WC_PaymentTab_TC002();
		WC_PaymentTab_TC003 = new WC_PaymentTab_TC003();
		WC_PaymentTab_TC004 = new WC_PaymentTab_TC004();
		WC_PaymentTab_TC006 = new WC_PaymentTab_TC006();
		WC_PaymentTab_TC008 = new WC_PaymentTab_TC008();
		WC_PaymentTab_TC009 = new WC_PaymentTab_TC009();
		WC_PaymentTab_TC010 = new WC_PaymentTab_TC010();
		WC_PaymentTab_TC011 = new WC_PaymentTab_TC011();
		WC_PaymentTab_TC012 = new WC_PaymentTab_TC012();
		WC_PaymentTab_TC013 = new WC_PaymentTab_TC013();
		WC_PaymentTab_TC014 = new WC_PaymentTab_TC014();
		WC_PaymentTab_TC015 = new WC_PaymentTab_TC015();
		WC_PaymentTab_TC016 = new WC_PaymentTab_TC016();
		WC_PaymentTab_TC021 = new WC_PaymentTab_TC021();
		WC_PaymentTab_TC022 = new WC_PaymentTab_TC022();
		WC_PaymentTab_TC023 = new WC_PaymentTab_TC023();

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
			ExtentSuccessMessage("Login successful !");
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
			killExcel();
			ExtentTestManager.endTest();
			ExtentManager.getInstance().flush();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Test(dataProvider = "TestData")
	public void RUNALL(Map<Object, Object> testdata, ITestContext context) throws Throwable {

		try {
			String TestScenario = testdata.get("TestScenario").toString();
			String ClaimNumber = testdata.get("ClaimNumber").toString();
			String ColumnName = testdata.get("ColumnName").toString();
			String ColumnValue = testdata.get("ColumnValue").toString();
			String ViewReport = testdata.get("ViewReport").toString();
			String Payee = testdata.get("Payee").toString();
			String Method = testdata.get("Method").toString();
			String BilledAmount = testdata.get("BilledAmount").toString();
			String Transaction = testdata.get("Transaction").toString();
			String DueDate = testdata.get("DueDate").toString();
			String FromDate = testdata.get("FromDate").toString();
			String ThroughDate = testdata.get("ThroughDate").toString();
			String FromDate1 = testdata.get("FromDate1").toString();
			String ThroughDate1 = testdata.get("ThroughDate1").toString();
			String ApprovalStatus = testdata.get("ApprovalStatus").toString();
			String InvoiceNumber = testdata.get("InvoiceNumber").toString();
			String RelatedItem = testdata.get("RelatedItem").toString();
			String sticky_note_category = testdata.get("sticky_note_category").toString();
			String sticky_note_overview = testdata.get("sticky_note_overview").toString();
			String RelatedID = testdata.get("RelatedID").toString();

			if (testdata.get("Run").toString().equalsIgnoreCase("Yes") && TestScenario.contains("_PaymentTab")) {
				ExtentTestManager.startTest(testdata.get("TestScenario").toString());
				System.out.println("\n");
				System.out.println(
						"<--------------------------------------- START NEW TESTCASE --------------------------------------------------------->");
				ExtentSuccessMessage("*** Running test method " + testdata.get("TestScenario").toString() + "...");
				Log.info("*** Running test method " + testdata.get("TestScenario").toString() + "...");

				switch (testdata.get("TestScenario").toString()) {

				///////////////////////////// NotepadTab///////////////////////////////////////////////

				case "WC_PaymentTab_TC001":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC001.AddnewPayment(TestScenario, ClaimNumber, Payee, Method, BilledAmount,
							Transaction, DueDate, FromDate, ThroughDate, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC002":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC002.verifyDropdownsvalues(TestScenario, ClaimNumber, Method, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC003":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC003.verifyDatesvalues(TestScenario, ClaimNumber, FromDate, ThroughDate, FromDate1,
							ThroughDate1);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC004":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC004.verifyPayeeDropdownsvalues(TestScenario, ClaimNumber, Payee);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC006":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC006.InvoiceNumberinGrid(TestScenario, ClaimNumber, Payee, Method, BilledAmount,
							Transaction, DueDate, FromDate, ThroughDate, ApprovalStatus, InvoiceNumber);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC008":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC008.Verifypriorpayments(TestScenario, ClaimNumber, Payee, ApprovalStatus, Method,
							FromDate1, ThroughDate1);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC009":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC009.SortingTheColumn(TestScenario, ClaimNumber, ColumnName);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC010":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC010.AddRelatedItem(TestScenario, ClaimNumber, RelatedItem, sticky_note_category,
							sticky_note_overview, RelatedID);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC011":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC011.ViewingItemsinrelateitemmanagerwindowandclosingwindowcausestabtorefresh(
							TestScenario, ClaimNumber, RelatedID, Payee, ApprovalStatus, Method, FromDate1,
							ThroughDate1);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC012":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC012.Runpaymentlisting(TestScenario, ClaimNumber, ColumnName, ColumnValue,
							ViewReport);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC013":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC013.Makechangestopayment(TestScenario, ClaimNumber, ColumnName, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");

				case "WC_PaymentTab_TC014":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC014.MakePayment(TestScenario, ClaimNumber, Payee, Method, BilledAmount, Transaction,
							DueDate, FromDate, ThroughDate, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "WC_PaymentTab_TC015":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC015.CancelPayment(TestScenario, ClaimNumber);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "WC_PaymentTab_TC016":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC016.AddRecovories(TestScenario, ClaimNumber, Payee, Method, BilledAmount,
							Transaction, DueDate, FromDate, ThroughDate, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "WC_PaymentTab_TC021":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC021.SortColumn(TestScenario, ClaimNumber, ColumnName);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "WC_PaymentTab_TC022":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC022.DownloadResultGrid(TestScenario, ClaimNumber, Payee, Method, BilledAmount,
							Transaction, DueDate, FromDate, ThroughDate, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				case "WC_PaymentTab_TC023":

					context.setAttribute("fileName", "Login");
					Login();
					WC_PaymentTab_TC023.EnterScheduledPayment(TestScenario, ClaimNumber, Payee, Method, BilledAmount,
							Transaction, DueDate, FromDate, ThroughDate, ApprovalStatus);
					Logout();
					context.setAttribute("fileName", "Logout");
					break;

				default:
					break;

				}

				// // EndTest
				// System.out.println(("*** Test Suite " +
				// testdata.get("TestScenario").toString() + " ending ***"));
				// ExtentTestManager.endTest();
				// ExtentManager.getInstance().flush();
				// ExtentSuccessMessage("*** Test Suite " +
				// testdata.get("TestScenario").toString() + " ending ***");

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