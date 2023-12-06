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
import com.orator.pages.WelcomePage;

public class Testcase_001 extends Base_Class{
	
	TestListener TestListener;
	Base_Class Base_Class;
	Log log;
	com.Utility.ScreenShot screenShot;
	WelcomePage welcome = new WelcomePage();
	
	@BeforeSuite
	public void reference() throws InterruptedException {
		log = new Log();
		TestListener = new TestListener();
		screenShot = new com.Utility.ScreenShot(null);
		Base_Class = new Base_Class();
		ExtentTestManager.startTest("Orator Login");
		Login();

	}

	@AfterSuite
	public void CloseAllBrowser() throws InterruptedException {
		welcome.clickUsername();
		jsClick(L_logout);
		WaitForPageLoad();
		driver.quit();
		ExtentTestManager.getTest().log(Status.PASS, "Application Logout");
		ExtentManager.getInstance().flush();
	}
	
	
	public void Login() throws InterruptedException {
		try {
			Base_Class.AdminSetUp();
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
	public void navigateToProfile() throws InterruptedException {
		WaitForElementToBeVisible(welcome.L_username);
		welcome.clickUsername();
		WaitForElementToBeVisible(welcome.L_profile);
		welcome.clickProfile();
		WaitForPageLoad();
		Thread.sleep(4000);
		assertEquals(driver.getCurrentUrl(), "https://s3po-demo.speridian.com/oratordemoadmin/profile");
		ExtentTestManager.getTest().log(Status.PASS, "Application Able to Navigate to Profile");
	}
	
	@Test
	public void navigateToChangePassword() throws InterruptedException {
		WaitForElementToBeVisible(welcome.L_username);
		welcome.clickUsername();
		WaitForElementToBeVisible(welcome.L_changepassword);
		welcome.clickChangePassword();
		WaitForPageLoad();
		Thread.sleep(4000);
		assertEquals(driver.getCurrentUrl(), "https://s3po-demo.speridian.com/oratordemoadmin/profile");
		ExtentTestManager.getTest().log(Status.PASS, "Application Able to Navigate to Profile");
	}
	
	@Test
	public void checkAvailable() throws InterruptedException {
		
		WaitForElementToBeVisible(welcome.L_username);
		welcome.clickUsername();
		WaitForElementToBeVisible(welcome.L_availabletoggle);
		assertEquals(welcome.clickAvailable(), false);
		WaitForPageLoad();
		Thread.sleep(4000);
		ExtentTestManager.getTest().log(Status.PASS, "User is able to change the availablity");
	}

}
