package com.testcase.enduser;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.extentReports.ExtentTestManager;

public class TC002 extends EnduserSuit{
	
	@Test
	public void verifyChatBoxDisplayed() throws InterruptedException {
		ExtentTestManager.startTest("Verify User is able to open chat box");
		WaitForElementToBeVisible(chatbed.L_chat);
		chatbed.clickChatButton();
		SwitchToFrameByID(chatbed.L_iframe);
		if(ElementDisplayed(chatbed.L_chatinpt)) {
			ExtentTestManager.getTest().log(Status.PASS, "Chat Box Displayed");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "Chat Box Not Displayed");
		}
		chatbed.clickFQA();
		Thread.sleep(5000);
	}
	
}
