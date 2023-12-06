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

public class TC002 extends AllTestcases{
	
	@Test
	public void verifyFqaChatWithMeOption() throws InterruptedException {
		ExtentTestManager.startTest("verify that the user is presented with options to access FAQs and Chat with agent on opening end user url");
		WaitForElementToBeVisible(chatbed.L_chat);
		chatbed.clickChatButton();
		
		Thread.sleep(2000);
		
		driver.switchTo().frame(0);
		assertEquals(ElementDisplayed(chatbed.L_chatwithus), true);
	}

}

