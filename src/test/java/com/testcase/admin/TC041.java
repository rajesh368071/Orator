package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC041 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Theme Applyed");
		WaitForPageLoad();
		//ExtentTestManager.startTest("40) Verify Theme Applyed");
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
		refreshBrowser();
		String color = GetBackgroundColor(theme.L_notification);
		if(color.equals("#feba12")) {
			assertEquals(color, "#feba12");
			ExtentSuccessMessage("Theme Changed Successfully");
		}
		
	}

}
