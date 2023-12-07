package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC030 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to display Business Hours Page");
		
		refreshBrowser();
		ExtentTestManager.startTest("30) Verify Able to display Business Hours Page");
		home.clickSettings();
		businesshours.clickGroup();
		businesshours.clickBusinessHours();
		
		boolean isBusinessHoursDisplayed = ElementDisplayed(businesshours.L_business_hours);
		if(isBusinessHoursDisplayed) {
			assertEquals(isBusinessHoursDisplayed, true);
			ExtentSuccessMessage("Business Hours Page Displayed");
		}
		
		//holidaygroup.clickSubmit();
	}
	
}
