package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC038 extends AdminSuit{
	
	public void verifyCreateQuickReply() throws InterruptedException {
		log.info("Verify able to Update Quick Reply");
		//ExtentTestManager.startTest("38) Verify able to Update Quick Reply");
		WaitForPageLoad();
		home.clickSettings();
		category.clickChat();
		quickreply.clickQuickReplies();
		quickreply.clickEdit();
		clear(quickreply.L_shortNameField);
		clear(quickreply.L_quickReplyField);
		quickreply.enterQuickReply(gandomWordGenerate());
		quickreply.enterShortCut(2);
		quickreply.clickSubmit();
		boolean isDisplayed = ElementDisplayed(quickreply.L_popupupdate);
		if(true) {
			assertEquals(isDisplayed, true);
			ExtentSuccessMessage("Quick Reply Created Successfully");
		}else {
			ExtentErrorMessage("Quick Reply Not Created");
		}
	}
	
}
