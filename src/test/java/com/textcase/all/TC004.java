package com.textcase.all;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC004 extends AllTestcases{
	
	@Test
	public void verifyFqaOptionReply() throws InterruptedException {
		ExtentTestManager.startTest("To verify that the user can choose an FAQ and view answer to the FAQ");
		WaitForElementToBeVisible(chatbed.L_chat);
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WaitForElementToBeVisible(chatbed.L_faq);
		chatbed.clickFQA();
		Thread.sleep(2000);
		chatbed.clickQuery();
		Thread.sleep(2000);
		assertEquals(GetELementValue(chatbed.L_faqreply), "First, confirm that your settings of your freezer are correct. Check the seal on the freezer. An overactive freezer will cause freezing parts of the refrigerator. Also, if the temperature of you room drops below freezing, your refrigerator may freeze.");
		log.info(GetELementValue(chatbed.L_faqreply));
	}
}
