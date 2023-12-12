package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC025 extends AdminSuit {
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Able to Disable Anonymous chat request Option");
		WaitForPageLoad();
		//ExtentTestManager.startTest("25) Verify Able to Disable Anonymous chat request Option");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		Thread.sleep(5000);
		
		if(isChecked(formwelcome.L_goAnynomousCheckBox)) {
			formwelcome.clickGoAnynomous();
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
		
		boolean isGoAnynomousDisplayed = ElementDisplayedNegative(chatbed.L_goAnynomousenduser);
		
		if(isGoAnynomousDisplayed) {
			assertEquals(isGoAnynomousDisplayed, false);
			ExtentSuccessMessage("Go Anynomous Option Not displayed");	
		}
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		
		/*assertEquals(true, true);
		ExtentSuccessMessage("Address FIeld Deleted ");	*/
		formwelcome.clickGoAnynomous();
		WaitForElementToBeVisible(formwelcome.L_submit);
		formwelcome.clickSubmit();
		
		Thread.sleep(3000);
		
	}
}
