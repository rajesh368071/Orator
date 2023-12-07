package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC034 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException {
		log.info("Verify Able to Perform Search in Manage Group");
		refreshBrowser();
		//ExtentTestManager.startTest("34) Verify Able to Perform Search in Manage Group");
		home.clickSettings();
		managegroup.clickGeneral();
		managegroup.clickManageGroup();
		managegroup.enterSearch("PPP");
		managegroup.clickSearch();
		String text = driver.findElement(managegroup.L_table_data).getText();
		assertEquals(text, "PPP");
	}

}
