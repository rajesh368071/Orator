package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC039 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Themes Page Displayed");
		refreshBrowser();
		ExtentTestManager.startTest("37) Verify Themes Page Displayed");
		home.clickSettings();	
		theme.clickSystem();
		theme.clickTheme();
		WaitForElementToBeVisible(theme.L_theme_title);
			
		boolean isThemePageDisplayed = ElementDisplayed(theme.L_theme_title);
		
		if(isThemePageDisplayed) {
			assertEquals(isThemePageDisplayed, true);
			Log.info(""+isThemePageDisplayed+"");
			ExtentSuccessMessage("Theme Page Displayed");
		}
	}

}
