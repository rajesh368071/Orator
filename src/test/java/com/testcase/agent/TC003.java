package com.testcase.agent;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC003 extends AgentSuit {
	
	@Test
	public void verifyChatAnalyst() throws InterruptedException {
		log.info("Verify CX Metrics Page Displayed");
		
		ExtentTestManager.startTest("(3) Verify CX Metrics Page Displayed");
		routedchat.clickReviewBord();
		reviewboard.clickCXMatrics();
		
		boolean isCXMetricsDisplayed = ElementDisplayed(reviewboard.L_CSATscore);
		if(isCXMetricsDisplayed) {
			assertEquals(isCXMetricsDisplayed, true);
			ExtentSuccessMessage("Chat Analistics Page Displayed");
		}
		
	}

}
