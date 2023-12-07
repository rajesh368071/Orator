package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC032 extends AdminSuit{
	
	public void verifySameWelcomeMessage() throws InterruptedException {
		log.info("Verify Manage Group Page Displayed");
		refreshBrowser();
		//ExtentTestManager.startTest("32) Verify Manage Group Page Displayed");
		home.clickSettings();
		managegroup.clickGeneral();
		managegroup.clickManageGroup();
		boolean isManageGroupPageDisplayed = ElementDisplayed(managegroup.L_manage_group_title);
		if(isManageGroupPageDisplayed) {
			assertEquals(isManageGroupPageDisplayed, true);
			ExtentSuccessMessage("Manage Group Page Displayed");
		}
	}

}
