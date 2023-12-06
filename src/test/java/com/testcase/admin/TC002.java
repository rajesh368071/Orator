package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TC002 extends AdminSuit {

	
	public void verifyUserManagement() throws InterruptedException {
		log.info("2) Verify User Management Page is Displayed");
		
		//ExtentTestManager.startTest("Verify User Management Page is Displayed");
		
		home.clickUserManagement();
		WaitForElementToBeVisible(home.L_newuser);
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://s3po-demo.speridian.com/oratordemoadmin/admin/userList");
		if(url.equals(url)) {
			ExtentTestManager.getTest().log(Status.PASS, "User Management Page is Displayed");
		}
		else {
			ExtentTestManager.getTest().log(Status.FAIL, "User Management Page is Not Displate Insted "+ url+" is displayed");
		}
	}
	
}
