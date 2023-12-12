package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC010 extends AdminSuit{
	
	
	public void categoryPageVerify() throws InterruptedException {
		log.info("10) Verify Category Page is Displayed");
		//ExtentTestManager.startTest("10) Verify Category Page is Displayed");
		WaitForPageLoad();
		home.clickSettings();
		category.clickChat();
		category.clickCategories();
		WaitForElementToBeVisible(category.L_newCategory);
		String categoryURL = driver.getCurrentUrl();
		if(categoryURL.equals("https://s3po-demo.speridian.com/oratordemoadmin/admin/tags")) {
			assertEquals(categoryURL, "https://s3po-demo.speridian.com/oratordemoadmin/admin/tags");
			ExtentSuccessMessage("Successfully Category Page Displayed "+ categoryURL);
		}else {
			ExtentErrorMessage("Category Page is not displayed Insted "+ categoryURL);
			softAssertion.assertTrue(false);
		}
	}
	
}
