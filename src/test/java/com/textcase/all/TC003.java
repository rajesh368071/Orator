package com.textcase.all;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BasePackage.Base_Class;
import com.Utility.FakeData;
import com.Utility.Log;
import com.aventstack.extentreports.Status;
import com.extentReports.ExtentManager;
import com.extentReports.ExtentTestManager;
import com.listeners.TestListener;
import com.orator.pages.WelcomePage;
import com.pages.endusers.ChatbedPage;

public class TC003 extends AllTestcases{
	
	
	@Test
	public void verifyFqaChatWithMeOption() throws InterruptedException {
		ExtentTestManager.startTest("To verify that the user can choose the FAQ option and view the list of pre-fed FAQs");
		WaitForElementToBeVisible(chatbed.L_chat);
		chatbed.clickChatButton();
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		WaitForElementToBeVisible(chatbed.L_faq);
		chatbed.clickFQA();
		Thread.sleep(2000);
		assertEquals(ElementDisplayed(chatbed.L_faq_queries), true);
	}

}
