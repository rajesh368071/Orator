package com.testcase.admin;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC018 extends AdminSuit {
	public void verifyFaq() throws InterruptedException, AWTException, IOException {
		log.info("Verify FAQ Button is Displayed if FAQ is Checked in Admin");
		
		//ExtentTestManager.startTest("18) Verify FAQ Button is Displayed if FAQ is Checked in Admin");
		WaitForPageLoad();
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		boolean value = isEnabled(formwelcome.L_faq);
		if(!value) {
			formwelcome.clickFAQ();
		}
		formwelcome.clickSubmit();
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		boolean isFqaVisible = ElementDisplayed(chatbed.L_faq);
		if(true) {
			WaitForElementToBeVisible(chatbed.L_faq);
			assertEquals(isFqaVisible, true);
			chatbed.clickFQA();
		}
		//driver.findElement(By.xpath("//textarea[@class='chat-input-text']")).sendKeys("Hellow ");
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(parent);
	}
	
}
