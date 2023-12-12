package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC022 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to add New Field to Data Capture Form");
		//refreshBrowser();
		WaitForPageLoad();
		//ExtentTestManager.startTest("22) Verify Able to add New Field to Data Capture Form");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		
		if(!isEnabled(formwelcome.L_data_capture_form_checkbox)) {
			formwelcome.clickDataCaptureForm();
		}
		
		formwelcome.clickaddField();
		formwelcome.enterFieldName("Location");
		formwelcome.selectDataType();
		formwelcome.clickSubmit();
		Thread.sleep(2000);
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		chatbed.clickChatwithus();
		
		boolean isNewFieldVisible = ElementDisplayed(chatbed.L_addedField);
		
		if(isNewFieldVisible) {
			assertEquals(isNewFieldVisible, true);
			ExtentSuccessMessage("Newly added Field is Displayed ");	
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		
		formwelcome.clickDeleteIcon();
		formwelcome.clickSubmit();
		Thread.sleep(6000);
	}
}
