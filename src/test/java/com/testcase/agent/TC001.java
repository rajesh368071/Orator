package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC001 extends AgentSuit{

	public void verifyAgentPart() throws InterruptedException {
		log.info("Verify Review Bord Page is Displayed");
		//ExtentTestManager.startTest("(1) Verify Review Bord Page is Displayed");
		routedchat.clickReviewBord();
		WaitForElementToBeVisible(routedchat.L_reviewbordtitle);
		boolean isReviewBordDisplayed = ElementDisplayed(routedchat.L_reviewbordtitle);
		assertEquals(isReviewBordDisplayed, false);
	}
}
