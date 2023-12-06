package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC002 extends AgentSuit {
	
	
	public void verifyChatAnalyst() throws InterruptedException {
		log.info("Verify Chat Analyst Page Displayed");
		
		//ExtentTestManager.startTest("(2) Verify Chat Analyst Page Displayed");
		routedchat.clickReviewBord();
		reviewboard.clickChatAnalist();
		
		boolean isChatAnalystDisplayed = ElementDisplayed(reviewboard.L_chatResolutionTime);
		if(isChatAnalystDisplayed) {
			assertEquals(isChatAnalystDisplayed, true);
			ExtentSuccessMessage("Chat Analistics Page Displayed");
		}
		
	}

}
