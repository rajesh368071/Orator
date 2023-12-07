package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC033 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException {
		log.info("Verify Able to Create New Manage Group");
		refreshBrowser();
		//ExtentTestManager.startTest("33) Verify Able to Create New Manage Group");
		home.clickSettings();
		managegroup.clickGeneral();
		managegroup.clickManageGroup();
		managegroup.clickAddNew();
		managegroup.enterGroupName(fakedata.getCompany());
		managegroup.clickSubmit();
		boolean isPopUpDisplayed = ElementDisplayed(managegroup.L_popupmanagecreate);
		
		if(isPopUpDisplayed) {
			assertEquals(isPopUpDisplayed, true);
			ExtentSuccessMessage("Manage Create Successfully");
		}
		
	}

}
