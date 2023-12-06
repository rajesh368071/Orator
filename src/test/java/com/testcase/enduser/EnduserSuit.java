package com.testcase.enduser;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.WelcomePage;
import com.pages.endusers.ChatbedPage;

public class EnduserSuit extends Base_Class{
	
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	SoftAssert softAssertion;
	com.Utility.ScreenShot screenShot;
	WelcomePage welcome = new WelcomePage();
	ChatbedPage chatbed = new ChatbedPage();
	
	@BeforeSuite
	public void reference() throws InterruptedException, IOException {
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		softAssertion = new SoftAssert();
		ExtentTestManager.startTest("Orator Admin Page Launched");
		Login();
	}

	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException {
		driver.quit();
		ExtentTestManager.getTest().log(Status.PASS, "Application Qlosed");
		ExtentManager.getInstance().flush();
	}
	
	
	public void Login() throws InterruptedException {
		try {
			Base_Class.EndUserSetUp();
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
}
