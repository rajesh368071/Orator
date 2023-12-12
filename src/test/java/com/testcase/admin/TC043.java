package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC043 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Theme Chat Widget Tab");
		WaitForPageLoad();
		//ExtentTestManager.startTest("40) Verify Theme Chat Widget Tab");
		home.clickSettings();	
		theme.clickSystem();
		theme.clickTheme();
		WaitForElementToBeVisible(theme.L_theme_title);
		theme.clickLiveChatConsole();
		boolean value = ElementDisplayed(theme.L_brand_logo);
		if(value == true) {
			assertEquals(value, true);
			ExtentSuccessMessage("Theme Chat Widget displayed");
		}
		
	}

}
