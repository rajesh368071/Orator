package com.testcase.admin;


import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TC003 extends AdminSuit{
	
	public void verifySettings() throws InterruptedException {
		log.info("3) Verify Settings is Clicked");
		WaitForPageLoad();
		//ExtentTestManager.startTest("Verify Settings is Clicked");
		refreshBrowser();
		home.clickSettings();
		WaitForElementToBeVisible(home.L_chat);
		if(ElementDisplayed(home.L_chat)) {
			ExtentTestManager.getTest().log(Status.PASS, "Settings Button is Working");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "Settings Option is not working ");
		}
	}
	
}
