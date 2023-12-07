package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC015 extends AdminSuit{
	

	public void verifyQuickReplyFormDisplayed() throws InterruptedException {
		log.info("Verify Quick Reply Form Model Displayed");
		//ExtentTestManager.startTest("15) Verify Quick Reply Form Model Displayed");
		refreshBrowser();
		home.clickSettings();
		category.clickChat();
		quickreply.clickQuickReplies();
		WaitForElementToBeVisible(quickreply.L_newQucikReply);
		quickreply.clickNewQuickReplies();
		WaitForElementToBeVisible(quickreply.L_cancel);
		Thread.sleep(2000);
		boolean isvalid = ElementDisplayed(quickreply.L_modelBox);
		if(isvalid == true) {
			assertEquals(isvalid, true);
			ExtentSuccessMessage("Successfully Model Box Displayed");
		}else {
			ExtentErrorMessage("QUick Reply Model Box Not Displayed");
		}
		quickreply.clickCancelBtn();
	}

}
