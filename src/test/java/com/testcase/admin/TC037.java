package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC037 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Update Business Hours");
		refreshBrowser();
		ExtentTestManager.startTest("37) Verify Able to Create New Business Hours");
		home.clickSettings();
		businesshours.clickGroup();
		businesshours.clickBusinessHours();
		businesshours.clickEdit();
		businesshours.enterBusinessHours(fakedata.getRandom());
		businesshours.enterTimeZone();
		businesshours.enterStatus();
		businesshours.enterStarttime("09:00AM");
		businesshours.enterEndtime("06:00PM");
		businesshours.enterFrom();
		businesshours.enterTo();
		businesshours.clickSubmit();
			
		boolean isPopUpDisplayed = ElementDisplayed(businesshours.L_popupupdate);
		
		if(isPopUpDisplayed) {
			assertEquals(isPopUpDisplayed, true);
			ExtentSuccessMessage("Business Hours Update Successfully");
		}
	}
	
}
