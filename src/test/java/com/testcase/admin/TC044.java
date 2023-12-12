package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import com.Utility.Log;
import com.extentReports.ExtentTestManager;

public class TC044 extends AdminSuit {
	
	public void verifyConfigurationPageDisplayed() throws InterruptedException, AWTException, IOException {
		log.info("Verify Configuration Page Displayed");
		WaitForPageLoad();
		home.clickSettings();	
		category.clickChat();
		configuration.clickConfiguration();
		WaitForElementToBeVisible(configuration.L_configuration_title);
		String value = GetELementValue(configuration.L_configuration_title);
		assertEquals(value, "Configuration");
	}

}
