package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC017 extends AdminSuit{
	
	public void verifyWelcomePage() throws InterruptedException {
		log.info("Verify Forms Welcome Page Displayed");
		ExtentTestManager.startTest("17) Verify Forms Welcome Page Displayed");
		refreshBrowser();
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		boolean isvisible = ElementDisplayed(formwelcome.L_webwidget);
		if(isvisible) {
			assertEquals(isvisible, true);
			ExtentSuccessMessage("Welcome Page Displayed ");
		} else {
			assertEquals(isvisible, true);
			ExtentErrorMessage("Welcome Page is not Displayed");
		}
	}

}
