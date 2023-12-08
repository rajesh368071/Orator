package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC019 extends AdminSuit{
	
	String welcomeMessage = "Hello there, thank you for visiting.";
	
	public void common() throws AWTException, IOException, InterruptedException {
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		Thread.sleep(1000);
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		assertEquals(GetELementValue(chatbed.L_message), welcomeMessage);
		Thread.sleep(2000);
		driver.switchTo().window(parent);
		
	}
	
	public void verifySameWelcomeMessage() throws InterruptedException, AWTException, IOException {
		log.info("Verify Opening Message Displayed in Enduser as Given in Admin");
		refreshBrowser();
		//ExtentTestManager.startTest("19) Verify Opening Message Displayed in Enduser as Given in Admin");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		WaitForElementToBeVisible(formwelcome.L_opening_msg);
		Thread.sleep(5000);
		formwelcome.enterOpeningMessage(welcomeMessage);
		Thread.sleep(2000);
		formwelcome.clickSubmit();
		common();
		
	}

}
