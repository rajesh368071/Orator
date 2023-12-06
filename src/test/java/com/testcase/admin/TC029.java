package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC029 extends AdminSuit {
	
	@Test
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Create New Holiday Group");
		refreshBrowser();
		ExtentTestManager.startTest("29) Verify Able to Create New Holiday Group");
		home.clickSettings();
		holidaygroup.clickGroup();
		holidaygroup.clickHoliday();
		WaitForElementToBeVisible(holidaygroup.L_holidayPageTitle);
		holidaygroup.clickAddNew();
		holidaygroup.enterName(fakedata.getRandom());
		holidaygroup.selectRegion();
		holidaygroup.selectRole();
		//holidaygroup.clickCancel();
		holidaygroup.clickSubmit();
		boolean isPopUpDisplayed = ElementDisplayed(holidaygroup.L_popupcreate);
		
		if(isPopUpDisplayed) {
			assertEquals(isPopUpDisplayed, true);
			ExtentSuccessMessage("Holiday Group Created Successfully");
		}
	}
	
}
