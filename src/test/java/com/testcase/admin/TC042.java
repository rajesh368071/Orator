package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC042 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Theme Live Chat Console Tab");
		refreshBrowser();
		//ExtentTestManager.startTest("40) Verify Theme Live Chat Console Tab");
		home.clickSettings();	
		theme.clickSystem();
		theme.clickTheme();
		WaitForElementToBeVisible(theme.L_theme_title);
		theme.clickLiveChatConsole();
		boolean color = ElementDisplayed(theme.L_brand_logo);
		if(color == true) {
			assertEquals(color, true);
			ExtentSuccessMessage("Theme Live Chat Console Working");
		}
		
	}

}
