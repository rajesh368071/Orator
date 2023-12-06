package com.testcase.admin;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.extentReports.ExtentTestManager;

public class TC018 extends AdminSuit {
	
	@Test
	public void verifyFaq() throws InterruptedException, AWTException, IOException {
		log.info("Verify FAQ Button is Displayed if FAQ is Checked in Admin");
		refreshBrowser();
		ExtentTestManager.startTest("18) Verify FAQ Button is Displayed if FAQ is Checked in Admin");
		home.clickSettings();
		formwelcome.clickGeneral();
		formwelcome.clickForms();
		formwelcome.clickWelcomepage();
		formwelcome.clickFAQ();
		if(isChecked(formwelcome.L_faq)) {
			formwelcome.clickFAQ();
			System.out.print("is un-checked");
		} else {
			formwelcome.clickFAQ();
			System.out.print("is checked");
		}
		
		openNewTab();
		Thread.sleep(1000);
		String parent = driver.getWindowHandle();
		SwitchtoTab(1);
		driver.get(configloader().getProperty("EndUser_URL"));
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		boolean isFqaVisible = ElementDisplayed(chatbed.L_faq);
		if(isFqaVisible) {
			WaitForElementToBeVisible(chatbed.L_faq);
			chatbed.clickFQA();
		}
		driver.findElement(By.xpath("//textarea[@class='chat-input-text']")).sendKeys("Hellow ");
		Thread.sleep(5000);
		driver.close();
		driver.switchTo().window(parent);
		
	}
	
}
