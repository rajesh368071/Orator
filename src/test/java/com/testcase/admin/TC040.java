package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC040 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Theme Change Popup Displayed");
		refreshBrowser();
		ExtentTestManager.startTest("40) Verify Theme Change Popup Displayed");
		home.clickSettings();	
		theme.clickSystem();
		theme.clickTheme();
		WaitForElementToBeVisible(theme.L_theme_title);
		Thread.sleep(2000);
		boolean check = isChecked(theme.L_first_theme);
		
		if(check == true) {
			theme.clickThemeRadio(2);
			theme.clickPreview(2);
		} else {
			theme.clickThemeRadio(1);
			theme.clickPreview(1);
		}
		theme.clickApplyTheme();
		boolean isPreviewPopUpDisplayed = ElementDisplayed(theme.L_preview_popup);
		if(isPreviewPopUpDisplayed == true) {
			assertEquals(isPreviewPopUpDisplayed, true);
			ExtentSuccessMessage("Theme Changed popup displayed");
		}
	}

}
