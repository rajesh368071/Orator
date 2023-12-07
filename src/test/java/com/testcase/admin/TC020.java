package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC020 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify data capture form displayed when respective check box is checked");
		refreshBrowser();
		//ExtentTestManager.startTest("20) Verify data capture form displayed when respective check box is checked");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		Thread.sleep(5000);
		if(!isChecked(formwelcome.L_data_capture_form_checkbox)) {
			formwelcome.clickDataCaptureForm();
			System.out.print("is un-checked");
		}
		Thread.sleep(2000);
		formwelcome.clickSubmit();
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		chatbed.clickChatwithus();
		ScrollUntilElementVisible(chatbed.L_firstname);
		boolean isFirstNameVisible = ElementDisplayed(chatbed.L_firstname);
		if(isFirstNameVisible) {
			assertEquals(isFirstNameVisible, true);
			ExtentSuccessMessage("Data Capture Form Displayed Successfully ");	
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		
	}
}
