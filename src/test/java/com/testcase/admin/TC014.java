package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC014 extends AdminSuit{
	
	@Test(priority = 14)
	public void verifyQuickRepliesPage() throws InterruptedException {
		log.info("Verify Quick Reply Page displayed");
		ExtentTestManager.startTest("14) Verify Quick Reply Page displayed");
		refreshBrowser();
		home.clickSettings();
		category.clickChat();
		quickreply.clickQuickReplies();
		WaitForElementToBeVisible(quickreply.L_newQucikReply);
		String quickreplyURL = driver.getCurrentUrl();
		if(quickreplyURL.equals("https://s3po-demo.speridian.com/oratordemoadmin/admin/quickReplies")) {
			assertEquals(quickreplyURL, "https://s3po-demo.speridian.com/oratordemoadmin/admin/quickReplies");
			ExtentSuccessMessage("Successfully Quick Reply Page Displayed "+ quickreplyURL);
		}else {
			ExtentErrorMessage("Quick Reply Page is not displayed Insted "+ quickreplyURL);
			softAssertion.assertTrue(false);
		}
	}
	
}
