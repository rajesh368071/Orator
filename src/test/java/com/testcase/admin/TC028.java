package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC028 extends AdminSuit {
	

	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Holiday Group Page displayed");
		refreshBrowser();
		//ExtentTestManager.startTest("28) Verify Holiday Group Page displayed");
		home.clickSettings();
		holidaygroup.clickGroup();
		holidaygroup.clickHoliday();
		boolean isHolidayGroupPageDisplayed = ElementDisplayed(holidaygroup.L_holidayPageTitle);
		if(isHolidayGroupPageDisplayed) {
			assertEquals(isHolidayGroupPageDisplayed, true);
			ExtentSuccessMessage("Holiday Group Page Displayed");
		}
	}
	
}
