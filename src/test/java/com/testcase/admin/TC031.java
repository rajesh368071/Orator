package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC031 extends AdminSuit {
	
	@Test
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Create New Business Hours");
		refreshBrowser();
		ExtentTestManager.startTest("31) Verify Able to Create New Business Hours");
		home.clickSettings();
		businesshours.clickGroup();
		businesshours.clickBusinessHours();
		businesshours.clickAddNew();
		businesshours.enterBusinessHours(fakedata.getRandom());
		businesshours.enterTimeZone();
		businesshours.enterStatus();
		businesshours.enterStarttime("09:00AM");
		businesshours.enterEndtime("06:00PM");
		businesshours.enterFrom();
		businesshours.enterTo();
		businesshours.clickSubmit();
			
		boolean isPopUpDisplayed = ElementDisplayed(businesshours.L_popupcreate);
		
		if(isPopUpDisplayed) {
			assertEquals(isPopUpDisplayed, true);
			ExtentSuccessMessage("Business Hours Created Successfully");
		}
	}
	
}
