package com.orator.testcases;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BasePackage.Base_Class;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.ChatbedPage;
import com.orator.pages.WelcomePage;

public class All_Scenario extends Base_Class{
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	WelcomePage welcome = new WelcomePage();
	ChatbedPage endchat = new ChatbedPage();
	
	@BeforeSuite
	public void reference() throws InterruptedException, IOException {
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		ExtentTestManager.startTest("Orator End User Launched");
		EndUserSetUp();
	}

	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException {
		driver.quit();
		ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
		ExtentManager.getInstance().flush();
	}
	
	
	public void Login() throws InterruptedException {
		String ReferenceLogin = "DISABILITY";
		try {
			Base_Class.EndUserSetUp();
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
	
	@Test
	public void verifyChatBtnDisplayed() throws InterruptedException {
		ExtentTestManager.startTest("Verify Chat Button is Displated");
		assertEquals(true, endchat.verifyChatBtnDisplayed());
	}
	
	@Test
	public void enduserChatbox() throws IOException, AWTException, InterruptedException {
		ExtentTestManager.startTest("Verify Chat Button is Clicked");
		WaitForElementToBeVisible(endchat.L_chat);
		Thread.sleep(10000);
		endchat.clickChatButton();
		Thread.sleep(5000);
	}
}
