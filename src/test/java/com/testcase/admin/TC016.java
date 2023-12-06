package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC016 extends AdminSuit{
	
	@Test(priority = 16)
	public void verifyCreateQuickReply() throws InterruptedException {
		log.info("Verify able to Create New Quick Reply");
		ExtentTestManager.startTest("16) Verify able to Create New Quick Reply");
		refreshBrowser();
		home.clickSettings();
		category.clickChat();
		quickreply.clickQuickReplies();
		WaitForElementToBeVisible(quickreply.L_newQucikReply);
		quickreply.clickNewQuickReplies();
		WaitForElementToBeVisible(quickreply.L_shortNameField);
		Thread.sleep(2000);
		quickreply.enterQuickReply(gandomWordGenerate());
		Thread.sleep(2000);
		quickreply.enterShortCut(4);
		quickreply.clickSubmit();
		boolean isDisplayed = ElementDisplayed(quickreply.L_popupcreate);
		if(isDisplayed) {
			assertEquals(isDisplayed, true);
			ExtentSuccessMessage("Quick Reply Created Successfully");
		}else {
			ExtentErrorMessage("Quick Reply Not Created");
		}
	}
	
}
