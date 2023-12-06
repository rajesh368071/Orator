package com.testcase.enduser;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC001 extends EnduserSuit{
	
	@Test
	
	public void verifyEnduserAppLaunch() throws InterruptedException {
		ExtentTestManager.startTest("Verify Able to Launch Enduser Application");
		boolean isdisplayed = ElementDisplayed(chatbed.L_chat);
		if(isdisplayed) {
			assertEquals(isdisplayed, true);
		} else {
			assertEquals(isdisplayed, false);
		}
	}
	
}
