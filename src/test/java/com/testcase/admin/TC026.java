package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC026 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Enable Wramp Up Aggrement Option");
		refreshBrowser();
		//ExtentTestManager.startTest("26) Verify Able to Enable Wramp Up Aggrement Option");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		Thread.sleep(5000);
		
		if(!isChecked(formwelcome.L_wrampupAggrementCheckBox)) {
			formwelcome.clickwrampupAggrement();
			System.out.print("is checked");
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
		
		boolean isWrampUpAggrementDisplayed = ElementDisplayed(chatbed.L_acceptAggrementenduser);
		
		if(isWrampUpAggrementDisplayed) {
			assertEquals(isWrampUpAggrementDisplayed, true);
			ExtentSuccessMessage("Wramp Up Aggrement Option displayed");	
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		
		
	}
}
