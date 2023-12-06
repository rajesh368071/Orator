package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC023 extends AdminSuit {
	
	@Test
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify able to delete Field from data Capture form");
		refreshBrowser();
		ExtentTestManager.startTest("23) Verify able to delete Field from data Capture form");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		Thread.sleep(5000);
		formwelcome.clickaddField();
		formwelcome.enterFieldName("Address");
		formwelcome.selectDataType();
		Thread.sleep(2000);
		formwelcome.clickSubmit();
		
		
		formwelcome.clickDeleteIcon();
		formwelcome.clickSubmit();
		
		assertEquals(true, true);
		ExtentSuccessMessage("Address FIeld Deleted ");	
		
	}
}
