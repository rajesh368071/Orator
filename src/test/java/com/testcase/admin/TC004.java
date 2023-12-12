package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC004 extends AdminSuit{
	
	public void verifyCancelButton() throws InterruptedException {
		log.info("4) Verify Cancel Button is Working");
		WaitForPageLoad();
		//ExtentTestManager.startTest("Verify Cancel Button is Working");
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		userManage.clickNewUser();
		assertEquals(ElementDisplayed(userManage.L_firstname), true);
		Thread.sleep(2000);
		userManage.clickCancel();
	}
	
}
