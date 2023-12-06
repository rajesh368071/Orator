package com.textcase.all;

import java.io.IOException;
import com.orator.pages.LoginPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.FakeData;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.WelcomePage;
import com.pages.endusers.ChatbedPage;

public class AllTestcases extends Base_Class{
	
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	SoftAssert softAssertion;
	FakeData fakedata = new FakeData();
	com.Utility.ScreenShot screenShot;
	
	WelcomePage welcome = new WelcomePage();
	ChatbedPage chatbed = new ChatbedPage();
	LoginPage login = new LoginPage();
	
	@BeforeMethod
	public void reference() throws InterruptedException, IOException {
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		softAssertion = new SoftAssert();
		ExtentTestManager.startTest("Orator End User Page Launched");
		EndUserSetUp();
	}

	@AfterMethod
	public void CloseAllBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
		ExtentTestManager.getTest().log(Status.PASS, "Application Quit");
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
