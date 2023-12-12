package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC036 extends AdminSuit {
	
	
	public void verifySameWelcomeMessage() throws InterruptedException {
		log.info("Verify Chat Feedback Page Displayed");
		WaitForPageLoad();
		ExtentTestManager.startTest("36) Verify Chat Feedback Page Displayed");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		chatfeedback.clickChatFeedback();
		boolean isChatFeedbackPageDisplayed = ElementDisplayed(chatfeedback.L_page_title);
		if(isChatFeedbackPageDisplayed) {
			assertEquals(isChatFeedbackPageDisplayed, true);
			ExtentSuccessMessage("Chat Feedback Page Displayed Successfully");
		}
	}

}
