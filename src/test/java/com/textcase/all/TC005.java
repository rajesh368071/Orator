package com.textcase.all;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC005 extends AllTestcases{
	
	@Test
	public void verifyChatWithMeOption() throws InterruptedException {
		ExtentTestManager.startTest("To verify that the user can initiate chat with an agent by clicking on Chat with an agent option");
		WaitForElementToBeVisible(chatbed.L_chat);
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WaitForElementToBeVisible(chatbed.L_faq);
		chatbed.clickChatwithus();
		Thread.sleep(4000);
		ScrollUntilElementVisible(chatbed.L_firstname);
		assertEquals(ElementDisplayed(chatbed.L_firstname), true);
	}
	
}
