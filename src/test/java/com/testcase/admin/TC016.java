package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC016 extends AdminSuit{
	
	public void verifyCreateQuickReply() throws InterruptedException {
		log.info("Verify able to Create New Quick Reply");
		//ExtentTestManager.startTest("16) Verify able to Create New Quick Reply");
		WaitForPageLoad();
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
		Thread.sleep(2000);
		assertEquals(isDisplayed, true);
		ExtentSuccessMessage("Quick Reply Created Successfully");
	}
	
}
